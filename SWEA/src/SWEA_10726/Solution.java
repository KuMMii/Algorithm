package SWEA_10726;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_10726/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String ans="ON";
			
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			String bi="";
			
			for(int i=0; i<N; i++) {
				bi+="1";
			}

			int decimal=Integer.parseInt(bi, 2);
			if((M&decimal)!=decimal) ans="OFF"; 
			
			
			
			System.out.printf("#%d %s\n",tc,ans);
		}//tc
		
	}//main
}//class
