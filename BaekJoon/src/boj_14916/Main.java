package boj_14916;

import java.util.Scanner;

public class Main {
	static int[] change=new int[1000001];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int money=sc.nextInt();
		sc.close();
		
		change[1]=-1;
		change[2]=1;
		change[3]=-1;
		change[5]=1;
		
		if(money>3) {
			for(int i=4; i<=money; i++) {
				int with2=0;
				int with5=0;
				
				if(change[i]==0) {
					if(change[i-2]!=-1) {
						with2=change[i-2]+1;
					}
					if(i>5 && change[i-5]!=-1) {
						with5=change[i-5]+1;
					}
					if(with2>0 && with5>0) 
						change[i]=Math.min(with2, with5);
					else change[i]=with2>0 ? with2 : with5;
				}
			}
			
		}
		
		
		System.out.println(change[money]);
		
	}//main
}//class
