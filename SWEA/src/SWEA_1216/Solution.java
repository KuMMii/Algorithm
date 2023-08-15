package SWEA_1216;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1216/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			char arr[][]=new char[100][100];
			int max=0;
			
			for(int i=0; i<100; i++) {
				arr[i]=sc.next().toCharArray();
			}
			
			
			for(int i=0; i<100; i++) { //줄 돌리기
				outer : for(int l=50; l>=1; l--) { //단어길이
					for(int j=0; j<=100-l; j++) { //한줄 뒤지기
						
						boolean verFlag=true;
						for(int k=0; k<l/2; k++) { //가로
							if(arr[i][j+k]!=arr[i][j+l-1-k]) {
								verFlag=false;
								break;
							}
						}//k
						
						boolean horFlag=true;
						for(int k=0; k<l/2; k++) { //세로
							if(arr[j+k][i]!=arr[j+l-1-k][i]) {
								horFlag=false;
								break;
							}
						}//k
						
						
						if(verFlag || horFlag) {
							max=Math.max(l,max);
							break outer;
						}
						
					}//j
				}//outer
			} //i

			
			System.out.printf("#%d %d\n", tc, max);
		}//tc
		
		
	}
}
