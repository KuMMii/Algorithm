package SWEA_1217;

import java.util.Scanner;

public class Solution_ep {
	public static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 거듭제곱 수를 저장하기 위한 배열
			num = new int[M + 1];
			pow(N, M, 1);
			System.out.printf("#%d %d\n", tc, num[M]);
		}
	}
	// 거듭제곱하는 매서드
	public static void pow(int N, int M, int idx) {
		// 1일땐 자기자신 저장
		if (idx == 1) {
			num[idx] = N;
			// 그 외의 경우엔 이전의 값*N
		} else {
			num[idx] = N * num[idx - 1];
			// 기저부분
			if (idx == M) {
				return;
			}
		}
		// 재귀
		pow(N, M, ++idx);
	}

}
