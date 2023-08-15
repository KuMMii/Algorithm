package SWEA_1215;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1215/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int cnt=0;
			int wordLength=sc.nextInt();
			char arr[][]=new char[8][8];
			
			for(int i=0; i<8; i++) {
				arr[i]=sc.next().toCharArray();
			}

			for(int i=0; i<8; i++) { //각 줄의 for
				for(int j=0; j<=arr[i].length-wordLength; j++) { //가로줄부터 확인
					boolean flag=true;
					for(int k=0; k<wordLength/2; k++) { //각 j에서 단어 길이만큼 확인
						if(arr[i][k+j]!=arr[i][wordLength-1+j-k]) {
							flag=false;
							break;
						}
						
					}
					if(flag) {
						cnt++;
					}
					
					flag=true;
					
					for(int k=0; k<wordLength/2; k++) { //각 j에서 단어 길이만큼 확인
						if(arr[j+k][i]!=arr[wordLength-1+j-k][i]) {
							flag=false;
							break;
						}
						
					}
					if(flag) {
						cnt++;
					}
					
				}


			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
		
	}
}
