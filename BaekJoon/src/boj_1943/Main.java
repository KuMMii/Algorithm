package boj_1943;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int tc=0; tc<3; tc++) {
			int N=sc.nextInt(); //coin quan
			int[] coin=new int[N];
			int money=0;
			
			for(int i=0; i<N; i++) {
				coin[i]=sc.nextInt();
				money+=coin[i]*sc.nextInt();
			}
			
			//반 나눈 값을 목표로
			money/=2;
			int[] dp=new int[money+1];
			
			
			//받은 개수보다 많이 더하게 되면 안되는 것도 추가해야함!
			//select coin
			for(int i=0; i<N; i++) {
				//select money
				for(int m=1; m<=money; m++) {
					if(m-coin[i]>0 &&dp[m-coin[i]]>0) {
						dp[m]+=dp[m-coin[i]];
					}else if(m==coin[i]) dp[m]++;
				}
			}
			
			if(dp[money]>0) System.out.println(1);
			else System.out.println(0);
		}//tc
		
		
	}//main
}//class
