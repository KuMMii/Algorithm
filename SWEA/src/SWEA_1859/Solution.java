package SWEA_1859;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1859/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			long[] arr=new long[N]; //array to save price
			
			for(int n=0; n<N; n++) {
				arr[n]=sc.nextLong();
			}//n
			
			long max=arr[N-1];
			long sum=0;
//			System.out.println(Arrays.toString(arr));
			//traverse from the end
			for(int i=N-1; i>=0; i--) {
				if(max<arr[i]) max=Math.max(max, arr[i]);
				sum+=(max-arr[i]);
			}
			
			System.out.printf("#%d %d\n",tc,sum);
		}//tc
	}//main
}//class
