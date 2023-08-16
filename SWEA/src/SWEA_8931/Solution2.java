package SWEA_8931_제로;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] inputs = new int[N];
			for (int i = 0, lastIndex = -1; i < N; i++) {
				int number = sc.nextInt();
				// 0 이 아니면 값 추가 & 인덱스 번호 1 더하기
				if (number != 0) {
					inputs[++lastIndex] = number;
					// 0인 경우 값 0으로 수정 & 인덱스 번호 -1 
				} else {
					inputs[lastIndex--] = 0;
				}
			}

			int answer = 0;
			for (int n : inputs) {
				answer += n;
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}