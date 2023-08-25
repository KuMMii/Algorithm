package SWEA_1974_스도쿠검증;

import java.util.Scanner;

public class Solution2_teacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = 9;
			int[][] sudoku = new int[N][N];

			int ans = 1; // 아닐경우 0으로 바꾸는게 더 편하므로 1로 초기화

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 검사시작
			out: for (int i = 0; i < N; i++) {
				boolean[] row = new boolean[10]; // 행검사
				boolean[] col = new boolean[10]; // 열검사
				for (int j = 0; j < N; j++) {
					if (row[sudoku[i][j]] || col[sudoku[j][i]]) {
						ans = 0;
						break out;
					}
					// 아래문장을 수행한다는 것은 해당 숫자를 사용하지 않았다는 의미
					row[sudoku[i][j]] = true;
					col[sudoku[j][i]] = true;

					// 3x3 여기서 검사하자
					if (i % 3 == 0 && j % 3 == 0) {
						boolean[] square = new boolean[10];

						for (int r = i; r < i + 3; r++) {
							for (int c = j; c < j + 3; c++) {
								if (square[sudoku[r][c]]) {
									ans = 0;
									break out;
								}
								square[sudoku[r][c]] = true;
							}
						}
					}
				} // 한방에
			}

		} // tc
	}// main
}
