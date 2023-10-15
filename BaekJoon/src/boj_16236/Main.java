package boj_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import boj_16236.Main.coor.CoorComparator;

public class Main {
	static class coor{
		int r;
		int c;
		int s;
		public coor() {
		}		
		
		public coor(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public coor(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		static class CoorComparator implements Comparator<coor> {
			@Override
			public int compare(coor o1, coor o2) {
				if (o1.s != o2.s) {
					return Integer.compare(o1.s, o2.s);
				} else if (o1.r != o2.r) {
					return Integer.compare(o1.r, o2.r);
				} else {
					return Integer.compare(o1.c, o2.c);
				}
			}
		}
	}//coor

	
	static coor shark;
	static int N,min,cnt,totDist; //크기, 거리최솟값, 먹은 물고기개수,총 거리수
	static int[][] arr;
	static Queue<coor> q;
	static int[][] D= {{-1,1,0,0},{0,0,-1,1}}; //상하좌우
	static PriorityQueue<coor> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		
		
		
		for(int i=0;i<N; i++ ) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) shark=new coor(i,j,2);
				
			}
		}
		
		//input fin
		
		min=0;
		cnt=0;
		q=new LinkedList<>();
		
		while(true) {
			//지금 상태에서 물고기 몇개인지 확인
			int fishQuan=scan();
			
			////////////////
			System.out.println("물고기는 몇마리? : "+fishQuan);
			//////////////////////
			
			//스캔해서 더이상 작은 거 없으면 끝내기
			if(fishQuan==0) {
				System.out.println(totDist);
				return;
			}
			
			//가장 가까이 있는 물고기 담는 pq
			pq=new PriorityQueue<coor>(new CoorComparator());
			//먹은 물고기 리턴받음
			coor fish=findShortcut();
			
			//////////
			System.out.println("물고기거리 : "+fish.s);
			//////////
			
			totDist+=fish.s;
			
			//좌표 바꿔줌
			arr[shark.r][shark.c]=0;
			arr[fish.r][fish.c]=9;
			shark.r=fish.r;
			shark.c=fish.c;
			
			///////////////////////////
//			for(int[] ik: arr) {
//				System.out.println(Arrays.toString(ik));
//			}
//			System.out.println();
			
			
			
			cnt++;
			//먹은 고기수==상어크기
			if(cnt==shark.s) {
				shark.s++;
			}

		}
		
		
		
	}//main


	public static coor findShortcut() {
		//scan 돌렸을때 나온 고기들 큐에 담은거 돌려서 최소값 알아냄
		int fishes=q.size();
		//큐에 있는 물고기들 다 길이 재볼거임
		for(int i=0; i<fishes; i++) {
			BFS();
		}
		return pq.poll();
	}//findShortcut


	public static void BFS() {
		
		//bfs할때 쓸 q
		Queue <coor> bfsq=new LinkedList<>();
		//destination
		coor fish=q.poll();
		boolean[][] visited=new boolean[N][N];
		//curr pos
		bfsq.add(shark);
		
		int[][] dist=new int[N][N];
		
		while(!bfsq.isEmpty()) {
			coor co=bfsq.poll();
			int r=co.r;
			int c=co.c;
			visited[r][c]=true;
			
			if(r==fish.r&&c==fish.c) break;
			
			//상하좌우 돌리기
			for(int i=0; i<4; i++) {
				int nr=r+D[0][i];
				int nc=c+D[1][i];
				//범위 밖이면 버리기
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				//아직 간적 없고 상어 크기보다 같거나 작은 길이면 가넝
				if(!visited[nr][nc] && arr[nr][nc]<=shark.s ) {
					bfsq.add(new coor(nr,nc));
					dist[nr][nc]+=dist[r][c]+1;
					visited[nr][nc]=true;
					
					
				}
			}//for
			
			///////////////////////////
//			for(int[] ik: dist) {
//				System.out.println(Arrays.toString(ik));
//			}
//			System.out.println();
			///////////////////////////////
			
		}//while
		//최단값을 pq에 담음
		pq.add(new coor(fish.r,fish.c,dist[fish.r][fish.c]));
		
		
	}//BFS


	public static int scan() {
		
		//전체 돌기
		for(int i=0;i<N; i++ ) {
			for(int j=0; j<N; j++) {
				//물고기 크기
				int fish=arr[i][j];
				//작은 물고기 좌표, 크기 저장
				if(fish!=0 && fish<shark.s) {
					q.add(new coor(i,j,fish));
					
					/////////////출
//					System.out.println("fish:"+fish);
					///////////
					
				}
			}
		}
		//상어보다 작은 물고기 대기중
		return q.size();
		
		
	}//scan
}//class
