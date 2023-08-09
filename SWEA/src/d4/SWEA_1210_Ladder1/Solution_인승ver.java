package SWEA_1210_Ladder1;

import java.util.Scanner;

public class Solution_인승ver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int k = 1; k <= 10; k++) {
			sc.nextInt();		
			int[][] ladder = new int[100][100];
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			int jj = -1; // 움직이는 지점의 j
			
			// int[99][j] == 2 인 지점 찾는다
			for (int j = 0; j<100; j++) {
				if(ladder[99][j] == 2) {
					jj = j;
				}
			}
			
			// 골인지점에서부터, 아래에서 위로 올라간다
			for (int i = 98; i>=0; i--) {
				// int[99-i][j값+1, -1] == 1인 지점 찾는다 (j가 0이거나 99면 한쪽만 찾는다)
				if (jj != 99 && ladder[i][jj+1] == 1) {
					// 오른쪽으로 이동하면서, i-1(위 네모)이 1인 지점 찾는다
					do {
						jj++;
					} while (ladder[i-1][jj] != 1);
					continue;
				}
				if (jj != 0 && ladder[i][jj-1] == 1) {
					// 왼쪽으로 이동하면서, i-1(위 네모)이 1인 지점 찾는다
					do {
						jj--;
					} while (ladder[i-1][jj] != 1);
				 }
				continue;
			}
			System.out.printf("#%d %d%n", k, jj);
		}
	}
}
