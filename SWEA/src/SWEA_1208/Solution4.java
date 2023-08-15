package d3.SWEA_1208;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
 

class Solution4 {
	static int[] arr;
    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("src/d3/SWEA_1208/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int test_case = 1; test_case <= T; test_case++) {
        	int dump=sc.nextInt();
        	arr=new int[100];
        	
        	for(int i=0; i<100; i++) {
        		arr[i]=sc.nextInt();
        	}
        	int answer=0;
        	for(int i=0; i<dump; i++) {
        		arr=sort();
        		if(arr[99]-arr[0]<=1) {
        			answer=arr[99]-arr[0];
        			break;
        		}
        		arr[0]++;
        		arr[99]--;
        		
        	}
        	//위에서 변화만 주고 다시 정렬을 안시켜서 정렬을 한번 더해야 하는 거였음!!!!
        	arr=sort();
        	answer=arr[99]-arr[0];
        	
        	
        	
             
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
	public static int[] sort() {
		
		int N=arr.length;
		//counting sort
		int max=-1;
		for(int i=0; i<N;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		int[] count=new int[max+1];
		
		for(int i=0; i<N; i++) {
			count[arr[i]]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i]+=count[i-1];
		}
		
		int[] sortArr=new int[N];
		for(int i=N-1; i>=0; i--) {
			sortArr[--count[arr[i]]]=arr[i];
		}
		return sortArr;
	}
 
}