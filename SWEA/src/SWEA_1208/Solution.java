package d3.SWEA_1208;

import java.io.FileInputStream;
import java.util.Scanner;
 

class Solution {
    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("src/d3/SWEA_1208/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int dump = sc.nextInt();
            sc.nextLine(); //enter도 인식해버려서
            String[] arrStr = sc.nextLine().split(" ");
            int[] arr = new int[arrStr.length];
 
            for (int i = 0; i < arrStr.length; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
             
            int min = 100; // 최소값을 가장 큰값으로 해줘야함
            int max = 0;
             
            int maxIdx=0;
            int minIdx=0;
             
            for(int d=0; d<dump; d++) {
                int[] idxes = minMax(arr, min, max);
                maxIdx=idxes[0];
                minIdx=idxes[1];
                 
                     
                arr[maxIdx]--;
                arr[minIdx]++;
                 
                if(arr[maxIdx]-arr[minIdx]==1 || arr[maxIdx]-arr[minIdx]==0) {
                    System.out.printf("#%d %d\n", test_case, arr[maxIdx]-arr[minIdx]);
                    break;
                     
                }
            }
//          여기가 최대 의문인 부분
//          왜 이걸 따로 해줘야 답이 나올까? 아니면 2씩 작음
            int[] idxes = minMax(arr, min, max);
            maxIdx=idxes[0];
            minIdx=idxes[1];
             
            System.out.printf("#%d %d\n", test_case, arr[maxIdx]-arr[minIdx]);
        }
    }
 
    public static int[] minMax(int[] arr, int min, int max) { //최소 최대 인덱스 구하는 메서드
        int maxIdx=0;
        int minIdx=0;
        int[] idxes=new int[2];
         
            for (int j = 0; j < arr.length; j++) { // 최소값, 최대값찾기
                if (arr[j] > max) { // 최대값 설정
                    max = arr[j];
                    maxIdx = j;
                }
                if (arr[j] < min) { // 최소값 설정
                    min = arr[j];
                    minIdx = j;
                }
            }
            //최대값 인덱스
            idxes[0]=maxIdx;
            //최소값 인덱스
            idxes[1]=minIdx;
            return idxes;
             
    }
}