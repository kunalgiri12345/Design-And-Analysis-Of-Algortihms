import java.util.*;

class PrimsAlgorithm {
	int minKey(int key[], Boolean primsSet[], int vertices) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < vertices; v++)
			if (primsSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		return min_index;
	}
	void printMST(int parent[], int graph[][], int vertices) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < vertices; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}
	void primMST(int graph[][], int edges, int vertices) {
		int parent[] = new int[vertices];
		int key[] = new int[vertices];
		Boolean primsSet[] = new Boolean[vertices];
		for(int i = 0; i < vertices; i++) {
			key[i] = Integer.MAX_VALUE;
			primsSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < vertices - 1; count++) {
			int u = minKey(key, primsSet, vertices);
			primsSet[u] = true;
			for (int v = 0; v < vertices; v++)
				if (graph[u][v] != 0 && primsSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		printMST(parent, graph, vertices);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of edges : ");
		int edges = sc.nextInt();
		System.out.println("Enter the no. of vertices : ");
		int vertices = sc.nextInt();
		PrimsAlgorithm pmst = new PrimsAlgorithm();
		int graph[][] = new int[edges][vertices];
		for(int i = 0; i < edges; i++) {
			for(int j = 0; j < vertices; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		pmst.primMST(graph, edges, vertices);
		sc.close();
	}
}