package boj_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class ball{
		int R;
		int C;
		int M;
		int S;
		int D;
		public ball(int r, int c, int m, int s, int d) {
			R = r;
			C = c;
			M = m;
			S = s;
			D = d;
		}
	}//ball
	
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	static int N,M,K,r,c,m,s,d;//가로세로길이,공개수,횟수,좌표,질량,속력,방향
	static int[][][] arr;
	static Queue<ball> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1][5];//질량m,속력s, 방향d의 홀수짝수, 방향d
		q=new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			
			q.add(new ball(r,c,m,s,d));
		}
		br.close();
		////input fin
		
		//K번 돌리기
		for(int k=0; k<K; k++) {
			//큐에 있는만큼만 돌리기
			int T=q.size();
			//arr에 정보 다 더해서 저장
			for(int t=0; t<T; t++) {
				ball b=q.poll();
				
				//////공 출력
//				System.out.println(k+1+"회");
//				System.out.printf("좌표 : (%d, %d), 질량 : %d, 속력 : %d, 방향 : %d\n", b.R,b.C,b.M, b.S,b.D);
				
//				System.out.printf("%d %d %d\n",b.M,b.S,b.D);
				//공의 새로운 위치
				int ballR=Math.abs(b.R+dr[b.D]*b.S)%N;
				if(ballR==0) ballR=N;
				else if(ballR<0) ballR=ballR+N+1;
				
				int ballC=Math.abs(b.C+dc[b.D]*b.S)%N;
				if(ballC==0) ballC=N;
				else if(ballC<0) ballC=ballC+N+1;
				
//				System.out.printf("R : %d, C : %d\n", ballR,ballC);
				
				arr[ballR][ballC][0]+=b.M;
				arr[ballR][ballC][1]+=b.S;
				arr[ballR][ballC][2]++;
				arr[ballR][ballC][3]+=(b.D%2);
				arr[ballR][ballC][4]+=b.D;
			}//arr에 덧셈끝
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					
					
					
					int quan=arr[i][j][2];
					//1개인 경우는 큐에 바로 추가
					if(quan==1) {
						q.add(new ball(i,j,arr[i][j][0],arr[i][j][1],arr[i][j][4]));
						
						
					}
					//1개 이상이면 수술...들어가야함
					else if(quan>1) {
						//질량이 0인 경우는 걍..넘어가기
						if(Math.floor(arr[i][j][0]/5)==0) continue;
						//아닌 경우면 4개로 나눠줘야함
						else{
							//방향이 전부 짝수/홀수
							if(arr[i][j][3]==0 || arr[i][j][3]==quan) {
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),0));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),2));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),4));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),6));
							}else {
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),1));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),3));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),5));
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][2]/quan),7));
							}
						}
						
						
					}
					
					
				}
			}
			/////////////////////////
			//출력
//			for(int I=1; I<=N; I++) {
//				for(int J=1; J<=N; J++) {
//					System.out.print(arr[I][J][0]+" ");
//							System.out.print(arr[I][J][2]+" ");
//					
//				}
//				System.out.println();
//			}
			
			/////////////////////////////////
//			System.out.println();
			//0으로 초기화
			for(int I=1; I<=N; I++) {
				for(int J=1; J<=N; J++) {
					for(int z=0; z<4; z++) {
						arr[I][J][z]=0;
					}
					
				}
			}
			
//			for(ball Ball : q) {
//				System.out.println(Ball.M);
//			}
			
			
		}//K번 돌리기
		
		int ans=0;
		for(ball Ball : q) {
			ans+=Ball.M;
		}
		
		System.out.println(ans);
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(arr[i][j][0]+" ");
//			}
//			System.out.println();
//		}
		
		
	}//main
}//class
