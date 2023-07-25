package d3.swea_5215;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class failedVersion {
	public static void main(String[] args) {
		//햄버거 다이어트
		
		Scanner sc=new Scanner(System.in);
		System.out.println("테스트 케이스 입력 : ");
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			
			int addedScore=0;
			int addedCal=0;
			
			System.out.println("재료의 수 입력 : ");
			int N=sc.nextInt(); //재료의 수
			System.out.println("제한 칼로리 입력 : ");
			int L=sc.nextInt(); // 제한 칼로리
			
			int[][] scrNCal=new int[N][2];
			
			
			for(int i=0;i<N;i++) { //점수 칼로리 2차원 배열로 입력하기
				for(int j=0;j<2;j++) {
					
					System.out.println(i+"배열에 입력할 점수와 칼로리를 하나씩 입력 :");
					scrNCal[i][j]=sc.nextInt(); 
					
				}
				
				
			}
			
//			for(int k=0;k<N;k++) {
//					System.out.println("정렬 전 :");
//					System.out.println("("+scrNCal[k][0]+","+scrNCal[k][1]+")");
//			}
			
			
			Arrays.sort(scrNCal,new Comparator<int[]>() { 
				//점수 기준으로 정렬함

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
						
					}else {
						return o2[0]-o1[0];
						
					}
					
				}
				
			});
			
//			for(int k=0;k<N;k++) {
//					System.out.println("정렬 후 :");
//					System.out.println("("+scrNCal[k][0]+","+scrNCal[k][1]+")");
//			}
			
			
			for(int i=0;i<N;i++) {
				if(addedCal+scrNCal[i][1]<=L) {
					addedScore+=scrNCal[i][0];
				}
				
			}
			
			
			System.out.printf("#%d %d",tc,addedScore);
		}
	}

}
