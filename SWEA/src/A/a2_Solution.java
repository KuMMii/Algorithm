package A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class a2_Solution {
    static int[][] cell;
    static int C, R,cnt=1;
    static long benefit, max;
    
    public static void main(String[] args) throws FileNotFoundException {
        
        System.setIn(new FileInputStream("src/A_2/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++) {
            
            C=sc.nextInt();
            R=sc.nextInt();
            
            cell=new int[R][C];
            
            //정보 넣기
            for(int r=0; r<R; r++) {
                for(int c=0; c<C; c++) {
                    cell[r][c]=sc.nextInt();
                }
            }
            
            calCostBenefit(0,0);
            
            
            System.out.printf("#%d %d\n",tc, benefit*benefit);
        }//tc
        
        
        
    }//main

    private static void calCostBenefit(int r, int c) {
        
        for(int k=0; k<R*C; k++) {
            long before=benefit;
            benefit=0;
            benefit+=cell[r][c];
            //기본 움직임은 왼위, 위, 오위, 오, 아래, 왼
            int[] dr= new int[]{-1,-1,-1,0,1,0};
            int[] dc= new int[]{-1,0,1,1,0,-1};
            
            //맨끝 애들 걸러줘야함
            if(C%2==1) { //가로 길이가 홀수
                if(r==0) {//맨 윗줄
                    if(c==0) {//맨 첫번째 칸이면 오 아
                        dr= new int[]{0,1};
                        dc=new int[] {1,0};
                    }else if(c==C-1) { //맨끝칸이면 왼 아
                        dr= new int[]{0,1};
                        dc=new int[] {-1,0};
                        
                    }
                }else if(r==R-1) {//맨 아랫줄
                    if(c==0) {//맨 첫번째 칸이면 위 오위 오
                        dr= new int[]{-1,-1,0};
                        dc=new int[] {0,1,1};
                    }else if(c==C-1) { //맨끝칸이면 왼 왼위 위
                        dr= new int[]{0,-1,-1};
                        dc=new int[] {-1,-1,0};
                        
                    }
                    
                }//if 홀수 가로일 때 맨 위 맨 아래
            }else{//짝수 일때
                if(r==0) {//맨 윗줄
                    if(c==0) {//맨 첫번째 칸이면 오 아
                        dr= new int[]{0,1};
                        dc=new int[] {1,0};
                    }else if(c==C-1) { //맨끝칸이면 왼 왼아 아
                        dr= new int[]{0,1,1};
                        dc=new int[] {-1,-1,0};
                        
                    }
                }else if(r==R-1) {//맨 아랫줄
                    if(c==0) {//맨 첫번째 칸이면 위 오위 오
                        dr= new int[]{-1,-1,0};
                        dc=new int[] {0,1,1};
                    }else if(c==C-1) { //맨끝칸이면 왼 위
                        dr= new int[]{0,-1};
                        dc=new int[] {-1,0};
                        
                    }
                    
                }//if 홀수 가로일 때 맨 위 맨 아래
                
            }//if C 홀수 / 짝수
            int max=0;
            for(int j=0; j<3; j++) {
                int nr=0;
                int nc=0;
                for(int i=0; i<dr.length;i++) {
                    if(r+dr[i]>=R || r+dr[i]<0 ||c+dc[i]>=C || c+dc[i]<0) {
                        continue;
                    }else {
                        if(max<cell[r+dr[i]][c+dc[i]]) {
                            
                        }
                        max=Math.max(max, cell[r+dr[i]][c+dc[i]]);
                        nr=dr[i];
                        nc=dc[i];
                    }
                }
                System.out.println("max : "+max);
                benefit+=max;
                c=nr
            }
            
            benefit=Math.max(before, benefit);
            
            
            c++;
            if(c==C) {
                c=0;
                r++;
            }
            
        }//for
    }//method
}//class