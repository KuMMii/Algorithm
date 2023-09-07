package SWEA_1217;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1217/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt(); //테케버림
			int N=sc.nextInt(); //밑
			int M=sc.nextInt(); //지수
			arr=new int[M+1];
			
			int ans=power(N,M);
			
			System.out.printf("#%d %d\n",tc, ans);
		}//tc
		
		
	}//main

	private static int power(int n, int m) {
		
		if(m==1) return n;
		if(m%2==0) { //지수가 짝수
			if(arr[m]==0) {
				arr[m]=power(n, m/2);
			}
			return arr[m]*arr[m];
		}
		
		if(m%2==1){ //지수 홀수
			if(arr[m]==0) {
				arr[m]=power(n, (m-1)/2);
			}
			return arr[m]*arr[m]*n;
		}
		return 0;	
		
	}//power
}
