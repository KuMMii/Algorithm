package SWEA_1217;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution3 {
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1217/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt(); //테케버림
			int N=sc.nextInt(); //밑
			int M=sc.nextInt(); //지수
			arr=new int[M+1];
			
			power(N,M,1);
			
			System.out.printf("#%d %d\n",tc, arr[M]);
		}//tc
		
		
	}//main

	private static void power(int n, int m, int idx) {
		if(idx==1) arr[idx]=n;
		else {
			arr[idx]=n*arr[idx-1];
			if(idx==m) return;
		}
		power(n,m,++idx);
		
	}//power
}
