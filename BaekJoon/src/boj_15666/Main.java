package boj_15666;

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
        
        for(int i=0; i<N; i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited=new boolean[N];
        
		perm(0,0);
		System.out.println(sb);
		
		
	}
	private static void perm(int at, int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++	) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before=0;
		
		for(int i=at; i<N; i++) {
			if(before!=arr[i]) {
				result[idx]=arr[i];
				before=arr[i];
				perm(i,idx+1);
				
			}
		}
	}
}
