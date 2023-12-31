package SWEA_1954;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
	
	public static void main(String[] args) {
		
		
		try {
			System.setIn(new FileInputStream("src/SWEA_1954/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		
		for(int ts=1;ts<=T;ts++) {
			
			int r=0; //row
			int c=-1; //column
			int num=1; //printing number
			int[][] snail;
			int n=0; // each num
			
			int N=sc.nextInt();
			snail=new int[N][N];
			
			n=N;
			
			
			while(true) {
				//오른쪽으로 가기
				for(int j=(c+1);j<(c+1)+n;j++) { //다음 column값부터 그 시작점부터 n-m값 더한 인덱스-1까지 돌림
					snail[r][j]=num++;
				}
				c+=n; //c값 지정
				n--; //오른쪽갔다가 내려갈때 길이가 1씩 줄어서 n값을 줄임
				
				if(n==0) { //길이가 0될때 멈춤
					break;
				}
				
				//아래
				for(int i=(r+1); i<(r+1)+n;i++) {
					snail[i][c]=num++;
				}
				r+=n;
				
				//왼쪽
				for(int j=(c-1);j>(c-1)-n;j--) {
					snail[r][j]=num++;
				}
				c-=n;
				n--;
				
				if(n==0) {
					break;
				}
				
				//위
				for(int i=(r-1); i>(r-1)-n;i--) {
					snail[i][c]=num++;
				}
				r-=n;
			} //while
			
			System.out.printf("#%d\n", ts);
			for(int[] i: snail) {
				for(int j:i) {
					System.out.printf("%d ",j);
				}
				System.out.println();
			}
			
		}//test case
	}
}
