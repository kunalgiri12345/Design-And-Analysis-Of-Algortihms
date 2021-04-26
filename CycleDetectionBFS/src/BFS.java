import java.util.*;

class BFS  {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the no. of vertex : ");
	    int V = sc.nextInt();
	    int parent[] = new int[V + 1];
		ArrayList <Integer> adj[] = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++)
			adj[i] = new ArrayList<Integer>();
		ArrayList<Integer> path = new ArrayList<>();
		while(true) {
			System.out.println("Enter the source(-1 to exit) : ");
			int source = sc.nextInt();
			System.out.println("Enter the destination(-1 to exit) : ");
			int dest = sc.nextInt();
			if(source == -1 && dest == -1)
				break;
			path.add(source);
			path.add(dest);
			addEdge(adj, source, dest);
		}
		if (isCyclicDisconntected(adj, V, parent)) {
		  System.out.println("Yes, there is a cycle..");
		  System.out.println("Path of cycle is ");
		  for(int i = 0; i < path.size()-1; i += 2) {
			  if(i != path.size()-2)
				  System.out.print(path.get(i) + " -- " + path.get(i+1) + ", ");
			  else
				  System.out.println(path.get(i) + " -- " + path.get(i+1));
		  }
		}
		else
		  System.out.println("No, there is not a cycle..");
		
		sc.close();
	}
	static void addEdge(ArrayList<Integer> adj[], int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	static boolean isCyclicConntected(ArrayList<Integer> adj[], int s, int V, boolean visited[], int parent[]) {
		
		Arrays.fill(parent, -1);
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.poll();
	        for (int i = 0; i < adj[u].size();i++) {
		        int v = adj[u].get(i);
		        if (!visited[v]) {
		          visited[v] = true;
		          q.add(v);
		          parent[v] = u;
		        }
		        else if (parent[u] != v) {
		        	return true;
		        }
		     }
		}
		 return false;
	}
	static boolean isCyclicDisconntected(ArrayList<Integer> adj[], int V, int[] parent) {
	    boolean visited[] = new boolean[V + 1];
	    for (int i = 1; i <= V; i++)
	      if (!visited[i] && isCyclicConntected(adj, i, V, visited, parent)) {
	    	  return true;
	      }
	    return false;
	}
}