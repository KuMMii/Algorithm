package SWEA_1979;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution2{
	public static void main(String[] args) throws FileNotFoundException{
    	System.setIn(new FileInputStream("src/SWEA_1979/input.txt"));
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
            
            
            //row
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		int cntR=0;
            		int cntC=0;
            		
            		int nr=i;
            		int nc=j;
            		
            		if(arr[i][j]==1) { // 1 만났을때
            			nr++;
            			nc++;
   
            			// column move
            			while(nc<N && arr[i][nc]==1) { //범위 내에 있고 1일때
            				nc++;
            				cntC++;
            			}//while
            			
            			//row move
            			while(nr<N && arr[nr][j]==1) { //범위 내에 있고 1일때
            				nr++;
            				cntR++;
            			}//while
            			
            			
            			
            			if(cntR==K-1) { //찾은 곳 제외하고 세서 
            				if(i-1<0) {
            					ans++;
            				}else if(arr[i-1][j]==0) {
            					ans++;
            				}
            			}
            			if(cntC==K-1) { //찾은 곳 제외하고 세서 
            				if(j-1<0) {
            					ans++;
            				}else if(arr[i][j-1]==0) {
            					ans++;
            				}
            			}
            			
            		}//if ==1
            		
            		
            	}//for j
            }//for i
            
            
            
            
        System.out.printf("#%d %d\n",tc,ans);
        }//tc
    
    }//main

}//class