package YYP.bj_1592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1592 {
	public static void main(String[] args) throws IOException{
	    	
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String[] strArr=br.readLine().split(" ");
	        int M=Integer.parseInt(strArr[0]);
	        int N=Integer.parseInt(strArr[1]);
	        int L=Integer.parseInt(strArr[2]);
	        
	        int[] arr=new int[M];
	        
	        int cnt=0;
	        int idx=0;
	        while(compare(arr,N)){
	        	if(idx%2==1) {
	        		
		            if((idx+L) > (M-1)){
		                Math.abs((idx+L)-M);
		            }else{
		                idx+=L;
		            }
	        	}else {
	        		if((idx-L) <0){
	        			Math.abs((idx-L)-M);
	        		}else{
	        			idx-=L;
	        		}
	        		
	        	}
	            arr[idx]++;
	            cnt++;
	        }
	        System.out.println(cnt);
	    }
	    
	    public static boolean compare(int[] arr, int N) {
			
			for(int i=0; i<arr.length;i++) {
				if(arr[i]==N) {
					return false;
				}
			}
			return true;
		}
}

class Main{
    
}
