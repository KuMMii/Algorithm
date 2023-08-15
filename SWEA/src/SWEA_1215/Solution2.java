package SWEA_1215;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1215/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int cnt = 0;
            int wordLength = sc.nextInt();
            char arr[][] = new char[8][8];

            for (int i = 0; i < 8; i++) {
                arr[i] = sc.next().toCharArray();
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= arr[i].length - wordLength; j++) {
                    boolean isPalindrome = true; // 회문인지 체크하기 위한 변수
                    for (int k = 0; k < wordLength / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + wordLength - 1 - k]) {
                            isPalindrome = false; // 회문이 아니면 false로 설정
                            break; // 더 이상 확인할 필요 없음
                        }
                    }
                    if (isPalindrome) {
                        cnt++;
                    }
                }

                for (int j = 0; j <= arr[i].length - wordLength; j++) {
                    boolean isPalindrome = true; // 회문인지 체크하기 위한 변수
                    for (int k = 0; k < wordLength / 2; k++) {
                        if (arr[j + k][i] != arr[j + wordLength - 1 - k][i]) {
                            isPalindrome = false; // 회문이 아니면 false로 설정
                            break; // 더 이상 확인할 필요 없음
                        }
                    }
                    if (isPalindrome) {
                        cnt++;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}
