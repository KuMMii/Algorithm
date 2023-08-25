package SWEA_1974_스도쿠검증;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution{
    static int ans=1; // right sdk
    static int arr[][]=new int[9][9]; //sdk arr
    static int num[]=new int[10]; //arr to count sdk's num
    
	public static void main(String[] args) throws FileNotFoundException{
    	
        System.setIn(new FileInputStream("src/SWEA_1974_스도쿠검증/input.txt"));
        Scanner sc= new Scanner(System.in);
    	
        int T= sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	//init
            ans=1;
            num=new int[10];
            
            //putting nums in arr
            for(int r=0; r<9; r++){
            	for(int c=0; c<9; c++){
					arr[r][c]=sc.nextInt();                
                }
            }
        	
            // loops row, col, one set
            outer : for(int i=0; i<9; i++){

            	//row
            	for(int j=0; j<9; j++){
                    num[arr[i][j]]++;
            	}//for j
            	if(verify()==false){
            		ans=0;
            		break outer;
            	}// sum not 9 mul
                    
            	//col
            	for(int j=0; j<9; j++){
                    num[arr[j][i]]++;
            	}//for j
            	if(verify()==false){
            		ans=0;
            		break outer;
            	}// sum not 9 mul
                    
                //set
            	for(int j=0; j<9; j++){
                    if(i%3==0 && j%3==0){ //if r and c is first space of the set
                    	int r=0;
                    	for(int c=0; c<9; c++) {
                    		num[arr[i+r][j+c%3]]++;
                    		if(c%3==2) r++;
                    	}
                    	if(verify()==false){
                    		ans=0;
                    		break outer;
                    	}// sum not 9 mul
                    }//if set
            	}//for j
                    
            	
            	
            }//for i
        	System.out.printf("#%d %d\n",tc,ans);
        }//tc
    
    }//main

    public static boolean verify(){
    	int n=num[1];
        for(int k=1; k<=9;k++){
            if(n!=num[k]) return false;
        }//for each
        return true;
    }//verify
        
}//class