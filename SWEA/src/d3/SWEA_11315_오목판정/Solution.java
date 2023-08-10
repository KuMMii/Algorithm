package SWEA_11315_오목판정;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution{
    static char[][] arr;
    static int r=0;
    static int c=0;
	public static void main(String[] args) throws FileNotFoundException{
    	
        System.setIn(new FileInputStream("src/SWEA_11315_오목판정/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++){
        	
        	int N=sc.nextInt();
            arr=new char[N][N];
            
            for(int i=0; i<N; i++) {
            	String str=sc.next();
                for(int j=0; j<N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            boolean result=false;
            outer : for(int i=0; i<N;i++){
            	for(int j=0; j<N;j++){
                	if(arr[i][j]=='o'){
                        r=i;
                        c=j;
                     	result=isFiveThere(N);
                        if(result==true){
                        	System.out.printf("#%d YES\n",tc);
                            break outer;
                        }
                    }
                }
            }
            if(result==false) {
            	System.out.printf("#%d NO\n",tc);
            	
            }
            
        } //testcase
    }    //main
                     
	
	public static boolean isFiveThere(int N){          
        //오른쪽, 오른아래대각, 밑, 왼아래대각
        int[] dr={0,1,1,1};
        int[] dc={1,1,0,-1};
        
        //미리 기준점 저장
        int cr=r;
        int cc=c;
        int count=1;
        //오른쪽
        for(int now=0; now<4; now++){ //이미 돌 하나에서 시작해서 4번만 돌리면 됨
            if(c+dc[0]<N){
                if(arr[r+dr[0]][c+dc[0]]=='o'){
                    count++;
                    c++;
                    if(count==5){
                    	return true;
                    }
                }
        	}
        }
        //오아대
        count=1;
        r=cr;
        c=cc;
        for(int now=0; now<4; now++){ //이미 돌 하나에서 시작해서 4번만 돌리면 됨
            if(c+dc[1]<N && r+dr[1]<N){
                if(arr[r+dr[1]][c+dc[1]]=='o'){
                    count++;
                    r++;
                    c++;
                    if(count==5){
                    	return true;
                    }
                }
        	}
        }
        //아래
        count=1;
        r=cr;
        c=cc;
        for(int now=0; now<4; now++){ 
            if(r+dr[2]<N){
                if(arr[r+dr[2]][c+dc[2]]=='o'){
                    count++;
                    r++;
                    if(count==5){
                    	return true;
                    }
                }
        	}
        }
        //왼아대
        count=1;
        r=cr;
        c=cc;
        for(int now=0; now<4; now++){ 
            if(r+dr[3]<N && c+dc[3]>=0){
                if(arr[r+dr[3]][c+dc[3]]=='o'){
                    count++;
                    r++;
                    c--;
                    if(count==5){
                    	return true;
                    }
                }
        	}
        }
		
        return false;
                     
    }                 
}
