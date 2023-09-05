package SWEA_1247;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_teacher {
	static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static int N; //고객의 수
	static Pos comp, home; //회사, 집 좌표
	static Pos[] custPos; //고객 좌표
	static int ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1247/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			comp=new Pos(sc.nextInt(), sc.nextInt()); //company
			home=new Pos(sc.nextInt(), sc.nextInt()); //home
			
			custPos=new Pos[N];
			
			ans=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				custPos[i]=new Pos(sc.nextInt(),sc.nextInt());
			}//입력 및 초기화 완료
			
			perm(0,0,0,comp);
			System.out.printf("#%d %d\n",tc,ans);
		}//tc
	}//main

	//idx : 몇번째 자리인지
	//sel : 방문 쳌(visited boolean 배열을 만들지 않고 비트마스킹하려고)
	//dist : 중간결과 저장
	//curr : 현재 나의 좌표
	static void perm(int idx, int sel, int dist, Pos curr) {
		if(dist>=ans) return;
		
		//모든 고객 방문 완료
		if(idx==N) { //집으로 귀가
			//요기서 curr : 마지막 고객 집 좌표
			ans=Math.min(ans, dist+ Math.abs(curr.x-home.x)+Math.abs(curr.y-home.y));
			return;
		}
		
		for(int i=0; i<N; i++) {
			//고객 쳌
			if((sel & (1<<i))==0) {
				perm(idx+1, sel | (1<<i), dist+Math.abs(curr.x-custPos[i].x)+Math.abs(curr.y-custPos[i].y),custPos[i]);
			}
		}
		
		
		
		
	}
	
}//class
