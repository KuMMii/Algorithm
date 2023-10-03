package boj_9084;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			//coin quan
			int N=sc.nextInt();
			int[] coin=new int[N];
			for(int i=0; i<N; i++) {
				coin[i]=sc.nextInt();
			}
			int money=sc.nextInt();
			//input fin
			
			int[] dp=new int[money+1];
			
			
			//selecting coin
			for(int i=0; i<N; i++) {
				//increasing price
				for(int p=1; p<=money; p++) {
					//when p is bigger than the selected coin, add previous p and p-coin
					if(p-coin[i]>0) dp[p]=dp[p]+dp[p-coin[i]];
					//if p=coin, then add 1
					else if(p-coin[i]==0) dp[p]++;
				}
			}
			System.out.println(dp[money]);
		}//tc
		sc.close();
	}//main
}//class
