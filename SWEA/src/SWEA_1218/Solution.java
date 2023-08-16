package SWEA_1218_괄호짝짓기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int top=-1;
	static char[] bracket;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1218_괄호짝짓기/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			top=-1;
			int len=sc.nextInt();
			bracket=new char[len];
			String str=sc.next();
			for(int i=0; i<len; i++) {
				char val=str.charAt(i);
				if(top==-1) {
					push(val);
				}else {
					
					if(bracket[top]=='(' && val==')' 
							|| bracket[top]=='{' && val=='}'
							|| bracket[top]=='<' && val=='>'
							|| bracket[top]=='[' && val==']') {
						pop();
					}else {
						push(val);
					}
				} //else
			} //i
			
			int ans=0;
			if(top==-1) {
				ans=1;
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		} //tc
	} //main

	private static void push(char val) {
		bracket[++top]=val;
		
	}

	private static void pop() {
		bracket[top--]=' ';
	}

}//class
