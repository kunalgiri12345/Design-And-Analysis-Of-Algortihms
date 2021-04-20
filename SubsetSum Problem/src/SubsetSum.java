import java.util.*;
import java.io.*;

class SubsetSum
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc = new FastReader();
	    System.out.println("Enter the length of array : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the array : ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the sum : ");
		int sum = sc.nextInt();
		System.out.println(subsetSum(arr, n, sum));
	}
	public static boolean subsetSum(int arr[], int n, int sum) {
		boolean dp[][] = new boolean[2][sum + 1];
		for(int i = 0; i <= n; i++) {
			dp[i%2][0] = true;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(arr[i-1] <= j) {
					dp[i%2][j] = dp[(i-1)%2][j-arr[i-1]] || dp[(i-1)%2][j];
				}
				else {
					dp[i%2][j] = dp[(i-1)%2][j];
				}
			}
		}
		return dp[n%2][sum];
	}
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}