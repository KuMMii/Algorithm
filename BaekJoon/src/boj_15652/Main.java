package boj_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N,M;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer strT = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(strT.nextToken());
        M = Integer.parseInt(strT.nextToken());
		
        arr=new int[M];
		perm(1,0);
		System.out.println(sb);
		
		
	}
	private static void perm(int at, int idx) {
		if(idx==M) {
			for(int i =0; i<M; i++	) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=at; i<=N; i++) {
			arr[idx]=i;
			perm(i,idx+1);
		}
	}
}
