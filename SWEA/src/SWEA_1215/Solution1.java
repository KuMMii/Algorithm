package SWEA_1215;

import java.util.Scanner;

public class Palindrome1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        for(int num = 1; num <= 10; num++) {
            int findNum = sc.nextInt();
            //sc.nextLine();
            
            int count = 0;
            boolean flag = true;
            
            char[][] array = new char[8][8];
            
            //배열에 입력
            for(int i = 0; i < array.length; i++) {
                String str = sc.next(); //nextLine() //a[i] = sc.next().toCharArray();
                for(int j = 0; j < array[i].length; j++) {
                    array[i][j] = str.charAt(j);
                }
            }
            
//            //가로 
//            for(int i = 0; i < array.length; i++) {
//                for(int j = 0; j < array.length - findNum + 1; j++) {
//                    flag = true;
//                    for(int h = 0; h < findNum / 2; h++)
//                        if(array[i][j + h] != array[i][j - h + findNum - 1])
//                            flag = false;
//                    if(flag) count++;
//                }
//            }
//            
//            //세로 
//            for(int i = 0; i < array.length - findNum + 1; i++) {
//                for(int j = 0; j < array.length; j++) {
//                    flag = true;
//                    for(int h = 0; h < findNum / 2; h++)
//                        if(array[i + h][j] != array[i - h + findNum - 1][j])
//                            flag = false;
//                    if(flag) count++;
//                }
//            }
            
            //가로 세로 한번에
            for(int i = 0; i < array.length; i++) {
                for(int j = 0; j < array.length - findNum + 1; j++) {
					// 가로 
                    flag = true;
                    for(int h = 0; h < findNum / 2; h++)
                        if(array[i][j + h] != array[i][j - h + findNum - 1])
                            flag = false;
                    if(flag) count++;
                    
					// 세로
                    flag = true;
                    for(int h = 0; h < findNum / 2; h++)
                        if(array[j + h][i] != array[j - h + findNum - 1][i])
                            flag = false;
                    if(flag) count++;
                }
            }
            
            
            System.out.println("#" + num + " " + count);
        }
    }
}
