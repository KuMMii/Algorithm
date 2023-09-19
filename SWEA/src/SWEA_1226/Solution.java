package SWEA_1226;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static boolean[] visited;
	static int ans;
	static Queue q;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1226/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		q=new LinkedList<>();
		ans=0;
		int N=sc.nextInt();
		int M=sc.nextInt();
		arr=new int[N][M];
		visited=new boolean[N];
		
		for(int i=0; i<N; i++) {
			String tmp=sc.next();
			for(int j=0; j<N; j++) {
				arr[i][j]=tmp.charAt(j)-48;
			}
		}//for
		
		BFS(0);
		
		System.out.println(ans);
	}//main

	private static void BFS(int v) {
		q.add(v);
		visited[v]=true;
		
	}
}//class
