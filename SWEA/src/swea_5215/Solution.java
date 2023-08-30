package SWEA_5215;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int[] score,Kcal;
	static int max,N,L;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_5215/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt(); //재료의 수
			L=sc.nextInt(); //Kcal limit
			
			score=new int[N];
			Kcal=new int[N];
			
			
			//재료 점수, 칼로리 담기
			for(int i=0; i<N; i++) {
				score[i]=sc.nextInt();
				Kcal[i]=sc.nextInt();
			}
			
			max=0;
			
			//idx, kcal, score
			eat(0, 0, 0);
			
			
			System.out.printf("#%d %d\n",tc,max);
		}//tc
	}//main

	private static void eat(int idx, int kcal, int sc) {
		//recursion terminates
		if(kcal>L) return; //제한 넘어감
		else max=Math.max(sc, max);
		
		//index ends
		if(idx==N) return;
		
		//recursive case
		eat(idx+1, kcal+Kcal[idx], sc+score[idx]);
		eat(idx+1, kcal, sc);
	}//eat
}//class
