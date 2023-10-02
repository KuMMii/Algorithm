package boj_5585;

import java.util.Scanner;

public class Main {
	static int[] change=new int[1000];
	public static void main(String[] args) {
		change[1]=1;
		change[5]=1;
		change[10]=1;
		change[50]=1;
		change[100]=1;
		change[500]=1;
		
		Scanner sc=new Scanner(System.in);
		int money=1000-sc.nextInt();
		sc.close();
		
		//units
		for(int i=2; i<=9; i++) {
			if(change[i]==0) {
				change[i]=change[i-1]+1;
			}
		}
		
		//tens
		for(int i=20; i<=90; i+=10) {
			if(change[i]==0) {
				change[i]=change[i-10]+1;
			}
		}

		//hundreds
		for(int i=200; i<=900; i+=100) {
			if(change[i]==0) {
				change[i]=change[i-100]+1;
			}
		}
		
		int hundres=money/100*100;
		int tens=(money-hundres)/10*10;
		int units=money-hundres-tens;
		
		change[money]=change[hundres]+change[tens]+change[units];
		
		
		System.out.println(change[money]);
		
	}//main
}//class
