package boj_1463;

import java.util.Scanner;

public class Main {
	static int[] num=new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.close();
		
		//initialization
		num[1]=0;
		num[2]=1;
		num[3]=1;
		
		for(int i=4; i<=N; i++) {
			if(num[i]==0) {
				int tmp=0;
				
				//'-1'+num[-1]
				num[i]=num[i-1]+1;
				//'/2'+num[i/2]
				if(i%2==0) {
					tmp=num[i/2]+1;
					num[i]=Math.min(tmp, num[i]);
				}
				//'/3'+num[i/3]
				if(i%3==0) {
					tmp=num[i/3]+1;
					num[i]=Math.min(tmp, num[i]);
				}
			}
		}
		System.out.println(num[N]);
		
	}//main
}//class
