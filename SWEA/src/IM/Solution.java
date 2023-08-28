package IM;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            
            int N=sc.nextInt(); //학생수
            int M=sc.nextInt(); //문제수
            
            int[] answer=new int[M];
            int[][] student=new int[N][M];
            
            //정답 담음
            for(int m=0; m<M; m++) {
                answer[m]=sc.nextInt();
            }
            
            //학생 답 담음
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    student[n][m]=sc.nextInt();
                }
            }
            
            int score=0;
            int total=0;
            int min=1000;
            int max=0;
            
            //이제 비교
            for(int i=0; i<N; i++) {//학생
                total=0;
                score=0;
                for(int j=0; j<answer.length; j++) { //문제
                    if(student[i][j]==answer[j]) {
                        score++;
                        total+=score;
                    }else {
                        score=0;
                    }//if
                }//j
                max=Math.max(max, total);
                min=Math.min(min, total);
            }//i
            
            System.out.printf("#%d %d\n", tc,max-min);
            
            
        }//tc
        
        
    }//main

}//class