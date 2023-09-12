package boj_1417;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Integer> pq=new PriorityQueue<>();
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		//다솜이만 따로 뺌
		int dictator=sc.nextInt();
		
		for(int i=0;i<N-1; i++) {
			pq.add(i);
		}
		
		if(pq.peek()>=dictator) {
		}
		
		
	}//main
}//class
