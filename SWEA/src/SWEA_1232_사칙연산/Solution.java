package SWEA_1232_사칙연산;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String[] arr;
	static int N;
	static int numL;
	static int numR;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1232_사칙연산/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			N=sc.nextInt();
			sc.nextLine(); //엔터도 인식을 해서
			
			arr=new String[N+1];
			for(int i=1; i<=N; i++) { //배열에 단어 넣기
				String[] tmp=sc.nextLine().split(" ");
				arr[i]=tmp[1];
			}// for i
			
			System.out.printf("#%d ", tc);
			inorder(1);
			System.out.println(arr[1]);
		}//tc
	}//main
	
	public static void inorder(int i) {
//		System.out.println("전체i"+i);
		if(i<=N) {
//			System.out.println("가넝i"+i);
			inorder(i*2); //L
			inorder(i*2+1); //R
			
			if(arr[i]!=null) {// null이 아닐때
//				System.out.println(arr[i]);
					
					if("+-/*".contains(arr[i])) {//연산자면
//						System.out.println(Arrays.toString(arr));
						switch(arr[i]) {
						case "+":
							arr[i]=Integer.toString(numL+numR);
							break;
						case "-":
							arr[i]=Integer.toString(numL-numR);
							break;
						case "*":
							arr[i]=Integer.toString(numL*numR);
							break;
						case "/":
							arr[i]=Integer.toString(numL/numR);
							break;
						}//switch
						if(i%2==0) {//짝수 일 때
							numL=Integer.parseInt(arr[i]);
						}else {
							numR=Integer.parseInt(arr[i]);
						}
						
					}else { //숫자면
						System.out.println(Arrays.toString(arr));
						if(i%2==0) {//짝수 일 때
							numL=Integer.parseInt(arr[i]);
						}else {
							numR=Integer.parseInt(arr[i]);
						}
						System.out.printf("L %d /R %d\n",numL,numR);
					}//숫자인지 아닌지 if
					 
				
			}//if !null
		}//if
	}//inorder
}//class
