package SWEA_1860_진기의최고급붕어빵;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) throws FileNotFoundException{
		
        System.setIn(new FileInputStream("src/SWEA_1860_진기의최고급붕어빵/input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
        	int N=sc.nextInt(); //손님 수
            int M=sc.nextInt(); //만드는 시간
            int K=sc.nextInt(); //만드는 개수
            String ans="Possible";
            
            int[] arr=new int[N]; //손님 담는 배열
            
            for(int n=0; n<N; n++){
            	arr[n]=sc.nextInt();
            }//손님 시간 담는 배열
        
            //삽입 정렬
        	for(int i=1; i<N; i++){
            	int key=arr[i];
                int j;
                
                for(j=i-1; j>=0 && arr[j]>key ; j--){
                	arr[j+1]=arr[j];
                }//for key보다 작으면 스왑
            	arr[j+1]=key;
            }// for 배열 원소 선택
        	
        	
            int min=0; //구간 시작하는 인덱스
            int max=0; //구간 마지막 인덱스
            int bung=0; //붕어빵 개수
            
            
        	for(int i=0; i<N-1; i++){
            	if(arr[i]<M) { //제일 처음 걸리는 시간보다 더 빨리오면 바로 break
                	ans="Impossible";
                    break;
                }//if break
                
            	if(i+1==N-1){//if 마지막이면 걔가 무조건 max임
            		max=N-1;
            	}//if 마지막인지

            	while(arr[i+1]<M) { //M보다 값이 작아질때까지
            		
	                if(arr[i+1]>=M){//M보다 크거나 같아지는 순간 다음 턴으로 넘어가야함
	                    max=i;
	                }//if M보다 크거나 같은지 확인
	                
	                M+=M;
	                bung+=M;
            	}

            	if(max-min+1>K){ //구간내의 사람수가 구울수 있는 붕보다 많아지면 불가넝.
            		ans="Impossible";
            		break;
            	}//if 사람이 붕보다 많은지
            	else {
            		bung-=(max-min+1);
            	}
            	min=i+1;
            	
            }//for 손님들 다 돌려봄
        
        
        
        	System.out.printf("#%d %s\n",tc,ans);
        }//tc
    }//main
}//class