package SWEA_2817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int N, K,cnt;
	static int[] num;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_2817/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			N=sc.nextInt();
			K=sc.nextInt(); //기준 숫자
			
			num=new int[N];
			
			//숫자 넣기
			for(int i=0; i<N; i++) {
				num[i]=sc.nextInt();
			}
			
			cnt=0;
			//idx, sum
			find(0,0);
			
			System.out.printf("#%d %d\n",tc,cnt);
		}//tc
		
		
	}//main

	private static void find(int idx, int sum) {
		
		//recursion terminates
		if(sum==K) {
			cnt++;
			return;
		}
		
		if(idx==N) return;
		
		//recursive case
		find(idx+1,sum+num[idx]); //지금 인덱스의 숫자 더하고 다음 인덱스로 넘어가기
		find(idx+1,sum); //안 더하고 다음 인덱스로 넘어가기
		
	}
}//class
