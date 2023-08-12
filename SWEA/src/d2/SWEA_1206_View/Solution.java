package d2.SWEA_1206_View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
//		File file=new File("src/d2/SWEA_1206_View/input.txt");
//		try {
//			Scanner sc= new Scanner(file);
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		try {
			System.setIn(new FileInputStream("src/d2/SWEA_1206_View/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)	{
			
		
		int bQuan=sc.nextInt();
		int[] height=new int[bQuan];
		for(int i=0; i<height.length;i++) {
			height[i]=sc.nextInt();
		}
		
		int sum=0;
		for(int i=2; i<height.length-2;i++) {
			int min=0;
			int left1=height[i]-height[i-1];
			int right1=height[i]-height[i+1];
			int left2=height[i]-height[i-2];
			int right2=height[i]-height[i+2];
			
			if(left1>0 && right1>0) { //우선 양옆의 시야가 확보된 애들만 2칸 먼 애들도 확인할거임
				min =(left1<right1)?left1:right1; //그리고 min값을 정해줌
				if(left2>0 && right2>0) { //전부 시야있는 애들 이제 구함
					if(min>left2||min>right2) {
						min=(left2<right2)?left2:right2;
					}
					
				}else {
					min=0;
				}
			}
			sum+=min;
		}
		
		System.out.printf("#%d %d\n", test_case, sum);
		
		}
	}
}
