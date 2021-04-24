import java.util.*;

public class Knapsack {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length : ");
		int n = sc.nextInt();
		int weight[] = new int[n];
		int price[] = new int[n];
		System.out.println("Enter the weight array : ");
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		System.out.println("Enter the price array : ");
		for(int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}
		System.out.println("Enter the total weight : ");
		int W = sc.nextInt();
		int dp[][] = new int[n + 1][W + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < W + 1; j++) {
				dp[i][j] = -1;
			}
		}
		int result = knapsack(n, W, weight, price, dp);
		System.out.println("Total maximum profit : " + result);

		sc.close();
	}
	public static int knapsack(int n, int W, int weight[], int price[], int dp[][]) {
		if(n == 0 || W == 0) return 0;
		if(dp[n][W] != -1)
			return dp[n][W];
		else if(weight[n-1] <= W) 
			return dp[n][W] = Math.max(price[n-1] + knapsack(n-1, W-weight[n-1], weight, price, dp), 
					knapsack(n-1, W, weight, price, dp));
		else 
			return dp[n][W] = knapsack(n-1, W, weight, price, dp);
	}
}
