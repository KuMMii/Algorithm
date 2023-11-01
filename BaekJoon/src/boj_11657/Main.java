package boj_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class node{
		int s;
		int e;
		int t;
		public node(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}
		
	}//node
	
	static int N,M; //city, bus
	static int[] time; 
	static node[] edges;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		time=new int[N+1]; //1~N cities
		edges=new node[M];
		
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			
			edges[i]=new node(s,e,t);
		}//for
		
		/////////////input fin///////////////////
		
		Arrays.fill(time, Integer.MAX_VALUE);
		time[edges[0].s]=0;
		
		//loop for count of node times(N)
		for(int i=1; i<=N; i++) {
			//init visited
			visited=new boolean[N+1];
			//loop all the edges
			visited[edges[0].s]=true;
			for(int j=0; j<M;j++) {
				node n=edges[j];
				
				//////////////////
				System.out.println();
				System.out.println(i+"회");
				System.out.printf("(%d,%d,%d)\n",n.s,n.e,n.t);
				System.out.println(Arrays.toString(time));
				/////////////////////
				if(time[n.s]==Integer.MAX_VALUE) continue;
				
				if(time[n.e]>time[n.s]+n.t) {
					time[n.e]=time[n.s]+n.t;
					visited[n.e]=true;
				}
				
				System.out.println(Arrays.toString(time));
			}
			
		}
		
		//check if it has a cycle
		for(int j=0; j<M;j++) {
			node n=edges[j];
			
			if(time[n.e]>time[n.s]+n.t) {
				System.out.println(-1);
				return;
			}
			
		}
		
		for(int i=2; i<=N; i++) {
			if(time[i]==Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			else System.out.println(time[i]);
		}
		
		
		
	}//main
}//class
