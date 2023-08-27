package SWEA_4215;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static int N,L, maxScore;
	public static int[][] arr;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_4215/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt(); //quantity of ingredients
			L=sc.nextInt(); //limit
			
			arr=new int[N][2];
			
			for(int n=0; n<N; n++) {
				arr[n][0]=sc.nextInt(); //score
				arr[n][1]=sc.nextInt(); //calorie
			}
			
			
			maxScore=0;
			
			selectMaterial(0, 0, 0);
			
			System.out.println("#" + tc + " " + maxScore);
		}//tc
	}//main
	
	public static void selectMaterial(int idx, int scr, int cal) {
        // 칼로리 초과
        if (cal > L) return;
        // 주어진 제한 칼로리 이하의 조합
        if (cal <= L) maxScore = Math.max(maxScore, scr);
        // 모두 조합을 확인
        if (idx == N) return;
        
        // 이 재료를 사용해보자
        selectMaterial(idx + 1, scr + arr[idx][0], cal + arr[idx][1]);
        // 이 재료는 사용하지 않을래
        selectMaterial(idx + 1, scr, cal);
    }//selectMaterial
	
}//class
