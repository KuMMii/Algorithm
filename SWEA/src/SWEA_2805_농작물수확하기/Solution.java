package SWEA_2805_농작물수확하기;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/SWEA_2805_농작물수확하기/input.txt"));
		Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        
            int N=sc.nextInt(); //farm size
            int farm[][]=new int[N][N];
        
        	for(int r=0; r<N; r++){
        		String tmp=sc.next();
            	for(int c=0; c<N; c++){
                	farm[r][c]=tmp.charAt(c)-48;
                }
            }
        
        	int start=N/2; //middle index
            int sum=0;
            for(int r=0; r<=start; r++){ //row line move
                for(int c=0; c<=N/2; c++){
                	sum+=farm[start+r][start+c]; //under lines, mid&left spaces
                	if(c!=0){
                    	sum+=farm[start+r][start-c]; //under lines, right spaces
                    }//if c
                    
                    if(r!=0){
                        sum+=farm[start-r][start+c]; //under lines, mid&left spaces
                        if(c!=0){
                            sum+=farm[start-r][start-c]; //under lines, right spaces
                        }//if c
                    }//if r!=0
                    
                   
                }//col space move
            	
                N-=2;
            
            }//for i
        
        
        
        
        
        
        System.out.printf("#%d %d\n",tc,sum);
        }//tc
    }//main

}//class