package SWEA_1251;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
//Prim Ver
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
	static class Edge implements Comparable<Edge>{
		double st, ed, w;

		public Edge(double st, double ed, double w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}//compareTo

	}//edge
	
	
	static List<Edge>[] edgeList;
	static PriorityQueue<Edge> pq;
	static boolean[] visited;
	static double[][] node;
	static int N;
	static double E,ans;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1251/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			ans=0;
			pq=new PriorityQueue<>();
			N=sc.nextInt();
			node=new double[N][2];
			
			//x,y입력
			for(int i=0; i<N; i++) {
				node[i][0]=sc.nextDouble();
			}
			for(int i=0; i<N; i++) {
				node[i][1]=sc.nextDouble();
			}
			
			E=sc.nextDouble();
			
			///입력 완
			
			//list에 Edge를 담아줘야함
			edgeList=new ArrayList[N];
			
			//초기화
			for(int i=0; i<edgeList.length; i++) {
				edgeList[i]=new ArrayList<Edge>();
			}
			
			//edgeList에 간선 전부 넣기
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					//거리 구하기
					double x=node[i][0]-node[j][0];
					double y=node[i][1]-node[j][1];
					
					double len=Math.pow(x, 2)+Math.pow(y, 2);
					
					edgeList[i].add(new Edge(i,j,len));
					edgeList[j].add(new Edge(j,i,len));
				}
			}
			
			visited=new boolean[N];
			visited[0]=true;
			Prim(0);
			
			System.out.printf("#%d %d\n",tc, Math.round(ans));
		}//tc
	}//main


	private static void Prim(int idx) {
		pq.addAll(edgeList[idx]);
		int pick=0;
		
		while(pick!=N-1) {
			
			Edge e=pq.poll();
			if(!visited[(int) e.ed]) {
				ans+=E*e.w;
				pq.addAll(edgeList[(int) e.ed]);
				visited[(int) e.ed]=true;
				pick++;
			}
		}
		
		
		
	}
}//class