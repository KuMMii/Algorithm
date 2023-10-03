package boj_12865;

import java.util.Scanner;

//0/1 knapsack problem
public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); //quantity of goods
		int K=sc.nextInt(); //max KG
		int[][] dp=new int[N+1][K+1]; //array for dp
		int[] weight=new int[N+1];
		int[] p=new int[N+1];
		
		//input
		for(int i=1; i<=N; i++) {
			weight[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		
		//input fin
		
		
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=K;w++) {
				if(weight[i]<=w) dp[i][w]=Math.max(dp[i-1][w], dp[i-1][w-weight[i]]+p[i]);
				else dp[i][w]=dp[i-1][w];
			}
		}
		
		System.out.println(dp[N][K]);
		
	}//main
}//class
