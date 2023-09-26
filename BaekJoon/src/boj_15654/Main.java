package boj_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr,result;
	static int N,M;
	static boolean[] visited;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr=new int[N];
        result=new int[M];
        visited=new boolean[N];
        
        for(int i=0; i<N; i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
		perm(0);
		System.out.println(sb);
		
		
	}
	private static void perm(int idx) {
		if(idx==M) {
			for(int i =0; i<M; i++	) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				result[idx]=arr[i];
				visited[i]=true;
				perm(idx+1);
				visited[i]=false;
			}
		}
	}
}
