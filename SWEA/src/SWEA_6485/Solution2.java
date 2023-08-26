//package SWEA_6485_삼성시의버스노선;

package SWEA_6485;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//이게 메모리, 시간 더 들어감

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_6485/input.txt"));
		Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	int[] busStop=new int[5001]; //5000 bus stop
        	
        	int N=sc.nextInt();
        	
        	for(int i=0; i<N; i++) { //A, B input
        		int A=sc.nextInt();
        		int B=sc.nextInt();
        		
        		//add 1 when the busStop is between A and B
        		for(int j=A; j<=B; j++) {
        			busStop[j]++;
        		}
        	}//for N
        	
        	int P=sc.nextInt();
        	int[] result=new int[P];
        	
        	for(int i=0; i<P; i++) {
        		//tmp is index of busStop[]
        		int tmp=sc.nextInt();
        		result[i]=busStop[tmp];
        	}
        	
        	System.out.printf("#%d", tc);
        	for(int i : result) {
        		System.out.print(" "+i);
        	}
        	System.out.println();
        }//tc
        
	}//main
}//class
