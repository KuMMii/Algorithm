package SWEA_1223;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
		System.setIn(new FileInputStream("src/SWEA_1223/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			int sum=0;
			
			
			int l=sc.nextInt();
			stack=new char[l];
			String str=sc.next();
			
			//infix->postfix
			String post="";
			
			for(int i=0; i<l; i++) { //입력받은 문자 한글자씩 돌려
				char c=str.charAt(i);
//				System.out.println( "c: "+c);
//				System.out.println("top: "+top);
				if(48<=(int)c && (int)c <=57) { //숫자일때
					post+=c; //String에 붙이기
					
				}else { //문자일때
					
					boolean flag=true;
					while(flag) { //가장 최신 문자가 더 클때나 비어있을때
						if(isEmpty()||priority.get(c)>priority.get(stack[top])) { //가장 최신 연산자보다 값이 클때는 걍 push하기
							push(c);
							flag=false;
						}else if(priority.get(c)<=priority.get(stack[top])){ //pop보다 작거나 같을 때는 String에 더함
							post+=pop();
						}
					}//while
				}//else-str.charAt(i)가 문자일때
			}//i
			System.out.println(post);
			
			System.out.println(Arrays.toString(stack));
			
			//post->calculate
			l=post.length(); //postfix String length
			
			for(int i=0; i<l; i++) {
				char c=post.charAt(i);

				if(48<=(int)c && (int)c <=57) { //숫자면 push
					push(c);
				}else { //문자면,,,할게 많음
					switch(c) {
					case '*' : push((char)((int)pop()-'0'*((int)pop()-'0')));
					case '+' : push((char)((int)pop()-'0'+((int)pop()-'0')));
					}//switch
					
				}//else
				System.out.println(Arrays.toString(stack));
			}//i
			
			
			
			
			
			System.out.printf("#%d %d\n", tc, (int)pop()-'0');
		}//tc
		
	} //main
	
	
	
	//pop
	public static char pop() {
		if(isEmpty()) {
			return '\u0000';
		}
//		System.out.println("pop");

		return stack[top--];
	}
	
	
	//push
	public static void push(char c) {
//		System.out.println("push");
		stack[++top]=c;
	}
	
	
	
	//isEmpty
	public static boolean isEmpty() {
//		if(top==-1)	System.out.println("empty");
		return top==-1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class