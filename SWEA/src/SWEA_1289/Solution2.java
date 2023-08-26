//package SWEA_1289_원재의메모리복구하기;
package SWEA_1289;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution2{
	public static void main(String[] args) throws FileNotFoundException{
    
        System.setIn(new FileInputStream("src/SWEA_1289/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	String mry=sc.next();
            int cnt=0; 
            char c='0'; //bc init memory is 0
            
            //if c and mry.(i) is different, cnt++ and change c to that mry.i
            for(int i=0; i<mry.length(); i++) {
            	if(c!=mry.charAt(i)) {
            		cnt++;
            		c=mry.charAt(i);
            	}
            }
        	
        	System.out.printf("#%d %d\n", tc, cnt);
        }//tc
    }//main
}//class