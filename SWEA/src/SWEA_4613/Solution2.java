package SWEA_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
	static char[][] arr;
	static int sum,min,R,C;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4613/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			sum=0;
			min=2500;
			
			R=sc.nextInt();
			C=sc.nextInt();
			
			arr=new char[R][C];
			
			//깃발 입력
			for(int i=0; i<R; i++) {
				String tmp=sc.next();
				arr[i]=tmp.toCharArray();
			}
			
			//두번째줄, 마지막에서 두번째줄부터 바꾸기 시작
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
		
//		System.out.println("up : "+upIdx+" down : "+downIdx );
		
		//중간부분 B로 바꾸기
		for(int i=upIdx; i<=downIdx; i++) {
			for(int j=0; j<C; j++) {
//				System.out.print(tmp[i][j]);
				if(tmp[i][j]!='B') {
					sum++;
					tmp[i][j]='B';
				}
			}
		}//for i
		
//		System.out.println("B sum : "+sum);
		
		//윗부분은 W, 아래는 R로
		for(int i=0; i<upIdx; i++) {
			for(int j=0; j<C; j++) {
				if(tmp[i][j]!='W') {
					sum++;
					tmp[i][j]='W';
				}
			}
		}//for W
//		System.out.println("W sum : "+sum);


		for(int i=downIdx+1; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(tmp[i][j]!='R') {
					sum++;
					tmp[i][j]='R';
				}
			}
		}//for R
//		System.out.println("sum : "+sum);
		
		min=Math.min(sum, min);
		
		

		middle(upIdx+1,downIdx);
		middle(upIdx,downIdx-1);
//		middle(upIdx+1,downIdx-1);
		
	}//middle
}//class
