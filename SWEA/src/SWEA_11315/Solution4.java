package SWEA_11315;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution4{
    static char[][] arr;
    static int r=0;
    static int c=0;
	public static void main(String[] args) throws FileNotFoundException{
    	
        System.setIn(new FileInputStream("src/SWEA_11315/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++){
        	
        	int N=sc.nextInt();
            arr=new char[N][N];
            for(int i=0; i<N; i++) {
            	String tmp=sc.next();
            	arr[i]=tmp.toCharArray();
            }
            
            String ans="NO";

            //o 탐색
            outer : for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) {
            		if(arr[r][c]=='o') { //o가 나오면 우측, 오대, 아래, 왼대 확인
            			int cnt1=0;
            			int cnt2=0;
            			int cnt3=0;
            			int cnt4=0;
            			
            			for(int i=1; i<=4; i++) { //4칸만 더 찾으면 되는 거임

            				//우측
            				if(c+i<N) {//범위 내에 있을 때
            					if(arr[r][c+i]=='o') cnt1++;
            				}
            				
            					//오대
            				if(r+i<N && c+i<N) {//범위 내에 있을 때
            					if(arr[r+i][c+i]=='o') cnt2++;
            				}
            					
            					//아래
            				if(r+i<N) {//범위 내에 있을 때
            					if(arr[r+i][c]=='o') cnt3++;
            				}
            					
            					//왼대
            				if(r+i<N && c-i>=0) {//범위 내에 있을 때
            					if(arr[r+i][c-i]=='o') cnt4++;
            				}
            				
            			} //for 4칸
            			
            			if(cnt1==4 || cnt2==4 || cnt3==4 || cnt4==4) {
            				ans="YES";
            				break outer;
            			}
            			
            		} //if 돌려서 o찾기
            	} //c
            } //r
            
            System.out.printf("#%d %s\n",tc, ans);
            
        } //testcase
    }    //main
} //class
