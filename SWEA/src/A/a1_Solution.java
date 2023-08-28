package A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class a1_Solution {
    static int[][] cntArr;
    static int[] ppl;
    static int min;
    static int total;
    
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/A/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++) {
            int N=sc.nextInt(); //마을의 수
            int[][] v=new int[N][N];
            cntArr=new int[N*N][2]; //연결 수를 담는 배열
            ppl=new int[N+1]; //주민 수 담는 배열
            
            //연결고리 담기
            int idx=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    v[i][j]=sc.nextInt();
                    if(v[i][j]==1) {
                        cntArr[idx][0]= i+1;
                        cntArr[idx][1]=j+1;
                        idx++;
                    }
                }
            }//연결고리 담기 for i
            
            //연결 수 절반으로 나누기
            System.out.println(Arrays.deepToString(cntArr));
            
            
            
            
            total=0;
            
            //주민 담기
            for(int i=1; i<=N; i++) {
                ppl[i]=sc.nextInt();
                total+=ppl[i];
            }
            
            for(int i=0; i<cntArr.length;i++) {
                for(int j=0; j<cntArr.length;j++) {
                    if(i!=j && cntArr[i][0]==cntArr[j][1] && cntArr[i][1]==cntArr[j][0]) {
                        cntArr[j][0]=0;
                        cntArr[j][1]=0;
                    }
                }
            }
            
            System.out.println("정리 후 : "+Arrays.deepToString(cntArr));
            
            //연결 1개만 존재하는 거 찾기
            int c=0;
            int cnt=0;
            while(cntArr[c][0]!=0) {
                cnt++;
                if(cntArr[c][0]!=cntArr[c+1][0] && cnt==1) break;
                c++;
                if(cntArr[c-1][0]!=cntArr[c][0]) cnt=0;
            }//while
            
            //한 곳만 연결된 곳 발견하면 우선 걔만 고립시켜서 빼고 그걸 최소값으로 두기
            min=0;
            
            min=Math.abs(total-ppl[cntArr[c][0]]);
            
            divideTown(c, idx);
            
            
        }//tc
    }//main

    private static void divideTown(int curIdx, int idx) {
        int calcul=0;
        
        for(int i=0; i<idx;i++) {
            calcul=Math.abs(total-ppl[cntArr[curIdx][1]]);
            min=Math.min(min, calcul);
            for(int j=0; j<idx; j++) {
                
            }
            divideTown()
        }
        return;
    }
}//class