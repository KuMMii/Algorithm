package SWEA_1966_숫자를정렬하자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1966_숫자를정렬하자/input.txt"));
		Scanner sc =new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			int[] arr = new int[N];
			
			for(int n=0; n<N; n++) { //배열 생성
				arr[n]=sc.nextInt();
			}//n
			
			
			//삽입정렬 구현
			for(int i=1; i<N; i++) {
				int key=arr[i]; //이번에 정렬할 값
				int j;
				
				for(j=i-1; j>=0 && arr[j]>key;j--) {
					//지정한 수보다 앞에 있는 애들하고 비교하는데 타겟값보다 큰애들일때만 스왑 
					arr[j+1]=arr[j];
				}//다 한칸씩 밀고 마지막에 추가 해줌
				arr[j+1]=key;
			}//for i
			
			System.out.printf("#%d",tc);
			for(int i : arr) {
				System.out.print(" "+i);
			}
			System.out.println();
			
		}//tc
	}//main
}//class
