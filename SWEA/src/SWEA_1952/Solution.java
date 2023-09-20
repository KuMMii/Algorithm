package SWEA_1952;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] months, arr;
	static int d, m, m3,ans;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1952/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();	
		
		for(int tc=1; tc<=T; tc++) {
			
			months=new int[12];
			arr=new int[7];
			
			d=sc.nextInt();
			m=sc.nextInt();
			m3=sc.nextInt();
			//1년권을 기본으로 깔고 감
			ans=sc.nextInt();
			
			int[] tmp=new int[12];
			for(int i=0; i<12; i++) {
				months[i]=sc.nextInt();
				tmp[i]=months[i];
			}
			//입력끝
			
			DFS(0,0);
			
			
			System.out.printf("#%d %d\n",tc, ans);
		}//tc
		
		
	}//main


	private static void DFS(int month, int price) {
		//recursion terminates
		if(month>=12) {
			ans=Math.min(ans, price);
			return;
		}
		
		DFS(month+1,price+months[month]*d);
		DFS(month+1, price+m);
		DFS(month+3, price+m3);
		
		
	}//dfs
}//class
