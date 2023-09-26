package boj_15650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[M];
		
		
		powerSet(1,0);

		
		
	}//main

	private static void powerSet(int at, int depth) {

		//recursion terminates
		if(depth==M) {
			System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		
		
		//basis
		for(int i=at; i<= N; i++) {
			arr[depth]=i;
			powerSet(i+1,depth+1);
		}
		
		
	}//perm
}//class
