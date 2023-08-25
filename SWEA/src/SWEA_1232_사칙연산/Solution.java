package SWEA_1232_사칙연산;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String[][] arr;
	static int N;
	static int numL;
	static int numR;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1232_사칙연산/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N=sc.nextInt();
			sc.nextLine(); //엔터도 인식을 해서
			
			arr=new String[N+1][3]; //row=index, col=V,Lidx,Ridx
			for(int i=1; i<=N; i++) { //배열에 단어 넣기
				String[] tmp=sc.nextLine().split(" ");
				arr[i][0]=tmp[1];
				if(tmp.length==4) {
					arr[i][1]=tmp[2];
					arr[i][2]=tmp[3];
				}
			}// for i
			System.out.printf("#%d ", tc);
			inorder(1);
			System.out.println(arr[1][0]);
		}//tc
	}//main
	
	public static void inorder(int i) {
		if(i<=N) {
			if(arr[i][1]==null) return;
			else inorder(Integer.parseInt(arr[i][1])); //L
			
			if(arr[i][2]==null) return;
			else inorder(Integer.parseInt(arr[i][2])); //R
				
				
			
			if(arr[i][0]!=null) {// null이 아닐때
					if("+-/*".contains(arr[i][0])) {//연산자면
						
						//자식들 숫자 저장
						int idxL=Integer.parseInt(arr[i][1]);
						int idxR=Integer.parseInt(arr[i][2]);
						numL=Integer.parseInt(arr[idxL][0]);
						numR=Integer.parseInt(arr[idxR][0]);
						
						switch(arr[i][0]) {
						case "+":
							arr[i][0]=Integer.toString(numL+numR);
							break;
						case "-":
							arr[i][0]=Integer.toString(numL-numR);
							break;
						case "*":
							arr[i][0]=Integer.toString(numL*numR);
							break;
						case "/":
							arr[i][0]=Integer.toString(numL/numR);
							break;
						}//switch
						
						
					}else { //숫자면
						if(i%2==0) {//짝수 일 때
							numL=Integer.parseInt(arr[i][0]);
						}else {
							numR=Integer.parseInt(arr[i][0]);
						}
					}//숫자인지 아닌지 if
					 
				
			}//if !null
		}//if
	}//inorder
}//class
