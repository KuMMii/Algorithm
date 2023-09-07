package SWEA_1247;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	//for coordinate
	static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}//class pos
	
	static int N; //customers
	static Pos comp, home; //company, home coordinate
	static Pos[] custPos; //customers coordinate array
	static boolean[] visited; 
	static int ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1247/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			comp=new Pos(sc.nextInt(),sc.nextInt());
			home=new Pos(sc.nextInt(),sc.nextInt());
			
			custPos=new Pos[N];
			visited=new boolean[N];
			
			for(int i=0; i<N; i++) {
				custPos[i]=new Pos(sc.nextInt(),sc.nextInt());
			}
			
			ans=Integer.MAX_VALUE;
			
			perm(0,0,comp);
			System.out.printf("#%d %d\n",tc,ans);
		}//tc
	}//main
	
	
	
	public static void perm(int idx, int dist, Pos curr) {
		
		if(dist>ans) return;
		
		if(idx==N) {
			ans=Math.min(ans, dist+Math.abs(curr.x - home.x) + Math.abs(curr.y - home.y));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				//계속 값을 넣지않고 더해준 값을 파라미터로 넣으니까 0으로 초기화할 걱정이 없음
				perm(idx+1,dist+Math.abs(curr.x - custPos[i].x) + Math.abs(curr.y - custPos[i].y),custPos[i]);
				visited[i]=false;
			}
		}//for
	}//perm
	
}//class
