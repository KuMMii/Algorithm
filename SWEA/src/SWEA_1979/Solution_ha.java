package SWEA_1979;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution_ha {
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("src/SWEA_1979/input.txt"));
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
 
        for (int tc = 1; tc <= testCase; tc++) {
            int N = sc.nextInt(); // N: 퍼즐 크기
            int K = sc.nextInt(); // K: 단어 길이
            int[][] arr = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            } // 배열 입력
 
            int resultCnt = 0;
            // 가로와 단어가 들어갈 수 있는 곳
            // 행순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cntC = 0;
                    int cntR = 0;
                    if (arr[i][j] == 1) { // 흰색 부분을 만난다면
                        cntC++;
                        cntR++;
                        int nr = i + 1;
                        int nc = j + 1;
                        while (nc < N && arr[i][nc] == 1) {
                            nc++;
                            cntC++;
                        }
 
                        while (nr < N && arr[nr][j] == 1) {
                            nr++;
                            cntR++;
                        }
 
                        if (cntC == K) {
                            if (j == 0) {
                                resultCnt++;
                            } else if (j - 1 >= 0) {
                                if (arr[i][j - 1] == 0) {
                                    resultCnt++;
                                }
                            }
                        }
 
                        if (cntR == K) {
                            if (i == 0) {
                                resultCnt++;
                            } else if (i - 1 >= 0) {
                                if (arr[i - 1][j] == 0) {
                                    resultCnt++;
                                }
                            }
                        }
                    }
                }
            }
 
            System.out.println("#" + tc + " " +resultCnt);
 
        } // tc
 
    }// main
 
}