package SWEA_10726;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_10726/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String ans="ON";
			
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			String bi=Integer.toBinaryString(M);
			String bi32=String.format("%32s", bi).replaceAll(" ", "0");
			System.out.println(bi32);
			for(int i=0; i<N; i++) {
//				System.out.println(bi32.length()-1-i);
				if(bi32.charAt(bi32.length()-1-i)!='1') {
					ans="OFF";
					break;
				}
			}
			
			
			
			System.out.printf("#%d %s\n",tc,ans);
		}//tc
		
	}//main
}//class
