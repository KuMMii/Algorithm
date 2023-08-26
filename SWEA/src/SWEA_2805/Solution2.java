//package SWEA_2805_농작물수확하기;
package SWEA_2805;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
//시간은 이게 더 짧고, 메모리는 더 차지함
class Solution2{
	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/SWEA_2805/input.txt"));
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
        
            //upper triangle (0~start-1)
            for(int r=0; r<start; r++) {
            	//left right space - spreads from the start
            	//each left and right part adds index of row
            	for(int c=start-r; c<=start+r; c++) {
            		sum+=farm[r][c];
            	}
            }//for upper tri
        
            //under triangle(start~N-1)
            for(int r=start; r>=0; r--) {
            	//left right adds index-start
            	for(int c=start-r;c<=start+r; c++) {
            		sum+=farm[N-1-r][c];
            	}
            }//for under tri
        
        
        
        
        System.out.printf("#%d %d\n",tc,sum);
        }//tc
    }//main

}//class