package SWEA_11315;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution2{ //1보다 시간, 메모리 더 차지함........;
    static char[][] arr;
    static int r=0;
    static int c=0;
	public static void main(String[] args) throws FileNotFoundException{
    	
        System.setIn(new FileInputStream("src/d3/SWEA_11315/input.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++){
        	
        	int N=sc.nextInt();
            arr=new char[N][N];
            
            
            for(int i=0; i<N; i++) {
            	String str=sc.next();
            	for(int j=0; j<N; j++) {
            		arr[i][j]=str.charAt(j);
            		
            	}
            }
            //오른쪽, 오대, 아래, 왼대
            int[] dr= {0,1,1,1};
            int[] dc= {1,1,0,-1};
            
            String answer="NO";
            outer : for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) {
            		if(arr[r][c]=='o') { //o를 발견하면 오른쪽, 오대, 아래, 왼대 5개 있는지 찾기 
            			for(int i=0; i<4; i++) { //오른쪽, 오대, 아래, 왼대 돌기
            				int count=1;
            				for(int j=1;j<=4; j++) {
            					
	            				int nr=r+(dr[i]*j);
	            				int nc=c+(dc[i]*j);
	            				
	            				if(nr<0||nr>=N||nc<0||nc>=N) { //범위 나갈 때
	            					continue;
	            				}else if(arr[nr][nc]=='o'){ //o 나올때
	            					count++;
	            					if(count==5) {
	            						answer="YES";
	            						break outer;
	            					}
	            				}else { //not 'o'
	            					continue;
	            				}
	            			}
            			}
            		}
            	}
            }
            
            System.out.printf("#%d %s\n",tc, answer);
            
            
        } //testcase
    }    //main
                     
}
