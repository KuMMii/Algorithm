package SWEA_1230_암호문3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1230_암호문3/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			
			LinkedList<Integer> list=new LinkedList<>();
			int n=sc.nextInt();
			for(int N=0; N<n; N++) { //list에 숫자 담기
				list.add(sc.nextInt());
			}//for N 리스트 길이
			
			n=sc.nextInt();
			for(int N=0; N<n; N++) { //list에 숫자 담기
				char c=sc.next().charAt(0); // I D A 중 하나 담기
				switch(c) {
				
				case 'I' : //Insert
					int x=sc.nextInt();
					int y=sc.nextInt();
					for(int i=0; i<y; i++ , x++ ) { //for 조건에 변수 2개 넣기 성공ㅎ
						list.add(x, sc.nextInt());
					}
					break;
				case 'D' : //Delete
					x=sc.nextInt();
					y=sc.nextInt();
					for(int i=0; i<y; i++ /*, x++ */) { //for 조건에 변수 2개 넣기 성공ㅎ
						list.remove(x);
					}
					break;
				case 'A' : //Add
					y=sc.nextInt();
					for(int i=0; i<y; i++ ) { //for 조건에 변수 2개 넣기 성공ㅎ
						list.add(sc.nextInt());
					}
					break;
				}//switch
				
			}//for N 명령어 개수
			
			System.out.printf("#%d", tc);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}//tc
		
	}//main

}//class
