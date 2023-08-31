package SWEA_4012;

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
			N=sc.nextInt(); //식재료 개수
			food=new int[N][N];
			arr=new int[N/2]; //절반만 담는 배열
			list=new ArrayList<Integer>();//N까지 전부담는 리스트
			
			//숫자 넣기
			for(int i=0;i<N; i++) {
				for(int j=0; j<N; j++) {
					food[i][j]=sc.nextInt();
				}
			}//for i
			
			min=20000; //최소값
			cook(0,0,0);
			
			System.out.printf("#%d %d\n",tc,min);
		}//tc
	}//main

	
	
	private static void cook(int idx, int sum, int arrIdx) {
		
		//리스트에 N개의 숫자 넣어주기
		list.clear(); //리스트 비움
		
		for(int i=0;i<N; i++) {
			list.add(i); //리스트에 숫자 넣기
		}//for i
		
		//recursion terminates
		int subtraction=0;
		
		//절반만큼 숫자가 선택됐을 때
		if(arrIdx==N/2) {//if arrIdx가 절반보다 하나 더 많으면(절반꺼까지 sum이 됐을때)
			
			//인덱스끝까지 arrIdx가 갔으니까 하나 빼주기
			arrIdx--; 
			
			//리스트에서 arr에 있는 값들 빼기
			for(int i=0; i<arr.length;i++) {
				list.remove(Integer.valueOf(arr[i]));
			}

			//리스트에 남은 숫자들 배열로 만들기(메서드에 넣을려고,,,,,)
			int[] tmp=new int[list.size()];
			for(int i=0; i<list.size(); i++) {
				tmp[i]=list.get(i);
			}

			// |고른 숫자들 표 합 - 안고른 나머지 표의 합|
			subtraction=Math.abs(sum-calculate(tmp,arrIdx));
			min=Math.min(subtraction, min);
			return;
		}//if arrIdx 절반
		
		//arrIdx가 절반보다 안됐을 때는 걍 계속 하던거 하면 됨
		else { 
			arr[arrIdx]=idx;
		}
		
		//숫자가 길이만큼 되면 리턴
		if(idx==N) return;
		
		//recursive case
		
		//idx 값을 선택해서 표의 합 구하는 경우
		cook(idx+1, calculate(arr,arrIdx), arrIdx+1);
		//idx값 선택 안한 경우
		cook(idx+1, sum, arrIdx);
	}//cook



	//표로 합 구하는 계산하는곳
	private static int calculate(int[] array, int arrIdx) {
		int score=0;
		//arrIdx가 1보다는 커야함! 왜냐면 그래야 두개 이상 조합 가넝
		if(arrIdx>0) {
			for(int i=0; i<arrIdx; i++) {
				for(int j=i+1;j<=arrIdx;j++) {
					score+=food[array[i]][array[j]];
					score+=food[array[j]][array[i]];
				}
			}//for i
		}//if
		return score;
	}//array
	
}//class
