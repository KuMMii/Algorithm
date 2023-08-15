package d2.SWEA_2001;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("src/d2/SWEA_2001/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	int N=sc.nextInt();
            int M=sc.nextInt();
            
            int arr[][]=new int[N][N];
            for(int i=0; i<N;i++){
            	for(int j=0; j<N;j++){
                	arr[i][j]=sc.nextInt();
                }
            }
        
      	  	int sum=0;
			int max=0;
            
			//앞에서부터 돌리는 경우임
            for(int i=0; i<=N-M;i++){
                
            	for(int j=0; j<=N-M;j++){
                    sum=0;
                	for(int r=0; r<M;r++){
                		for(int c=0; c<M;c++) {
                			sum+=arr[i+r][j+c];
                			
                		}
                    }
                    if(max<sum){
                    	max=sum;
                    }
                }//i for
            }//j for
            
            
        
        
        System.out.printf("#%d %d\n",tc,max);
        }
                   
    
    
    }
}