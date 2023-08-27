package SWEA_1228_암호문1;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Solution2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			List<Integer> list=new LinkedList<>();
			int N=sc.nextInt();
			
			for(int n=0; n<N; n++) {
				int tmp=sc.nextInt();
				list.add(tmp);
			}
			
			int O=sc.nextInt();
			for(int i=0; i<O; i++) {
				sc.next();
				int idx=sc.nextInt();
				int y=sc.nextInt();
				
				for(int j=0; j<y; j++, idx++) {
					int tmp=sc.nextInt();
					list.add(idx, tmp);
				}
			}
			
			System.out.printf("#%d", tc);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}//tc
		
	}//main

}//class
