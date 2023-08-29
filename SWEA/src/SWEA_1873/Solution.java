package SWEA_1873;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int R,C; //배열 길이
	static char[][] field; //배틀필드 담는 배열
	static char[] cmd; //커맨드 담는 배열
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_1873/input.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			R=sc.nextInt();
			C=sc.nextInt();
			
			field=new char[R][C];
			
			for(int i=0; i<R; i++) {
				field[i]=sc.next().toCharArray();
			}
			
			int N=sc.nextInt(); //command length
			cmd=new char[N];
			cmd=sc.next().toCharArray();
			
			//커맨드 순회
			for(char ch : cmd ) {
				if(ch=='S') shoot(); //포탄쏘는 메서드
				else move(ch); //움직이는 메서드
			}//cmd for
			
			
			//출력
			System.out.printf("#%d ",tc);
			for(char[] ch : field) {
				for(char i: ch) {
					System.out.print(i);
				}
				System.out.println();
			}
			System.out.println();
		}//tc
	}//main
	

	//현재 위치
	static int r;
	static int c;
	
	//상하좌우
	static int[] dr={-1,1,0,0};
	static int[] dc={0,0,-1,1};
	
	//방향
	static int arrow;
	
	
	//move
	private static void move(char cmd) {
		//현재 위치
		findMe();
		
		//방향전환
		switch(cmd) {
		case 'U' : arrow=0; field[r][c]='^'; break;
		case 'D' : arrow=1; field[r][c]='v'; break;
		case 'L' : arrow=2; field[r][c]='<'; break;
		case 'R' : arrow=3; field[r][c]='>'; break;
		}//switch
		
		//원래 있던 자리 저장
		int curR=r;
		int curC=c;
		char me=field[r][c]; //현재 화살표 저장
		field[curR][curC]='.';
			
			if(r+dr[arrow]>=0 && r+dr[arrow]<R && c+dc[arrow]>=0 && c+dc[arrow]<C ) { //범위내에 있다면
				if(field[r+dr[arrow]][c+dc[arrow]]=='.') { //평지면
					//움직임
					r+=dr[arrow]; 
					c+=dc[arrow];
				}
			}
		//움직인 자리에 그 화살표 저장해줌
		field[r][c]=me;
		
	}//move
	
	
	
	
	//S
	private static void shoot() {
		findMe();//탱크 위치
		int tr=r;
		int tc=c;
		
		//벽을 만나면 멈추고, 범위를 벗어나면 멈춤
		while(true) {
			
			if((tr+dr[arrow])<0 || (tr+dr[arrow])>=R || (tc+dc[arrow])<0 || (tc+dc[arrow])>=C){ //범위 넘어가면
				break;
			}
			if(field[(tr+dr[arrow])][(tc+dc[arrow])]=='#') { //벽 만나면
				break;
			}
			if(field[(tr+dr[arrow])][(tc+dc[arrow])]=='*') { //벽돌벽 만나면
				field[(tr+dr[arrow])][(tc+dc[arrow])]='.';
				break;
			}
			//그 방향으로 한칸 더 가기
			tr+=dr[arrow];
			tc+=dc[arrow];
			
		}//while
		
		
	}//shoot



	//탱크의 현 위치 찾는 메서드
	private static void findMe() {
		outer : for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if("<^>v".contains(Character.toString(field[i][j]))) {
					r=i;
					c=j;
					
					switch(Character.toString(field[i][j])) {
					case "^" : arrow=0; break;
					case "v" : arrow=1; break;
					case "<" : arrow=2; break;
					case ">" : arrow=3; break;
					
					
					}//switch
					
					break outer;
				}
			}
		}
	}//findMe
	
	
	
	
}//class
