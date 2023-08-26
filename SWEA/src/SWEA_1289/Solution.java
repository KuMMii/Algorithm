package SWEA_1289;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/SWEA_1289/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
            
        	String[] strArr=sc.next().split("");//입력받고 스트링 배열만들기
        	int[] target=new int[strArr.length];
        	
        	for(int i=0; i<strArr.length;i++) {//정수 배열에 변환 후 집어 넣기
        		target[i]=Integer.parseInt(strArr[i]);
        	}
        	
        	int[] arr=new int[target.length]; //자리수똑같은 0의 연속 만들기
        	int cnt=0; 
        	
        	for(int i=0; i<arr.length; i++) { //각 자리수 돌기
        		if(target[i]!=arr[i]) { //만약 다르다면
        			for(int j=i; j<arr.length;j++) { //그 자리수부터 끝까지 바꾸기
        				arr[j]=target[i];
        			}
        			cnt++;
        		}//if 다를때
        	}//for i
        	
        	System.out.printf("#%d %d\n", tc, cnt);
        }//tc
                               
        
    }//main

}//class