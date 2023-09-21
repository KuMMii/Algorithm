package SWEA_7465;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] p; //값, 랭크
	static int[][] adjArr; //인접행렬
	static int a,b, cnt,N,M;
	static boolean[] visited;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_7465/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			p=new int[N+1][2];
			adjArr=new int[N+1][N+1];
			visited=new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				p[i][0]=i;
			}
			for(int m=0; m<M; m++) {
				a=sc.nextInt();
				b=sc.nextInt();
				
				adjArr[a][b]=1;
				adjArr[b][a]=1;
				
				
			}//관계입력
			
			cnt=1;
			makeGroup(1);
			
			System.out.printf("#%d %d\n",tc, cnt);
			
			
		}//tc
		
	}//main
	public static void makeGroup(int idx) {
		Queue<Integer> q=new LinkedList<>();
		q.add(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int t=q.poll();
			for(int i=1; i<=N; i++) { //column
				if(!visited[i] && adjArr[t][i]==1) { //선택한 적 없는 거랑 연결된 상태일 때
					q.add(i);
					visited[i]=true;
					union(t,i);
				}
				
			}//bfs로
			
		}//while
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				cnt++;
				makeGroup(i); //아직 false로 남은 인덱스로 또 이 메서드하기
				return;
			}
		}
		return;
		
	}//makeGroup
	
	private static void union(int t, int i) {
		link(findSet(t), findSet(i));
		
	}//union
	
	private static void link(int t, int i) {
		int rankT=p[t][1];
		int rankI=p[i][1];
		
		if(rankT>rankI) {
			p[i][0]=t;
		}else {
			p[t][0]=i;
			if(rankT==rankI) p[i][1]++;
		}
		
	}//link
	
	private static int findSet(int x) {
		if(x!=p[x][0]) {
			p[x][0]=p[findSet(p[x][0])][0];
		}
		return p[x][0];
	}//findSet
	
}//class
