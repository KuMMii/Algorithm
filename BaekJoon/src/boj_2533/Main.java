package boj_2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
	
	static int N;
	static boolean[] visited; //for bfs
	static boolean[] isEarly;
	static List<person> [] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		
		
		
		
		
		
		
		
		
	}//main
}//class
