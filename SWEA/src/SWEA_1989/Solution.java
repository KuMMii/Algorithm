package SWEA_1989;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int result=0; //맞으면 1, 아니면 0
			
			String word=sc.next();
			int l=word.length();
			for(int i=0; i<l/2; i++) {
				if(word.charAt(i)!=word.charAt(l-1-i)) {
					break;
				}
				if(i==l/2-1) { //다 돌아서 결국 마지막까지 왔을때
					result=1;
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
