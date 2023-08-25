package SWEA_1979_어디에단어가들어갈수있을까;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) throws FileNotFoundException{
    	System.setIn(new FileInputStream("src/SWEA_1979_어디에단어가들어갈수있을까/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        
            int N=sc.nextInt(); //배열 길이
            int K=sc.nextInt(); //단어 길이
           	int ans=0; //가능한 행열 수
            
            int[][] arr=new int[N][N];
            
            //배열 담기
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	arr[i][j]=sc.nextInt();
                }//j
            }//i    
            
            
            //1탐색
            for(int r=0; r<=N-K; r++){
            	for(int c=0; c<=N-K; c++){
                    if(arr[r][c]==1){ //1발견
                    	System.out.printf("r : %d  c : %d\n",r,c);
                        int rCnt=0;
                        int cCnt=0;
                    	for(int i=1; i<K; i++){
                            
                            if(r+i<N){//세로범위
                            	if(arr[r+i][c]==0) {//세로 찾기
                            		
                            	}
                                else rCnt++;
                            }//if 세로 범위
                        	
                            if(c+i<N){//가로범위
                            	if(arr[r][c+i]==0) {//가로 찾기
                            		
                            	}
                                else cCnt++;
                            }//if 가로 범위
                            System.out.println(rCnt);
                            System.out.println(cCnt);
                        }//for 1찾은 곳 기준 k까지 감
                        
                    	boolean flag=true;
                        if(rCnt==K-1){//가로 가능하면 양옆 확인
                        	System.out.println("가로 성공");
                            if(r+K<N){//가로 범위
                                if(arr[r+K][c]==1){
                                	flag=false;
                                }//if 양옆 확인
                            }else if(r-1>=0){//가로 범위
                                if(arr[r-1][c]==1){
                                	flag=false;
                                }//if 양옆 확인
                            }
                            if(flag) ans++;
                        }//if 가로가넝
                        
                        
                        flag=true;
                        if(cCnt==K-1){//세로 가능하면 양옆 확인
                        	System.out.println("세로 성공");
                            if(c+K<N){//가로 범위
                                if(arr[r][c+K]==1){
                                	flag=false;
                                }//if 양옆 확인
                            }else if(c-1>=0){//가로 범위
                                if(arr[r][c-1]==1){
                                	flag=false;
                                }//if 양옆 확인
                            }
                            if(flag) ans++;
                        }//if 세로가넝
                        
                        
                    }//if
                }//j
            }//i  
        System.out.printf("#%d %d\n",tc,ans);
        }//tc
    
    }//main

}//class