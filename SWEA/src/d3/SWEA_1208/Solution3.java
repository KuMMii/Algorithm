package d3.SWEA_1208;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
 

class Solution3 {
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
        		sort();
        		if(arr[99]-arr[0]<=1) {
        			answer=arr[99]-arr[0];
        			break;
        		}
        		arr[0]++;
        		arr[99]--;
        		
        	}
        	//위에서 변화만 주고 다시 정렬을 안시켜서 정렬을 한번 더해야 하는 거였음!!!!
        	sort();
        	answer=arr[99]-arr[0];
        	
        	
        	
             
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
	public static void sort() {
		
		int N=arr.length;
		//selection sort
		
		for(int i=0; i<N-1;i++) {
			int minIdx=i;
			for(int j=i+1; j<N; j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx=j;
				}
			}
			int tmp=arr[minIdx];
			arr[minIdx]=arr[i];
			arr[i]=tmp;
		}
		
		
	}
 
}