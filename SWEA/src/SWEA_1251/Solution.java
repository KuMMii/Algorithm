package SWEA_1251;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static Integer[][] node,line; //line -x,y,weight
	static Integer[] p; 
	static int N;
	static double E;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1251/input.txt"));
		Scanner sc =new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			node=new Integer[N][2];
			line=new Integer[N*(N-1)/2][3];
			p=new Integer[N]; //key, weight;
			
			for(int i=0; i<N;i++) {
				p[i]=i; //key
			}
			
			
			for(int i=0; i<N; i++) { //x좌표
				node[i][0]=sc.nextInt();
			}
			for(int i=0; i<N; i++) { //y좌표
				node[i][1]=sc.nextInt();
			}
			E=sc.nextDouble(); //환경부담금
			
			///입력완
			int idx=0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					line[idx][0]=i; //st node
					line[idx][1]=j; //ed node
					
					Integer tmpX=node[i][0]-node[j][0];
					Integer tmpY=node[i][1]-node[j][1];
					
					
					line[idx++][2]=(int) (Math.pow(tmpX, 2)+Math.pow(tmpY, 2));
					
				}
			}//weight
			
//			System.out.println(Arrays.deepToString(line));
			
			//sort
			Arrays.sort(line, new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					return o1[2]-o2[2];
				}
			});//ascending
			
//			System.out.println(Arrays.deepToString(line));
			
			double ans=kruskal();
			
			System.out.printf("#%d %d\n",tc,Math.round(ans));
		}//tc
		
	}//main
	
	
	private static double kruskal() {
		int pick=0;
		double ans=0;
		for(int i=0; i<N*(N-1)/2; i++) {
			int st=findSet(line[i][0]);
			int ed=findSet(line[i][1]);
			if(st!=ed) {
				union(st,ed);
				ans=ans+E*line[i][2];
				pick++;
			}
			
			if(pick==N-1) break;
		}
		
		return ans;
		
	}
	private static void union(int st, int ed) {
		p[ed]=st;
	}
	
	private static Integer findSet(Integer i) {
		if(i!=p[i]) {
			p[i]=findSet(p[i]);
		}
		return p[i];
	}//findSet
}//class
