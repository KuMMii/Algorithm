package SWEA_1240;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1240/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			String[] str=new String[N];
			
			//걍 스트링으로 한줄씩 담기
			for(int i=0; i<N; i++) {
				str[i]=sc.next();
			}
			
			String found="";
			//위, 뒤에서부터 돌리기
			outer : for(int i=0; i<N; i++) {
				for(int j=str[i].length()-1; j>=0; j--) {
					if(str[i].charAt(j)=='1') {
						//만약에 맨끝에 있을경우
						if(j==str[i].length()-1) found=str[i].substring(j-55);
						//아닌경우
						else found=str[i].substring(j-55,j+1);
						
						break outer;
					}
				}//for j
			}//for i
			
			String num="";
			
			//7칸씩 자르기
			for(int i=1; i<=8; i++) {
				String seperate="";
				seperate=found.substring(7*(i-1),7*i);
				
				switch(seperate) {
				case "0001101" : num+="0"; break;
				case "0011001" : num+="1"; break;
				case "0010011" : num+="2"; break;
				case "0111101" : num+="3"; break;
				case "0100011" : num+="4"; break;
				case "0110001" : num+="5"; break;
				case "0101111" : num+="6"; break;
				case "0111011" : num+="7"; break;
				case "0110111" : num+="8"; break;
				case "0001011" : num+="9"; break;
				}//switch
			}//for i
			
			int even=0;
			int odd=0;
			int ans=0;
			
			for(int i=0;i<8;i++) {
				if(i%2==1) {
					even+=num.charAt(i)-48;
				}else {
					odd+=num.charAt(i)-48;
				}
			}//for i
			
			//10의 배수이면 숫자들 더하기 아니면 0출력
			if((odd*3+even)%10==0) {
					ans=even+odd;
			}//if 10배수
			
			System.out.printf("#%d %d\n",tc,ans);
		}//tc
		
		
	}//main
	
}//class
