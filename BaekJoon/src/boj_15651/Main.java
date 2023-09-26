package boj_15651;

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
		perm(0);
		System.out.println(sb);
		
		
	}
	private static void perm(int idx) {
		if(idx==M) {
			for(int i =0; i<M; i++	) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[idx]=i;
			perm(idx+1);
		}
	}
}
