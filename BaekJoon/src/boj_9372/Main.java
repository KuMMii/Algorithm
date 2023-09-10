package boj_9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Main {
	static int[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken()); //country
			int M=Integer.parseInt(st.nextToken()); //pilot
			
			tree=new int[(int)Math.pow(2, N-1)];
			visited=new boolean[N+1];
			
			for(int p=0; p<M; p++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				
				
				
				
			}//p
			
			
		}//tc
		
		
		
	}//main
}//class
