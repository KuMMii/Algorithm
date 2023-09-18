package SWEA_5658;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int T, N, K;
	static String numStr;
	static Set<String> set=new HashSet<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_5658/input.txt"));
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			K=sc.nextInt();
			numStr=sc.next();
			set.clear();
			
			int length=N/4; //사각형 한줄에 몇개의 숫자가 있는지
			for(int i=0; i<length; i++) {
				if(i>0) {
					numStr= numStr.charAt(N-1)+numStr.substring(0,N-1);
				}
				for(int j=1; j<=4; j++) {
					if(j==4) {
						set.add(numStr.substring(length*(j-1)));
					}else {
						set.add(numStr.substring(length*(j-1),length*j));
					}
				}
					
			}//for i
			
			
			String[] strArr=set.toArray(new String[set.size()]);
			Arrays.sort(strArr);
			
			System.out.printf("#%d %d\n", tc, Integer.parseInt(strArr[(strArr.length-K)],16));
			
		}//for tc
		
	}//main
}//class
