package SWEA_1954_달팽이_숫자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int[][] snail;
		
		
		try {
			System.setIn(new FileInputStream("src/SWEA_1954_달팽이_숫자/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		
		for(int ts=0;ts<T;ts++) {
			int N=sc.nextInt();
			System.out.println("N : "+N);
			snail=new int[N][N];
			int num=1; //달팽이한테 줄 숫자
			
			int r=0; //시작 행
			int c=0; //시작 열
			
			int cr; //더할 행
			int cc; //더할 열
			
			int fr; //최종 행
			int fc; //최종 열
			
			
			while(num>N*N); {
				cr=0;
				cc=0;
				
				for(int i=0;i<N;i++) {
					if(i==0) {//맨 처음 시작
						for(int j=0;j<N;j++) {
							cc=j;
							fr=r+cr;
							fc=c+cc;
							snail[fr][fc]=num;
							r=fr;
							c=fc;
							System.out.println("첫번째 줄의 fr : "+fr);
							System.out.println("첫번재의 fc : "+fc);
						}
						
					}else if(i%2==1) { //i가 홀수일때
						//내려가는거
						for(int j=0;j<N-i;j++) { //행 바꾸기
							cr=j+i;
							fr=r+cr;
							fc=c+cc;
							snail[fr][fc]=num;
						}
						
						//왼쪽으로 가는거
						for(int j=N-1;j>=i;j--) {
							cc=j-i;
							fr=r+cr;
							fc=c-cc;
							snail[fr][fc]=num;
						}
						
					}else{ //i가 짝수 일때는 위, 오른쪽으로 감
						//위로가는거
						for(int j=N-1;j>=i;j--) {
							cr=j-i;
							fr=r-cr;
							fc=c+cc;
							snail[fr][fc]=num;
						}
						
						//오른쪽으로 가는거
						for(int j=0;j<N-i;j++) { //행 바꾸기
							cc=j+i;
							fr=r+cr;
							fc=c+cc;
							snail[fr][fc]=num;
						}
						
					}
					num++;
				}
				
				num++;
			}
			
			
			
			System.out.printf("#%d\n", ts+1);
			for(int[] i: snail) {
				System.out.println(Arrays.toString(i));
			}
		}
	}
}
