package SWEA_1213_String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1213_String/test_input.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int test=sc.nextInt(); //필요없음
			String target=sc.next();
			String sen=sc.next();
			int cnt=0; //몇개인지 세는 변수
			int i=0; //sen의 인덱스
			int j=0; //target의 인덱스
			
			int I= sen.length();
			int J= target.length();
			
			while(i<I) { //sen 문장끝까지 돌기
				if(sen.charAt(i)!=target.charAt(j)) {
					i-=j;
					j=-1;
				}
				i++;
				j++;
				if(j==J) { //단어가 전부 맞았다면 개수세고 다시 단어 처음으로 돌아가기
					cnt++;
					j=0;
				}
			}
			
			
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}
