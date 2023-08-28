package SWEA_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4613/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int R=sc.nextInt();
			int C=sc.nextInt();
			
			char[][] arr=new char[R][C];
			
			for(int i=0; i<R; i++) {
				String tmp=sc.next();
				arr[i]=tmp.toCharArray();
			}
			
		}//tc
		
	}//main
}//class
