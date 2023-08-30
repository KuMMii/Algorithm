package SWEA_4012;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static int N,min;
	static int[][] food;
	static int[] arr;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4012/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			food=new int[N][N];
			arr=new int[N/2+1];
			list=new ArrayList<Integer>();
			
			//숫자 넣기
			for(int i=0;i<N; i++) {
				list.add(i+1);
				for(int j=0; j<N; j++) {
					food[i][j]=sc.nextInt();
				}
			}//for i
			min=20000;
			cook(0,0,1);
			
		}//tc
	}//main

	
	
	private static void cook(int idx, int sum, int arrIdx) {
		//recursion terminates
		int subtraction=0;
		if(arrIdx==N/2+1) {//if arrIdx가 절반보다 하나 더 많으면(절반꺼까지 sum이 됐을때)
			//나머지 값
			
			subtraction=Math.abs(sum/*-나머지값*/);
			min=Math.min(subtraction, min);
			return;
		}//if arrIdx
		else {
			arr[arrIdx]=idx;
			list.remove(idx);
		}
		
		if(idx==N) return;
		
		
		
		
		//recursive case
		cook(idx+1, calculate(arr), arrIdx+1);
		cook(idx+1, sum, arrIdx);
		
		
	}//cook



	private static int calculate(int[] array) {
		int score=0;
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1;j<array.length;j++) {
				score+=food[i][j];
				score+=food[j][i];
			}
		}//for i
		return score;
	}//array
}//class
