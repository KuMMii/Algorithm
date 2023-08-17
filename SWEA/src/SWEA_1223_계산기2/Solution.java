package SWEA_1223_계산기2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution{
	
	
	public static Map<Character, Integer> priority=new HashMap<>();
	public static char[] stack;
	public static int top=-1;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		priority.put('*',2);
		priority.put('/',2);
		priority.put('+',1);
		priority.put('-',1);
		priority.put('(',0);
		
		System.setIn(new FileInputStream("src/SWEA_1223_계산기2/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			int sum=0;
			
			
			int l=sc.nextInt();
			stack=new char[l];
			String str=sc.next();
			
			//infix->postfix
			String tmp="";
			for(int i=0; i<l; i++) { //입력받은 문자 한글자씩 돌려
				char c=str.charAt(i);
				
				if(48<=(int)c && (int)c <=57) { //숫자일때
					tmp+=c; //String에 붙이기
					
				}else { //문자일때
					if(isEmpty()||priority.get(c)>priority.get(pop())) { //가장 최신 연산자보다 값이 클때는 걍 push하기
						top++;
						push(c);
					}else { //pop보다 작거나 같을 때는 String에 더함-이걸 계속해서 해야함
						boolean flag=false;
						while(flag) { //pop이 더 클때나 비어있을때
							if(priority.get(c)>priority.get(pop()) || isEmpty()) {
								flag=true;
								tmp+=pop();
							}
						}
						top++;
						push(c);
					}
				}
			}//i
			System.out.println(tmp);
			
			
			
			
			
			
			System.out.printf("#%d %d\n", tc, sum);
		}//tc
		
	} //main
	
	
	
	//pop
	public static char pop() {
		if(isEmpty()) {
			return '\u0000';
		}
		return stack[top--];
	}
	
	
	//push
	public static void push(char c) {
		stack[++top]=c;
	}
	
	
	
	//isEmpty
	public static boolean isEmpty() {
		return top==-1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class