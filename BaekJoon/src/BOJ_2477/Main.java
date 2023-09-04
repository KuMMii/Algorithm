package BOJ_2477;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//빈칸 우좌하상
		int[] dr= {0,0,0,1,-1};
		int[] dc= {0,1,-1,0,0};
		
		//참외 개수
		int yum=sc.nextInt();
		
		int[][] blank=new int[1001][1001];

		int[][] xy=new int[6][2];
		xy[0][0]=500;
		xy[0][1]=500;
		
		for(int i=1; i<6; i++) {
			int dir=sc.nextInt();
			int len=sc.nextInt();
			
			xy[i][0]=xy[i-1][0]+dr[dir]*len;
			xy[i][1]=xy[i-1][1]+dc[dir]*len;
			
			//1늘릴 애들(겉에 선)
			for(int j=0; j<len;j++) {
				blank[xy[i-1][0]+dr[dir]][xy[i-1][1]+dc[dir]]++;
			}
			
		}//for 입력
		
		//직사각형 넓이를 아예 구할거임
		int rMin=Integer.MAX_VALUE;
		int rMax=Integer.MIN_VALUE;
		int cMin=Integer.MAX_VALUE;
		int cMax=Integer.MIN_VALUE;
		
		int[][] Pos=new int[4][2];
		
		for(int i=0; i<6; i++) {
			if(xy[i][0]<rMin) {
				rMin=xy[i][0];
				Pos[0][0]=xy[i][0];
				Pos[0][1]=xy[i][1];
			}
			if(xy[i][0]>rMax) {
				rMax=xy[i][0];
				Pos[1][0]=xy[i][0];
				Pos[1][1]=xy[i][1];
			}
			if(xy[i][1]<cMin) {
				cMin=xy[i][1];
				Pos[2][0]=xy[i][0];
				Pos[2][1]=xy[i][1];
			}
			if(xy[i][1]>cMax) {
				cMax=xy[i][1];
				Pos[3][0]=xy[i][0];
				Pos[3][1]=xy[i][1];
			}
		}
		
		int width=Math.abs(rMax-rMin);
		int height=Math.abs(cMax-cMin);
		
		int totalSpace=width*height;
		
		System.out.println(totalSpace);
		
		int zeroR=0;
		int zeroC=0;
		
		for(int i=0; i<4; i++) {
			if(blank[Pos[i][0]][Pos[i][1]]==0) {
				zeroR=Pos[i][0];
				zeroC=Pos[i][1];
			}
			System.out.println("r : "+Pos[i][0]);
			System.out.println("c : "+Pos[i][1]);
		}
		
		int tmp=zeroR;
		System.out.println(tmp);
		int rCnt=0;
		while(blank[tmp++][zeroC]==0) {
			rCnt++;
		}//while
		
		tmp=zeroC;
		int cCnt=0;
		while(blank[zeroR][tmp++]==0) {
			cCnt++;
		}//while
		
		int zeroSpace=rCnt*cCnt;
		
		System.out.println(zeroSpace);
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
