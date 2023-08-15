package d2.SWEA_1859;

import java.util.Scanner;

public class SWEA_1859 {
	public static void main(String[] args) {
			
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();  //테스트 케이스 값(최대 백만)
			for (int i = 0; i < t; i++) {
				int n=sc.nextInt();
				long diff=0; 
				//최대값이 만원이기 때문에 최대값*t의 최대값=10^10임
				//그래서 차이값인 diff값이 long이어야 함   
				int max_value=0;
				int[] arr=new int[n];
				for (int j = 0; j < n; j++) {
				/*
				 * 이렇게 뒤에서부터 최대값을 찾아야 반복문이 끊기지 않고 차이값을 얻어낼 수 있음 
				 * 앞에서부터 찾으면 중간에  최대값이 있는 경우 배열을 끊고서 다시 새로 배열을 만들어야 했음
				*/
					arr[j]=sc.nextInt();
				}
				for (int j = n-1; j >=0; j--) {				
					if(arr[j]>max_value)max_value=arr[j];
					diff+=max_value-arr[j];
				}
				System.out.printf("#%d %d\n",i+1,diff);
			}
			sc.close();
		}
}
