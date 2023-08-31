package SWEA_4012;

//정유경언니 답 
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	static int N, min, R;
	static int[][] arr;
	static boolean[] isTrue;
	static int[] A;
	static int[] B;
	static int aSum, bSum, sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //식재료의 수
			min = Integer.MAX_VALUE; //맛이 최소가 되는 값 저장하는 변수
			R = N/2; //한 음식 당 골라야 할 식재료 개수
			
			isTrue = new boolean[N];
			A = new int[R]; //음식 A 저장하는 배열
			B = new int[R]; //음식 B 저장하는 배열
			
			arr = new int[N][N]; //시너지 값 저장하는 배열
			//시너지 배열 입력받음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			combination(0,0);
			
			System.out.printf("#%d %d\n",tc,min); //출력
			
		}//tc
	}//main
	
	public static void combination(int idx, int aidx) {
		if(aidx == R) {
			//A 배열에 저장되지 않은 나머지 인덱스는 B에 저장
			int bidx = 0;
			for (int i = 0; i < N; i++) {
				if(!isTrue[i]) {
					B[bidx] = i;
					bidx++;
				}
			}

			aSum = 0; //A의 합 저장할 변수
			bSum = 0; //B의 합 저장할 변수
			//2개씩 뽑아서 합 변수에 저장
			for (int i = 0; i < R-1; i++) {
				for (int j = i+1; j < R; j++) {
					aSum += arr[A[i]][A[j]] + arr[A[j]][A[i]];
					bSum += arr[B[i]][B[j]] + arr[B[j]][B[i]];
					
				}
			}
			//A합과 B합의 차를 절댓값 처리하여 가장 최솟값 갱신
			min = Math.min(min, Math.abs(aSum-bSum));
			return;
		}
		
		//인덱스 R개씩 뽑아서  A 배열에 저장
		for (int i = idx; i <= N-R+aidx; i++) {
			A[aidx] = i;
			isTrue[i] = true;
			combination(i+1, aidx+1);
			isTrue[i] = false;
		}
		
	} //combination
}