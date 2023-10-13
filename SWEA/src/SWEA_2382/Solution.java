package SWEA_2382;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class bug{
		int R;
		int C;
		int Q;
		int D;
		public bug(int r, int c, int q, int d) {
			super();
			R = r;
			C = c;
			Q = q;
			D = d;
		}
		
	}
	static int N,M,K;
	static List<bug>[][] list;
	static int[] dr= {0,-1,1,0,0};
	static int[] dc= {0,0,0,-1,1};
	static Queue<bug> q;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_2382/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			K=sc.nextInt();
			
			list=new ArrayList[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					list[i][j]=new ArrayList<>();
				}
			}
			
			q=new LinkedList<>();
			for(int i=0; i<K; i++) {
				int r1=sc.nextInt();
				int c1=sc.nextInt();
				int q1=sc.nextInt();
				int d1=sc.nextInt();
				q.add(new bug(r1,c1,q1,d1));
			}
			//입력 완~!
			
			move();
			q.clear();
			System.out.printf("#%d %d\n",tc,1);
			
		}//tc
		
	}//main

	public static void move() {
		
		for(int m=0; m<K; m++) {
			int T=q.size();
			for(int t=0; t<T; t++) {
				bug bug=q.poll();
				System.out.println("R:"+bug.R);
				System.out.println("C:"+bug.C);
				System.out.println("Q:"+bug.Q);
				System.out.println("D:"+bug.D);
				System.out.println();
				int r=bug.R+dr[bug.D];
				int c=bug.C+dc[bug.D];
				
				//우선 다 담아줘야함
				list[r][c].add(new bug(r,c,bug.Q,bug.D));
			}//t
			
			//리스트에 저장된 애들 찾기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					//한개인경우
					if(list[i][j].size()==1) {
						//가장자리인경우
						if((i==0||i==N-1||j==0||j==N-1)&& list[i][j].get(0).Q/2>0) {
							int d=(list[i][j].get(0).D+2)%4;
							if(d==0) d=4;
							q.add(new bug(i,j,list[i][j].get(0).Q/2,d));
						}else {
							q.add(new bug(i,j,list[i][j].get(0).Q,list[i][j].get(0).D));
						}
						
						
						
					}
					//두개이상
					else if(list[i][j].size()>1) {
						int L=list[i][j].size();
						int max=0;
						int quan=0;
						int dir=0;
						for(int l=0; l<L; l++ ) {
							bug b=list[i][j].get(l);
							quan+=b.Q;
							if(max<b.Q) {
								max=Math.max(max, b.Q);
								dir=(b.D+2)%4;
								if(dir==0) dir=4;
								
							}
						}
						q.add(new bug(i,j,quan,dir));
					}//2개 이상
					
					
					list[i][j].clear();
				}
			}
			System.out.println("----------------------------");
			
			
		}//m
		
		int sum=0;
		for(bug b : q) {
			sum+=b.Q;
		}
		System.out.println(sum);
		
	}//move
}//class
