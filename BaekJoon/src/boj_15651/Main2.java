package boj_15651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main2{
    
    public static int[] arr;
    public static int N,M;
    public static StringBuilder str = new StringBuilder();
    
    
    public static void main(String[] args) throws IOException  {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer strT = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(strT.nextToken());
        M = Integer.parseInt(strT.nextToken());
        
        arr = new int[M];
        dfs(0);
        System.out.println(str);
    }
    public static void dfs(int num){
        if(num == M){
            for(int i=0;i<M;i++){
                str.append(arr[i]).append(' ');
            }
            str.append('\n');
            return;
        }
        
        for(int i=1;i<=N;i++){
            arr[num] = i;
            dfs(num + 1);
        }
    }   
 }
