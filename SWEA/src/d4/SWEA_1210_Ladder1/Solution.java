package SWEA_1210_Ladder1;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/SWEA_1210_Ladder1/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc=sc.nextInt();
			// 사다리 배열 만들었음
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			

			// X가 어디있는지부터 알아내기
			int x = 0;
			for (int j = 0; j < 100; j++) {
				if (arr[99][j] == 2) {
					x = j;
				}
			}
			// x의 행열 위치로 초기화
			int r = 99;
			int c = x;

			while (r > 0) {// 맨 윗줄에서 멈춤
				
				if ((r!=0&&arr[r - 1][c] == 1) && ((c==0&&arr[r][c+1]!=1)|| (c!=0&&arr[r][c-1]!=1)) && ((c==99&&arr[r][c-1]!=1)|| (c!=99&&arr[r][c+1]!=1))) {// 현상태 윗칸이 1이면
					r = up(arr, r, c);
				} else if (c!=0&&arr[r][c - 1] == 1) {// 왼쪽칸이 1이면
					c = left(arr, r, c);
				} else if (c!=99&&arr[r][c + 1] == 1) {// 오른쪽칸이 1이면
					c = right(arr, r, c);
				}
			}
			System.out.printf("#%d %d\n", tc, c);
		} // for
	}// main

	public static int up(int[][] arr, int r, int c) {// 위로
		while (true) {
			if(r==0||arr[r - 1][c] == 0 ||(c==0&&arr[r][c+1]==1) || (c==99&&arr[r][c-1]==1) || (c!=0&&arr[r][c-1]==1) || (c!=99&&arr[r][c+1]==1)) {
					return r;
			}
			arr[r][c]++;
			r--;
		}
	}

	public static int left(int[][] arr, int r, int c) {// 왼쪽
		while (c != 0 && arr[r][c - 1] != 0) {
			arr[r][c]++;
			c--;
		}
		return c;
	}

	public static int right(int[][] arr, int r, int c) {// 오른쪽
		while (c != 99 && arr[r][c + 1] != 0) {
			arr[r][c]++;
			c++;
		}
		return c;
	}

}
