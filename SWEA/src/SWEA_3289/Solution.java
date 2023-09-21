package SWEA_3289;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int a, b,n,m;
	static int[] arr;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/SWEA_3289/input.txt"));
//		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc=new StringTokenizer(br.readLine(), " ");
		
		
		
		int T=Integer.parseInt(sc.nextToken());
		for(int tc=1; tc<=T; tc++) {
			sc=new StringTokenizer(br.readLine(), " ");
			n=Integer.parseInt(sc.nextToken()); //자연수 개수
			m=Integer.parseInt(sc.nextToken()); //입력개수
			ans=new StringBuilder();
			
			arr=new int[n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i]=i;
			}//입력 완
			
			for(int M=0; M<m; M++) {
				sc=new StringTokenizer(br.readLine(), " ");
				int f=Integer.parseInt(sc.nextToken());
				a=Integer.parseInt(sc.nextToken());
				b=Integer.parseInt(sc.nextToken());
				
				switch (f) {
				case 0: //union
					union(a,b);
					break;
				
				case 1: //check
					ans.append(check(a,b));
					break;

				default:
					break;
				}
				
				
			}//입력문
			System.out.printf("#%d %s\n", tc,ans );
		}//tc
		
		
	}//main

	public static String check(int x, int y) {
		String tmp="1";
		if(fieldset(x)!=fieldset(y)) tmp="0";
		return tmp;
	}

	private static void union(int x, int y) {
		int px=fieldset(x);
		int py=fieldset(y);
		
		if(px!=py) arr[py]=px;
	}//union

	private static int fieldset(int i) {
			if(i!=arr[i]) arr[i]=fieldset(arr[i]);
		return arr[i];
	}//fieldset
}//class
