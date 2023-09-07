package boj_10158;

import java.util.Scanner;

public class Main {
	static int arr[][];
	static int R,C,r,c,T;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		C=sc.nextInt();
		R=sc.nextInt();
		
		//first position
		c=sc.nextInt();
		r=sc.nextInt();
		
		//time
		T=sc.nextInt();
		
		arr=new int[R+1][C+1];
		
		//둘 다 +,+
		int moveR=1;
		int moveC=1;
		
		for(int i=0; i<T; i++) {
//			System.out.println("(r,c) = "+ r+","+c);
			//왼 오 위 아 벽 순
			if(c==0 || c==C) moveC*=(-1);
			if(r==0 || r==R) moveR*=(-1); 
			
			r+=moveR;
			c+=moveC;
		}//for
		
		System.out.println(c+" "+r);
		
		
		
		
		
	}//main

}//class
