package SWEA_8931_제로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static int[] stack;
	public static int top=-1;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_8931_제로/input.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			top=-1;
			int sum=0;
			int k=sc.nextInt(); //테스트케이스 개수
			stack=new int[k]; 
			
			for(int i=0; i<k; i++) {
				int val=sc.nextInt(); //진혁이가 부르는 돈
				if(val==0) {
					pop();
				}else {
					push(val);
					
				}
			}
			
			for(int j : stack) {
				sum+=j;
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
	
	//삭제
	public static void pop() {
		if(isEmpty()) {
//			System.out.println("스택이 비어있습니다.");
		}else {
			
			stack[top--]=0;
		}
	}

	//삽입
	public static void push(int value) {
		if(isFull()) {
//			System.out.println("이미 꽉 찼어유");
//			return;
		}else {
			stack[++top]=value;
		}
	}
	
	
	private static boolean isFull() {
		return top==stack.length-1;
	}

	private static boolean isEmpty() {
		return top==-1;
	}
	
}
