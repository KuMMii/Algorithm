package SWEA_1952;

import java.util.Scanner;
//DFS 쓰고싶었는데 예전에 배운 재귀를 쓴 느낌. 그래도 잘했어 뿌듯해!!
public class Solution_is {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int T = sc.nextInt();
     for (int k = 1; k <= T; k++) {
         price = new int[5]; // {1일권, 1달권, 3달권, 1년권, 0원}
         plan = new int[12]; // 12개월 이용 계획
         expense = new int[12]; // 각 달에 어떤 이용권 

         for (int i = 0; i < 4; i++) {
             price[i] = sc.nextInt();
         }
         for (int i = 0; i < 12; i++) {
             plan[i] = sc.nextInt();
         }

         minAnswer = price[3]; // 1년 이용권을 최소가격 기준으로 잡음

         DFS(0);

         System.out.println("#" + k + " " + minAnswer);
     }
 }

 static int[] price;
 static int[] plan;
 static int[] expense; // expense[i]가 0이면 1일권, 1이면 1달권, 2면 3달권
 static int minAnswer; // 최소 가격
 static int tempAnswer;

 static void DFS(int idx) {
     // 기저 부분 - 12개월 무슨 이용권으로 할지 정했으니, 총 가격을 계산해본다
     if (idx >= 12) {
         for (int i = 0; i < 12; i++) {
             if (expense[i] == 0) {
                 tempAnswer += (price[expense[i]] * plan[i]); // 1일권은 일수만큼 곱해줌
             } else tempAnswer += price[expense[i]]; // 1달권, 3달권은 걍 가격 더해줌
         }
         if (tempAnswer < minAnswer) {
             minAnswer = tempAnswer; // 최소 가격이면 minAnswer에 대입
         }
         tempAnswer = 0; // 0으로 리셋
         return;
     }

     // 재귀 부분 - 3달, 1달, 1일권 이용할수 있는 모든 경우의수를 expense[]에 대입한다
     // 3달권
     if (idx <= 9) {
         expense[idx] = 2;
         expense[idx + 1] = 4; // price가 0임. 나중에 tempAnswer에 안 더해줄거
         expense[idx + 2] = 4;
         DFS(idx + 3);
     }
     // 1달권
     expense[idx] = 1;
     DFS(idx + 1);
     // 1일권
     expense[idx] = 0;
     DFS(idx + 1);
 }
}