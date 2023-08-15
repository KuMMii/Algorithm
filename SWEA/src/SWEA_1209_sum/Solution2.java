package d3.SWEA_1209_sum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//이거 자꾸 런타임 에러뜸;
class Solution2{

	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/d3/SWEA_1209_sum/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=10;
        
        for(int tc=1; tc<=T;tc++){
        	int test=sc.nextInt(); //인풋 테스트케이스 버림
            int[][] arr=new int[100][100];
            int max=0;
            int horSum=0;
            int verSum=0;
            int diSum1=0;
            int diSum2=0;
            
            
            for(int i=0; i<100; i++){
            	for(int j=0; j<100; j++){
                	arr[i][j]=sc.nextInt();
                }
            }
            
            for(int i=0; i<100; i++){ //가로든 세로든 100 돌리는거
            	
            	horSum=0;
            	verSum=0;
            	//가로 세로
            	for(int j=0; j<100;j++) {
            		horSum+=arr[i][j];
            		verSum+=arr[j][i];
            	}
            	if(max<horSum) max=horSum;
            	if(max<verSum) max=verSum;
            	
            	
            	//왼위에서 오아
                diSum1+=arr[i][i];
            	
            	//왼아에서 오위
                diSum2+=arr[99-i][i];
            	
            	
            	
            }
            if(max<diSum1) max=diSum1;
            if(max<diSum2) max=diSum2;
            
            
            System.out.printf("#%d %d\n",tc,max);
        }
    
    }//main
}