package boj_10158;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int C=sc.nextInt();
		int R=sc.nextInt();
		
		//first position
		int c=sc.nextInt();
		int r=sc.nextInt();
		
		//time
		int T=sc.nextInt();
		
		
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
