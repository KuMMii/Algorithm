package SWEA_1222_계산기1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static char stackChar[];
	public static int stackInt[];
	public static int topChar=-1;
	public static int topInt=-1;
	public static String str="";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1222_계산기1/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			topChar=-1;
			int sum=0;
			
			int L=sc.nextInt();
			stackChar=new char[L];
			String temp=sc.next();
			
			for(int i=0; i<L; i++) { //infix ->postfix
				if(temp.charAt(i)=='+') {
					if(topChar<0) { // +가 없는 경우(빈경우)
						push('+');
					}else { 
						str+=peek2();
						pop1();
						push('+');
					}
				}else {
					str+=temp.charAt(i); //숫자는 String으로 저장
				}
//				System.out.println(str);
			}//i
			
			topInt=-1;
			stackInt=new int[str.length()];
//			System.out.println(str);
			for(int i=0; i<str.length(); i++) { //postfix->cal
				if(str.charAt(i)!='+') { //숫자일 때
					push(str.charAt(i)-'0'); //스택에 push
				}else{
					
					int num1=peek();
					pop2();
					int num2=peek();
					pop2();
					sum=num1+num2;
					push(sum);
				}
			}
			int num1=peek();
			pop2();
			int num2=peek();
			pop2();
			sum=num1+num2;
			push(sum);
			
			
			System.out.printf("#%d %d\n", tc, sum);
		} //tc
		
		
		
		
	}//main


	private static int peek() {
		if(isEmpty(stackInt)) {
			return 0;
		}
		return stackInt[topInt];
	}

	private static void push(int i) { //int 넣는 스택용
//		if(isFull(stackInt)) {
//			return;
//		}
		stackInt[++topInt]=i;
	}

	private static void pop2() { //int pop
		if(isEmpty(stackInt)) {
			return;
		}
		stackInt[topInt--]=0;
	}
	
	private static boolean isEmpty(int[] stackInt2) {
		return topInt==-1;
	}

	private static boolean isFull(int[] stackInt2) {
		return topInt==stackInt.length;
	}

	
	////////////////밑부터 char/////////////////
	private static char peek2() {
		if(isEmpty(stackChar)) {
			return '0';
		}
		return stackChar[topChar];
	}
	
	private static void pop1() {
		if(isEmpty(stackChar)) {
			return;
		}
		topChar--;
	}


	private static void push(char c) { //+ 넣는 스택용
		
//		if(isFull(stackChar)) {
//			return;
//		}
		stackChar[++topChar]=c;
		
	}
	
	private static boolean isEmpty(char[] stackChar) {
		return topChar==-1;
	}

	private static boolean isFull(char[] stackChar) {
		return topChar==stackChar.length;
	}
	
	
	
	
	
	
	
	
	
}//class
