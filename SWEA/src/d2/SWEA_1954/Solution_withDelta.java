package d2.SWEA_1954;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_withDelta {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1954_달팽이숫자/input.txt");
		Scanner sc = new Scanner(file);
		
		// test_case 받기
		int t = sc.nextInt();
		
		int[] dx = {0, 1, 0, -1}; // 다음 숫자가 들어갈 x방향
		int[] dy = {1, 0, -1, 0}; // 다음 숫자가 들어갈 y방향
		for (int test_case = 0; test_case < t; test_case++) {
			int n = sc.nextInt();
			int[][] numbers = new int[n][n]; // 달팽이 숫자가 들어갈 N * N 2차원 배열
			int x = 0; // 처음 x위치
			int y = 0; // 처음 y위치
			int nx = 0; // 다음 x위치
			int ny = 0; // 다음 y위치
			int index = 0; // dx와 dy의 배열의 index 어떤 방향으로 꺽을지
			for (int number = 1; number <= n * n; number++) {
				numbers[x][y] = number; // 해당하는 x, y위치에 숫자 넣기
				nx = x + dx[index]; // 다음 x 위치 설정
				ny = y + dy[index]; // 다음 y 위치 설정
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && numbers[nx][ny] == 0) {
					x = nx; // 범위 안쪽이고 다음 위치에 0이 있다면 x를 nx로 할당
					y = ny;
				} else {
					index++; // 해당하지 않는다면 90도 회전해야하니깐 index를 1을 추가
					if (index > 3) {
						index = index % 4; // 만약 dx, dy의 범위가 넘어선다면 4의 나머지를 구해서 범위를 재설정
					}
					x += dx[index]; // 새로운 위치 설정
					y += dy[index];
				}
			}
			// 달팽이 숫자 출력
			System.out.println("#" + (test_case + 1));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(numbers[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}