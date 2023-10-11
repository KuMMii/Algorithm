package SWEA_1953;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	//coordinate class
	static class coor{
		int R;
		int C;
		public coor(int r, int c) {
			R = r;
			C = c;
		}
	}//coor

	static int N,M,L,cnt; //row, col, time,cnt
	//상하좌우
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int[][] arr; //input
	static int[][] dir= {{0,0,0,0},{1,1,1,1},{1,1,0,0},{0,0,1,1},{1,0,0,1},{0,1,0,1},{0,1,1,0},{1,0,1,0}}; //1~7까지 방향
	static boolean[][] visited; 
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/SWEA_1930/input2.txt"));
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			cnt=1;
			
			
			
			
			arr=new int[N][M];
			visited=new boolean[N][M];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//input fin
			
			
			BFS(new coor(r,c));
				
			
			
			System.out.printf("#%d %d\n",tc,cnt);
		}//tc
		br.close();
	}//main

	public static void BFS(coor co) {
		//depth를 표시하는 배열
		int[] tmp=new int[L];
		Queue<coor> q=new LinkedList<>();
		q.add(co);
		tmp[0]++;
		
		//현재 depth에 q에 추가한 수량을 담아줌
		for(int n=1; n<L; n++) {
			//담은 만큼 돌리기
			for(int p=0; p<tmp[n-1]; p++) {
				coor t=q.poll();
				int r=t.R;
				int c=t.C;
				visited[r][c]=true;
				
				//상하좌우 가능한지 확인
				for(int i=0; i<4; i++) {
					//해당 좌표의 파이프의 방향 확인. 1이면 있는거임
					if(dir[arr[r][c]][i]==1) {
						int nr=r+dr[i];
						int nc=c+dc[i];
						
						//범위 내에 있는지
						if(nr<0||nr>=N||nc<0||nc>=M)  continue;
						//있으면 방문체크
						else if(!visited[nr][nc]) {
							
							//상
							if(i==0 && (arr[nr][nc]==1 ||arr[nr][nc]==2 ||arr[nr][nc]==5 ||arr[nr][nc]==6)) {
								q.add(new coor(nr,nc));
								
								tmp[n]++;
								visited[nr][nc]=true;
								cnt++;
							//하
							}else if(i==1 && (arr[nr][nc]==1 ||arr[nr][nc]==2 ||arr[nr][nc]==4 ||arr[nr][nc]==7)) {
								q.add(new coor(nr,nc));
								
								tmp[n]++;
								visited[nr][nc]=true;
								cnt++;
							//좌
							}else if(i==2 && (arr[nr][nc]==1 ||arr[nr][nc]==3 ||arr[nr][nc]==4 ||arr[nr][nc]==5)) {
								q.add(new coor(nr,nc));
								
								tmp[n]++;
								visited[nr][nc]=true;
								cnt++;
							
							//우
							}else if(i==3 && (arr[nr][nc]==1 ||arr[nr][nc]==3 ||arr[nr][nc]==6 ||arr[nr][nc]==7)) {
								q.add(new coor(nr,nc));
								
								tmp[n]++;
								visited[nr][nc]=true;
								cnt++;
							}
							
						}
					}
				}
				
			}
			
		}//while
		
		
	}//bfs
	
}//class
