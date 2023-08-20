package SWEA_1954;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution4 {

	static int r=0; //row
	static int c=0; //column
	static int n=0; //number to add with r or c
	static int num=1; //number to print
	static int[][] snail;
	
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/SWEA_1954/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N=sc.nextInt(); //length
			snail=new int[N][N];
			n=N;
			r=0;
			c=0;
			num=1;
			
			while(true) {
						
				right();
				if(n==0) break;
				down();
				left();
				if(n==0) break;
				up();
			}
			
			System.out.println("#"+tc);
			for(int[] i: snail) {
				for(int j : i) {
					System.out.print(j+" ");
				}
				System.out.println();
			}
			
		}//tc
		
	} //main

	private static void right() {
		for(int i=c; i<c+n; i++) {
			snail[r][i]=num++;
		}
		c+=n-1; //c위치 옮겨주기
		r++; //r밑으로 한칸 가주기
		n--;
	}//right
	
	private static void down() {
		for(int i=r; i<r+n;i++) {
			snail[i][c]=num++;
		}
		r+=n-1; //r위치 옮겨주기
		c--; //c 왼쪽으로 한칸 옮겨주기
		
	}//down
	
	private static void left() {
		for(int i=c; i>=c-(n-1); i--) {
			snail[r][i]=num++;
		}
		c-=n-1;
		r--; //r위로 한칸가기
		n--;
	}//left
	
	private static void up() {
		for(int i=r; i>=r-(n-1);i--) {
			snail[i][c]=num++;
		}
		r-=n-1;
		c++;
	}//up
	
} //class
