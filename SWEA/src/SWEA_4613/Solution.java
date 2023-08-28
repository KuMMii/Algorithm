package SWEA_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static char[][] arr, tmp;
	static int sum,min,R,C,beforeUp,beforeDown,beforeSum;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4613/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=1; tc++) {
			
			sum=0;
			min=2500;
			
			R=sc.nextInt();
			C=sc.nextInt();
			
			arr=new char[R][C];
			
			//깃발 입력
			for(int i=0; i<R; i++) {
				String tmpStr=sc.next();
				arr[i]=tmpStr.toCharArray();
			}
			
			char[][] tmp=new char[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					tmp[i][j]=arr[i][j];
				}
			}
			
			for(int i=0;i<C; i++) {
				if(tmp[0][i]!='W') {
					sum++;
					tmp[0][i]='W';
				}
				if(tmp[R-1][i]!='R') {
					sum++;
					tmp[R-1][i]='R';
				}
				
			}//for 맨위아래 바꾸기
			
			//중간부분 B로 바꾸기
			for(int i=1; i<R-1; i++) {
				for(int j=0; j<C; j++) {
					if(tmp[i][j]!='B') {
						sum++;
					}
				}
			}//for i
			
			System.out.println("sum : "+sum);
			
			
			//두번째줄, 마지막에서 두번째줄부터 바꾸기 시작
			beforeUp=1;
			beforeDown=R-2;
			beforeSum=sum;
			
			System.out.println("bup : "+beforeUp+" bdown : "+beforeDown);
			
			middle(1,R-2);
			
			
			System.out.printf("#%d %d\n",tc,min);
		}//tc
		
	}//main
	
	

	private static void middle(int upIdx, int downIdx) {
		
		char[][] tmp=new char[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				tmp[i][j]=arr[i][j];
			}
		}

		if(downIdx-upIdx<0) return;
		
		
		sum=0;
		System.out.println("bup : "+beforeUp+" bdown : "+beforeDown+" bsum : "+beforeSum);

		System.out.println("up : "+upIdx+" down : "+downIdx );
		
		//다른 줄만 하면 되니까!
		int cnt=0;
		if(beforeUp!=upIdx && beforeDown!=downIdx) {//두줄 전부 다른 경우
			for(int j=0; j<C; j++) {
				//B바꿨던 거 빼주는 작업
				if(tmp[beforeUp][j]!='B') {
					cnt++;
				}
				if(tmp[beforeDown][j]!='B') {
					cnt++;
				}

				//이건 바꾸는 작업
				if(tmp[beforeUp][j]!='W') {
					sum++;
				}
				if(tmp[beforeDown][j]!='R') {
					sum++;
				}
				
				System.out.println("다 다른 경우");
				System.out.println("sum: "+sum);
				System.out.println("cnt: "+cnt);
				
			}//for
		}else if(beforeUp!=upIdx) {//윗줄 다른 경우
			for(int j=0; j<C; j++) {
				if(tmp[beforeUp][j]!='B') {
					cnt++;
				}
				
				if(tmp[beforeUp][j]!='W') {
					sum++;
				}
				
			}//for
			
			System.out.println("위 다른 경우");
			System.out.println("sum: "+sum);
			System.out.println("cnt: "+cnt);
			
		}else if(beforeDown!=downIdx) {//아랫줄 다른 경우
			for(int j=0; j<C; j++) {
				if(tmp[beforeDown][j]!='B') {
					cnt++;
				}
				
				if(tmp[beforeDown][j]!='R') {
					sum++;
				}
				
			}//for
			
			System.out.println("아래 다른 경우");
			System.out.println("sum: "+sum);
			System.out.println("cnt: "+cnt);
			
		}//if 다른 경우
		
		beforeSum-=cnt;
		
		sum+=beforeSum;
		
		min=Math.min(sum, min);
		
		beforeUp=upIdx;
		beforeDown=downIdx;
		beforeSum=sum;

		middle(upIdx+1,downIdx);
		middle(upIdx,downIdx-1);
		middle(upIdx+1,downIdx-1);
		
	}//middle
}//class
