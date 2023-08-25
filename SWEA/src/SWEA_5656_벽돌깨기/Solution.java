package SWEA_5656_벽돌깨기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int[][] arr;
	public static int[][] save;
	public static int[][] tmp;
	static int W;
	static int H;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_5656_벽돌깨기/input.txt"));
		Scanner sc= new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1; tc<=1; tc++) {
			
			int N=sc.nextInt(); //횟수
			W=sc.nextInt(); //width	헷갈리지만 c
			H=sc.nextInt(); //height r
			
			//숫자 담기
			arr= new int[H][W];
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					arr[r][c]=sc.nextInt();
				}
			}
			
			
			//위에서 4칸을 봤을 때 첫번째로 1보다 큰 칸의 좌표를 저장하는 2차원 배열 
			save=new int[H][2];
			
			int idx=0;
			
			//맨 윗칸에서 4칸 확인 해보기
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					if(arr[r][c]>=1&&(r-1<0||arr[r-1][c]==0)) {//그 열의 맨 위의 블럭 찾음!
						//이제 밑으로 4칸 보기~!
						for(int i=0; i<4; i++) {//4칸 밑으로 확인
							if(r+i<H) {
								if(arr[r+i][c]>=2) { //2보다 큰 애 찾으면 저장
									//좌표 저장하고 break;
									save[idx][0]=r+i;
									save[idx][1]=c;
									idx++;
									break;
								}//if 2보다 큰 애 찾았을 때
								
							} // for r+i범위제한
						}//for 4
						
					}//if 맨 위블럭
				}//for c
			}//for r
			
			//좌표 저장 성공했다 대박...
			
			//이제 부수자,,,
			
			idx=0;
			int min=180; //0이 아닌 블럭의 개수의 최소값을 담는 변수
			
			//save 배열의 0,0이 의미가 없어지는 때까지 돌리기
			while(arr[save[idx][0]][save[idx][1]]>=2) {
				min=180;
				//멀티버스용 배열 생성..
				tmp= new int[H][W];
				for(int r=0; r<H; r++) {
					for(int c=0; c<W; c++) {
						tmp[r][c]=arr[r][c];
					}
				}
				
				
				int r=save[idx][0];
				int c=save[idx][1];
				
				//지금 좌표 위에 깬다고 생각했을 때
				for(int i=0; i<r; i++) {
					tmp[i][c]=0;
				}
				
				int p= N-(r-1); //위에 깨고 이제 남은 횟수
				
				//아니 근데 p번해야하는데 첫번째는 그렇다 치고 두번재 시작점은 어떻게 정하지...?
				
				//부수기
				crash(r,c);
				
				int cnt=0;
				
				//남은 것들 개수세기
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						if(tmp[i][j]!=0) {
							cnt++;
						}
					}
				}
				
				//최솟값
				min=Math.min(min, cnt);
				
				//인덱스 늘리기
				idx++;
			}//while
			
			
			System.out.printf("#%d %d",tc,min);
		}//tc
		
	}//main

	//부수는 메서드
	private static void crash(int r, int c) {
		
		int num=tmp[r][c];
		
		tmp[r][c]=0;
		
		//그 숫자 좌우 밑으로 num-1만큼 0으로 만들기
		for(int i=1; i<num; i++) {
			//우선 좌우부터 보자
			if(c+i<W) {//오른쪽 범위 내에 있을 때
				if(tmp[r][c+i]==1) { //얘네가 1이면 0으로 
					tmp[r][c+i]=0;
				}else if(tmp[r][c+i]>=2) { //2 이상이면,,,,,또 재귀
					crash(r, c+i);
				}
			}//오른쪽 범위인지 if
			
			if(c-i>=0) {//왼쪽 범위 내에 있을 때
				if(tmp[r][c-i]==1) { //얘네가 1이면 0으로 
					tmp[r][c-i]=0;
				}else if(tmp[r][c-i]>=2) { //2 이상이면,,,,,또 재귀
					crash(r, c-i);
				}
			}//왼쪽 범위인지 if
			
			//좌우 끝~!
			
			//이제 아래
			if(r+i<H) {//아래 범위 내에 있을 때
				if(tmp[r+i][c]==1) { //얘네가 1이면 0으로 
					tmp[r+i][c]=0;
				}else if(tmp[r+i][c]>=2) { //2 이상이면,,,,,또 재귀
					crash(r+i, c);
				}
			}//아래 범위인지 if
			
			
		}//for num-1
		
		
	}
}//class
