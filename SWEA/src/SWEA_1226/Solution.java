package SWEA_1226;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int ans;
	//우하좌상
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1226/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			q=new LinkedList<int[]>();
			arr=new int[16][16];
			visited=new boolean[16][16];
			
			ans=0;
			sc.nextInt(); //tc버림
			
			for(int i=0; i<16; i++) {
				String tmp=sc.next();
				for(int j=0; j<16; j++) {
					arr[i][j]=tmp.charAt(j)-48;
				}
			}//for
			visited[1][1]=true;
			BFS(1,1);
			
			
			System.out.printf("#%d %d\n",tc, ans);
		}//tc
		
	}//main

	public static void BFS(int r, int c) {
		q.add(new int[] {r,c});

		while(!q.isEmpty()) {
		int now[]=q.poll();
		int nr=now[0];
		int nc=now[1];
			
			for(int i=0; i<4; i++) {
				int nextR=nr+dr[i];
				int nextC=nc+dc[i];
				
				if(!visited[nextR][nextC] && arr[nextR][nextC]!=1) {
					q.add(new int[] {nextR,nextC});
					visited[nextR][nextC]=true;
					if(arr[nextR][nextC]==3) {
						ans=1;
						return;
					}
				}
			}//for
		}//while
		
	}//bfs
}//class
