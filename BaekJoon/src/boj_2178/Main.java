package boj_2178;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr, dist;
	static boolean[][] visited;
	static int N,M;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		
		
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		dist=new int[N][M];
		visited=new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp=sc.next();
			for(int j=0; j<M; j++) {
				arr[i][j]=tmp.charAt(j)-48;
			}
		}//for
		
		visited[0][0]=true;
		dist[0][0]++;
		BFS(0,0);
		
		System.out.println(dist[N-1][M-1]);
	}//main

	private static void BFS(int r, int c) {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int now[]=q.poll();
			int nr=now[0];
			int nc=now[1];
			
			for(int i=0; i<4; i++) {
				int nextR=nr+dr[i];
				int nextC=nc+dc[i];
				
				if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
					if(arr[nextR][nextC]==1 && !visited[nextR][nextC]) {
						q.add(new int[] {nextR, nextC});
						visited[nextR][nextC]=true;
						dist[nextR][nextC]=dist[nr][nc]+1;
					}
				}
				
			}
			
			
		}//while
		
		
		
	}//bfs
}//class
