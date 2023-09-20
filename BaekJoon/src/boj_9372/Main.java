package boj_9372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] plane,dist;
	static int T,N,M,ans;
	static boolean[] visited;
	static Queue<Integer>q;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			q=new LinkedList<>();
			N=sc.nextInt();
			M=sc.nextInt();
			ans=0;
			dist=new int[N+1][N+1];
			plane=new int[N+1][N+1];
			visited=new boolean[N+1];
			
			
			for(int i=0; i<M; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				plane[a][b]++;
				plane[b][a]++;
				
			}
			//그래프 완성!
			visited[1]=true;
			BFS(1);
			
			System.out.println(ans);
		}//tc
		
		
	}//main

	private static void BFS(int r) {
		q.add(r);
		
		while(!q.isEmpty()) {
			
			int t=q.poll();
			visited[t]=true;
			
			for(int i=1; i<=N; i++) {
				if(plane[t][i]>0 ) {
					for(int j=1; j<=N; j++) {
						int tmp=0;
						if(plane[i][j]==1) tmp++;
						if(visited[i] && tmp>1 || !visited[i]) {
							q.add(i);
							
						}
					}
				}
			}
			
			boolean tmp=false;
			for(int i=1; i<=N; i++) {
				if(visited[i]==false) tmp=true;
			}
			if(!tmp) return;
			ans++;
		}
		
	}
}//class
