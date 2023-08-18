package SWEA_1948_날짜계산기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1948_날짜계산기/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int days=0;
			
			int m1=sc.nextInt();
			int d1=sc.nextInt();
			int m2=sc.nextInt();
			int d2=sc.nextInt();
			
			for(int m=m1; m<m2; m++) {
				switch(m) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					days+=31;
					break;
				case 4: case 6: case 9: case 11:
					days+=30;
					break;
				case 2: 
					days+=28;
					break;
				}
			}
			
			days=days-(d1-1)+d2;
			
			System.out.printf("#%d %d\n", tc, days);
			
		}//tc
		
		
	}//main
}//class
