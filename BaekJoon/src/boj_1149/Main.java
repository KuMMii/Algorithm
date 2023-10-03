package boj_1149;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] R=new int[N+1];
		int[] G=new int[N+1];
		int[] B=new int[N+1];
		int[] dp=new int[N+1];
		
		//GRB input
		for(int i=1; i<=N; i++) {
			R[i]=sc.nextInt();
			G[i]=sc.nextInt();
			B[i]=sc.nextInt();
		}
		
		char flag='r';
		int sum=0;
		for(int i=1; i<=N; i++) {
			if(i==1) {
				dp[i]=Math.min(R[i], G[i]);
				if(dp[i]==G[i]) flag='r';
				else flag='g';
				dp[i]=Math.min(dp[i],B[i]);
				if(dp[i]==B[i]) flag='b';
			}else {
				if(flag=='r') dp[i]=Math.min(G[i], B[i]);
					if(dp[i]==G[i]) flag='r';
					else flag='b';
				
				if(flag=='g') dp[i]=Math.min(R[i], B[i]);
					if(dp[i]==R[i]) flag='r';
					else flag='b';
				
				if(flag=='b') dp[i]=Math.min(R[i],G[i]);
					if(dp[i]==R[i]) flag='r';
					else flag='g';
			}
			sum+=dp[i];
			
			System.out.println(flag);
		}
		
		
		System.out.println(sum);
		
	}//main
}//class
