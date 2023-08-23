package SWEA_1231_중위순회;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static char[] arr;
	static int N;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1231_중위순회/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N=sc.nextInt();
			sc.nextLine(); //엔터도 인식을 해서
			
			arr=new char[N+1];
			for(int i=1; i<=N; i++) { //배열에 단어 넣기
				String str=sc.nextLine();
				if(str.charAt(1)==' ') arr[i]=str.charAt(2); //첫번째 숫자가 한자리수
				if(str.charAt(1)!=' ') arr[i]=str.charAt(3); //첫번째 숫자가 두자리수
				if(str.charAt(1)!=' ' && str.charAt(2)!=' ') arr[i]=str.charAt(4); //첫번째 숫자가 세자리수
			}// for i
			
			System.out.printf("#%d ", tc);
			inorder(1);
			System.out.println();
		}//tc
	}//main
	
	public static void inorder(int i) {
		
		if(i<=N) {
			inorder(i*2); //L
			if(arr[i]!= ' ')
				System.out.print(arr[i]); //V
			inorder(i*2+1); //R
		}
	}
}//class
