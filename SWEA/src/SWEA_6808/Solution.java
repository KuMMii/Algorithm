package SWEA_6808;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static List<Integer> main=new ArrayList<>();
	static List<Integer> friend=new ArrayList<>();
	static int win, lose;
	static boolean[] visited=new boolean[9];
	static int[] arr=new int[9];
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_6808/input.txt"));
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			visited=new boolean[9];
			arr=new int[9];
			main.clear();
			friend.clear();
			win=0; lose=0;
			for(int i=1; i<=18; i++) {//친구꺼에 18까지 우선 넣기
				friend.add(i-1, i);
			}
			
			for(int i=0; i<9; i++) { //주인공에는 새거 넣고 친구에는 입력숫자 빼기
				main.add(sc.nextInt());
				friend.remove(Integer.valueOf(main.get(i)));
			}
			
			
			
			//idx
			perm(0);
			
			System.out.printf("#%d %d %d\n",tc,win,lose);
		}//tc
		
		
		
	}//main

	private static void perm(int idx) {
		//recursion terminated
		int sumA=0;
		int sumB=0;
		if(idx==9) {
			for(int i=0; i<9; i++) {
				if(main.get(i)>arr[i]) {
					sumA+=main.get(i)+arr[i];
				}else {
					sumB+=main.get(i)+arr[i];
				}
			}//for
			
			if(sumA>sumB) win++;
			else lose++;
		}//if
		
		
		
		//recursive case
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			
			arr[idx]=friend.get(i);
			visited[i]=true;
			perm(idx+1);
			visited[i]=false;
		}
		
		
	}//perm

		
}//class
