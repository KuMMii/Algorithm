package SWEA_1223;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution{
	
	
	public static Map<String, Integer> priority=new HashMap<>();
	public static String[] stack;
	public static int top=-1;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		priority.put("*",2);
		priority.put("/",2);
		priority.put("+",1);
		priority.put("-",1);
		priority.put("(",0);
		System.setIn(new FileInputStream("src/SWEA_1223/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int sum=0;
			
			
			int l=sc.nextInt();
			stack=new String[l];
			String str=sc.next();
			
			//infix->postfix
			String post="";
			
			for(int i=0; i<l; i++) { //입력받은 문자 한글자씩 돌려
				String c=str.charAt(i)+"";
				
				if("0123456789".contains(c)) { //숫자일때
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
			
			while(!isEmpty()) { //스택에 남은 거 꺼내기
				post+=pop();
				stack[top+1]=null;
			}//while
			
			
			//post->calculate
			l=post.length(); //postfix String length
			
			for(int i=0; i<l; i++) {
				String c=post.charAt(i)+"";

				if("0123456789".contains(c)) { //숫자면 push
					push(c);
				}else { //문자면,,,할게 많음
					int a=Integer.parseInt(pop());
					int b=Integer.parseInt(pop());
					switch(c) {
					case "*" : 
						push(String.valueOf(a*b));
						break;
					case "+" : 
						push(String.valueOf(a+b));
						break;
					}//switch
					
				}//else
			}//i
			
				System.out.println(Arrays.toString(stack));
			
			
			
			System.out.println("마지막 숫자"+(Integer.parseInt(stack[top])));
			System.out.printf("#%d %d\n", tc, Integer.parseInt(pop()));
		}//tc
		
	} //main
	
	
	
	//pop
	public static String pop() {
		if(isEmpty()) {
			return null;
		}
		return stack[top--];
	}
	
	
	//push
	public static void push(String c) {
		stack[++top]=c;
	}
	
	
	
	//isEmpty
	public static boolean isEmpty() {
		return top==-1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class