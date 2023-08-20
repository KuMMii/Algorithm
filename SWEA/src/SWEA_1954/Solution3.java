package SWEA_1954;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
	
	
	public static void main(String[] args) {
		
		
		try {
			System.setIn(new FileInputStream("src/SWEA_1954/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		
		
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			int[][] snail=new int[n][n];
			
			int r=0; //start r
			int c=0; //start c
			
			int nr=0; //next r
			int nc=0; //next c
			
			int index=0; //index of dr, dc
			
			for(int num=1; num<=n*n; num++) {
				snail[r][c]=num;
				nr=r+dr[index];
				nc=c+dc[index];
				
				if(nr>=0 && nr<n && nc>=0 && nc<n && snail[nr][nc]==0) {
					//범위 내에 있고, 다음 칸이 0인 상태일때만 새로운 숫자 적을 수 있음
					r=nr;
					c=nc;
				}else { //아니면 방향 틀기
					index++;
					if(index>3) {
						index=index%4;
					}
					r+=dr[index];
					c+=dc[index];
				} //else
			}//num
			
			//출력
			System.out.println("#"+tc);
			for(int[] i : snail) {
				for(int j : i) {
					System.out.printf("%3d", j);
				}
				System.out.println();
			}
			
		}//test case
	}
}
