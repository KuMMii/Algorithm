package SWEA_1228_암호문1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1228_암호문1/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			
			LinkedList<Integer> list=new LinkedList<>();
			int n=sc.nextInt();
			for(int N=0; N<n; N++) { //list에 숫자 담기
				list.add(sc.nextInt());
			}//for N 리스트 길이
			
			n=sc.nextInt();
			for(int N=0; N<n; N++) { //list에 숫자 담기
				sc.next();
				int x=sc.nextInt();
				int y=sc.nextInt();
				for(int i=0; i<y; i++ , x++ ) { //for 조건에 변수 2개 넣기 성공ㅎ
					list.add(x, sc.nextInt());
				}
			}//for N 명령어 개수
			
			System.out.printf("#%d", tc);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}//tc
		
	}//main

}//class
