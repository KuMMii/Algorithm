package boj_15649;

import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr, result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//자연수
		N=sc.nextInt();
		//길이
		M=sc.nextInt();
		
		//숫자 입력받기
		arr=new int[N];
		result=new int[M];
		for(int i=1; i<=N; i++) {
			arr[i-1]=i;
		}
		
		visited=new boolean[N+1];
		
		//return의 idx, 
		perm(0);
		
		
	}//main

	public static void perm(int idx) {
		
		
		//recursion terminates
		if(idx==M) {
			for(int i : result) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		//basis
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				result[idx]=arr[i];
				visited[i]=true;
				perm(idx+1);
				visited[i]=false;
				
			}
			
		}
		
		
		
		
		
		
		
		
	}
}//class
