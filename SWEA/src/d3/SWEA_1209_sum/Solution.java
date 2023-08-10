package SWEA_1209_sum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution{

	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/SWEA_1209_sum/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=10;
        
        for(int tc=1; tc<=T;tc++){
        	int test=sc.nextInt(); //인풋 테스트케이스 버림
            int[][] arr=new int[100][100];
            int max=0;
            int sum=0;
            for(int i=0; i<100; i++){
            	for(int j=0; j<100; j++){
                	arr[i][j]=sc.nextInt();
                }
            }
            
            for(int i=0; i<100; i++){ //가로든 세로든 100 돌리는거
            	int sum1=0;
            	int sum2=0;
            	int sum3=0;
            	int sum4=0;
            	
            	for(int j=0; j<100; j++){ //가로줄 합
                	sum1+=arr[i][j];
                }
            	if(sum1>max){
            		max=sum1;
            	}
            	
                for(int j=0; j<100; j++){ //세로줄 합
                	sum2+=arr[j][i];
                }
                if(sum2>max){
                	max=sum2;
                }                
                
                //오아대
                int r=0;
                int c=0;
                sum3=0;
                sum3+=arr[r++][c++];
            	if(sum3>max){max=sum3;}
            
            	//왼아대
                r=0;
                c=99;
                sum4=0;
                sum4-=arr[r++][c--];
                if(sum4>max){max=sum4;}
            
            }
            
            System.out.printf("#%d %d\n",tc,max);
        }
    
    }//main
}