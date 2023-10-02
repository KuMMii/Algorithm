package boj_2775;

import java.util.Scanner;

public class Main {
	static int[][] arr=new int[15][15];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int K=sc.nextInt(); //floor
			int N=sc.nextInt(); //house num
			
			if(arr[0][N]==0) { //값이 넣어지지 않은 상태
				//0층 초기화
				for(int i=1; i<=N; i++) {
					arr[0][i]=i;
				}
			}
				
				//DP
				//밑층부터 올라오기
				for(int k=1; k<=K; k++) {
					//내 층의 호수까지 더하는 반복문
					for(int n=1; n<=N; n++) {
						//값이 저장되지 않았을때만 추가작업
						if(arr[k][n]==0) {
							//이게 메모리, 시간을 아주 조금 덜 씀
							arr[k][n]=arr[k-1][n]+arr[k][n-1];
							
						}
					}
				}
				System.out.println(arr[K][N]);
		}//tc
	}//main
}//class
