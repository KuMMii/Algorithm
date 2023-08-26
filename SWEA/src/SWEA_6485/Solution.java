//package SWEA_6485_삼성시의버스노선;
package SWEA_6485;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_6485_삼성시의버스노선/input.txt"));
		Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	
            int N=sc.nextInt();
            int[][] arrAB=new int[N][2];
            
            for(int n=0; n<N; n++){
            	arrAB[n][0]=sc.nextInt(); //A
                arrAB[n][1]=sc.nextInt(); //B
            }//n
            
            int P=sc.nextInt();
            int[] arrP=new int[P];
            for(int p=0; p<P; p++){
            	arrP[p]=sc.nextInt();
            }//p 배열에 넣기
            
            for(int p=0; p<P; p++){
            	int C=arrP[p]; //값을 미리 뽑아주고
            	arrP[p]=0; //그 부분의 배열값은 0으로 바꿔버리기
            	for(int n=0; n<N; n++){
                	if(arrAB[n][0]<=C && C<=arrAB[n][1]){ //P가 저 범위 안에 들어가면 값을 올림
                    	arrP[p]++;
                    }//P 범위 if
                }//n
            }//p
            
            System.out.printf("#%d",tc);
            for(int i : arrP){
            	System.out.print(" "+i);
            }
            System.out.println();
        }//tc
        
	}//main
}//class