package SWEA_1224;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static Map<String, Integer> map=new HashMap<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1224/input.txt"));
		Scanner sc=new Scanner(System.in);

		map.put("*", 2);
		map.put("/", 2);
		map.put("+", 1);
		map.put("-", 1);
		map.put("(", 0);
		
		
		
		for(int tc=1; tc<=10; tc++) {
			
			
			int N=sc.nextInt(); //input length
			String tmp=sc.next();
			String str="";
			
			Stack<String> op=new Stack<String>();
			
			
			//infix->postfix
			for(int i=0; i<N; i++) {
				//if operator, push it to stack
				if("(+-*/)".contains(Character.toString(tmp.charAt(i)))) {
					String o=Character.toString(tmp.charAt(i));
					switch(o) {
					case "(": 
						op.push(o);
						break;
					case "+" : case "-" : case "*" : case "/" :
							while(!op.isEmpty()&&map.get(op.peek())>=map.get(o)) {
								str+=op.pop();
							}//while
							op.push(o);
							break;
					case ")" :
						while(!op.peek().equals("(")) {
							str+=op.pop(); //concat operators
						}//while
						op.pop(); //throw out (
						break;
					}//switch
				}else {//if number
					str+=tmp.charAt(i);
				}
			}//for i
			
			
			//concat leftovers of op
			while(!op.isEmpty()) {
				if(!op.peek().equals("("))
					str+=op.pop();
				else op.pop();
			}
			
			
			
			//postfix->calculate
			
			Stack<Integer> num=new Stack<Integer>();
			
			for(int i=0; i<str.length(); i++){
				String o=Character.toString(str.charAt(i));
				if("(+-*/)".contains(o)) { //if operator
					
					int a=num.pop();
					int b=num.pop();
					
					switch(o) {
					
					case "+" : 
						num.push(a+b);
						break;
					case "-" : 
						num.push(a-b);
						break;
					case "*" : 
						num.push(a*b);
						break;
					case "/" :
						num.push(a/b);
						break;
					}//switch
					
				}else {//number
					num.push(Integer.parseInt(o));
					
				}//if else
				
				
				
			}//for i
			
			
			System.out.printf("#%d %d\n",tc, num.pop());
		}//tc
	}//main
}//class
