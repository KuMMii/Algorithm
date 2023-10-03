package boj_2839;

import java.util.Arrays;
import java.util.Scanner;

public class DP {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sugar=sc.nextInt();
		sc.close();
		
		int[] kg=new int[sugar+1];
		kg[3]=1;
		if(sugar>=5) kg[5]=1;
		
		
		for(int i=3; i<=sugar; i++) {
			if(kg[i-3]>0) {
				kg[i]=kg[i-3]+1;
			}
			if(i>8&&kg[i-5]>0) {
				//3키로 일때 계산 안했으면 무조건 최소값이 0이 돼서 이 조건 넣어줌
				if(kg[i]!=0) kg[i]=Math.min(kg[i], kg[i-5]+1);
				else kg[i]=kg[i-5]+1;
			}
		}
		
		if(kg[sugar]==0) System.out.println(-1);
		else System.out.println(kg[sugar]);
	}
}
