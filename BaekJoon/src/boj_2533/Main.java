package boj_2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class person{
		int s;
		int e;
		public person(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
	}
	
	static int N,cnt, min;
	static boolean[] visited; //for bfs
	static boolean[] isEarly;
	static int[] perArr;
	static List<person> [] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		perArr=new int[N+1];
		list=new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		
		//input
		for(int i=1; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			list[s].add(new person(s,e));
			list[e].add(new person(e,s));
		}
		///////////////input fin
		
		min=Integer.MAX_VALUE;
		
		//얼리어답터 선택
		for(int i=1; i<=N; i++) {
			cnt=1;
			BFS(2);
		}
		
//		for(int i=1; i<=N; i++) {
//			for(int j=0; j<list[i].size(); j++) {
//				System.out.printf("(%d,%d)\n",list[i].get(j).s,list[i].get(j).e);
//			}
//		}
		
//		System.out.println(min);
		
		
		
		
	}//main

	public static void BFS(int idx) {
		
		visited=new boolean[N+1];
		isEarly=new boolean[N+1];
		Queue<person> q=new LinkedList<>();
		
		q.addAll(list[idx]);
		
		
//		System.out.println(list[idx]);
		
		
		isEarly[idx]=true;
		visited[idx]=true;
		
		
		while(!q.isEmpty()) {
//			System.out.println("visited : "+Arrays.toString(visited));
			//꺼내
			person p=q.poll();
			//도착 지점이 false여야 함
			if(!visited[p.e]) {
				//도착 지점의 연결 노드들 큐에 담고 방문으로 바꾸기
				q.addAll(list[p.e]);
				visited[p.e]=true;
				//도착지점이 얼리가 아니라면 연결된 노드들 다 e로 만들기
				if(!isEarly[p.e] ) {
					//연결된 노드들 리스트에 담기
					List<person> earlyChk=list[p.e];
					
					for(int i=0; i<earlyChk.size(); i++) {
						if(!isEarly[earlyChk.get(i).e]) {
							cnt++;
							isEarly[earlyChk.get(i).e]=true;
						}
					}
				}
			}
		}//while
		System.out.println(cnt);
		System.out.println("isEarly : "+Arrays.toString(isEarly));
		
		min=Math.min(min, cnt);
	}//bfs
}//class
