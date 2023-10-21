package boj_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class computer implements Comparable<computer>{
		int s;
		int e;
		int w;
		public computer() {
		}
		public computer(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(computer o) {
			return this.w-o.w;
		}
	}//computer

	static int N,M;
	static List<computer>[] graph;
	static boolean[] visited;
	static int[] arr; //무한대 담을 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[M];
		for(int i=0; i<M; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			graph[s].add(new computer(s,e,w));
//			graph[e].add(new computer(e,s,w));
		}
		
		visited=new boolean[N+1];
		arr=new int[N+1];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		Dijkstra(1);
		
//		int max=0;
//		for(int i=1; i<=N; i++) {
//			max=Math.max(max, arr[i]);
//		}
//		
//		System.out.println(max);
		
	}//main

	public static void Dijkstra(int idx) {
		PriorityQueue<computer> q=new PriorityQueue<>();
		arr[idx]=0;
		visited[idx]=true;
		q.addAll(graph[idx]);
		while(!q.isEmpty()) {
			computer t=q.poll();
			if (/* !visited[t.e]&& */arr[t.e]>arr[t.s]+t.w) {
				arr[t.e]=arr[t.s]+t.w;
				q.addAll(graph[t.e]);
				visited[t.e]=true;
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
	}//dijkstra
}//class
