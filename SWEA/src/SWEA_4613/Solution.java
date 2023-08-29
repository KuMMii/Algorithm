package SWEA_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static char[][] arr, tmp;
	static int before,sum,min,R,C,fix=0;
	static int[][] save;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4613/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=1; tc++) {
			
			fix=0;
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
					fix++;
					tmp[0][i]='W';
				}
				if(tmp[R-1][i]!='R') {
					fix++;
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
			System.out.println("f" +fix);
			save=new int[R-2][R-2];
			save[0][R-3]=sum;
			before=sum;
			middle(0,R-3);
			
			System.out.println("min:"+min);
			System.out.printf("#%d %d\n",tc,min+fix);
		}//tc
		
	}//main
	
	

	private static void middle(int upIdx, int downIdx) {
		
		
		System.out.println("sum위 : "+sum);

		//전값을 설정
		if(upIdx-1<0 && downIdx+1>=save.length) {
			before=save[upIdx][downIdx];
			System.out.println(11111);
		}else if(upIdx-1<0) {
			before=save[upIdx][downIdx+1];
			System.out.println(2222);
		}else if(downIdx+1>=save.length) {
			before=save[upIdx+1][downIdx];
			System.out.println(3333);
		}
		
		System.out.println("before : "+before);
		char[][] tmp=new char[R-2][C];
		System.out.println("up : "+upIdx+" down : "+downIdx );
		
		//맨위, 맨 아래 제외한 부분 복사한 배열 생성
		for(int i=0; i<R-2; i++) {
			for(int j=0; j<C; j++) {
				tmp[i][j]=arr[i+1][j];
			}
		}//for

		if(downIdx-upIdx<0) return;
		
		int cnt=0;
		sum=0;

		
		//upIdx 윗줄을 무조건 B빼고 W로 바꾸기
		for(int j=0; j<C; j++) {//B바꾼거 더한거 빼기
			if(upIdx-1>=0) {
				if(tmp[upIdx-1][j]!='B') { //B
					cnt++;
				}
				if(tmp[upIdx-1][j]!='W') { //W
					sum++;
				}
				
			}//윗 줄이 범위내에 있다면
			
			//down보다 한줄 밑
			if(downIdx+1<tmp.length) {
				if(tmp[downIdx+1][j]!='B') { //B
					cnt++;
				}
				if(tmp[downIdx+1][j]!='R') { //W
					sum++;
				}
				
			}//범위내에 아랫줄이 있는지 확인
		}//for B
		
		System.out.println("cnt최종 : "+cnt);
		
		System.out.println("sum 합 : "+sum);
		
		sum+=(before-cnt);
		save[upIdx][downIdx]=sum;
		
		System.out.println("sum보내는값 : "+sum);
		min=Math.min(min, sum);
		
		if(upIdx+1<tmp.length) middle(upIdx+1,downIdx);
		if(upIdx-1>=0) middle(upIdx,downIdx-1);
		if(upIdx+1<tmp.length && upIdx-1>=0) middle(upIdx+1,downIdx-1);
		
	}//middle
}//class


