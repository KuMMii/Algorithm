package boj_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[][] board;
	static int[] arr = new int[5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = Integer.MIN_VALUE;

		// permutation
		perm(0);
		
		System.out.println(max);

	}// main

	public static void perm(int idx) {
		// recursion terminates
		if (idx == 5) {
			// 이제 진짜 움직여보는거
			max = Math.max(max, move(board));
			return;
		}

		// arr에 숫자 저장(상하좌우)
		for (int i = 0; i < 4; i++) {
			arr[idx] = i;
			perm(idx + 1);
		}

	}// perm

	// arr에 있는 대로 상하좌우로 5번 움직여서 최대값 찾을 메서드
	public static int move(int[][] board) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < 5; i++) {
			tmp = moveArr(i, tmp);
		}
		
		int num=0; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				num=Math.max(num, tmp[i][j]);
			}
		}

		return num;
	}// move

	public static int[][] moveArr(int dir, int[][] tmp) {

		// fix
		for (int i = 0; i < N; i++) {
			int ref = 0;
			int fix = 0;
			int move = 0;
			// move
			for (int j = 0; j < N - 2; j++) {
				switch (dir) {
				// 상
				case 0:
					// 하나 선택
					ref = tmp[j][i];
					fix = i;
					move = j;
					break;
				// 하
				case 1:
					// 하나 선택
					ref = tmp[N - 1 - j][i];
					fix = i;
					move = N - 1 - j;
					break;
				// 좌
				case 2:
					// 하나 선택
					ref = tmp[i][j];
					fix = i;
					move = j;
					break;
				// 우
				case 3:
					// 하나 선택
					ref = tmp[i][N - 1 - j];
					fix = i;
					move = N - 1 - j;
					break;

				default:
					break;
				}

				// 밑줄들 확인
				tmp=checkBehind(fix, move, ref, dir, tmp);

				///////////////////출력존
				for(int[] q:tmp) {
					System.out.println(Arrays.toString(q));
				}
				System.out.println();
				//////////////////////////////////////

			}

		}
		// 땡겨
		tmp = pull(dir, tmp);

//		/////////////////// 출력존
//		for (int[] q : tmp) {
//			System.out.println(Arrays.toString(q));
//		}
//		System.out.println();
//		//////////////////////////////////////

		return tmp;
	}// moveArr

	// 땡기는 메서드
	public static int[][] pull(int dir, int[][] tmp) {

		
		Queue<Integer> q=new LinkedList<>();
		
		//상
		if(dir==0) {
			for(int i=0; i<N; i++) {
				//0 아닌 것만 저장
				for(int j=0; j<N; j++) {
					if(tmp[i][j]!=0) q.add(tmp[i][j]);
					tmp[i][j]=0;
				}
				
				//큐에 담은거 다시 뿌려줄거임
				
				for(int j=0; j<q.size(); j++) {
					tmp[i][j]=q.poll();
				}
				
				
			}
		}
		
		//하
		else if(dir==1) {
			for(int i=N-1; i>=1; i--) {
				//0 아닌 것만 저장
				for(int j=0; j<N; j++) {
					if(tmp[i][j]!=0) q.add(tmp[i][j]);
					tmp[i][j]=0;
				}
				
				//큐에 담은거 다시 뿌려줄거임
				
				for(int j=0; j<q.size(); j++) {
					tmp[i][j]=q.poll();
				}
				
				
			}
		}
			
		//좌
		else if(dir==2) {
			for(int i=0; i<N; i++) {
				//0 아닌 것만 저장
				for(int j=0; j<N; j++) {
					if(tmp[j][i]!=0) q.add(tmp[j][i]);
					tmp[j][i]=0;
				}
				
				//큐에 담은거 다시 뿌려줄거임
				
				for(int j=0; j<q.size(); j++) {
					tmp[j][i]=q.poll();
				}
				
				
			}
		}
		
		
		//우
		else if(dir==3) {
			for(int i=N-1; i>=1; i--) {
				//0 아닌 것만 저장
				for(int j=0; j<N; j++) {
					if(tmp[j][i]!=0) q.add(tmp[j][i]);
					tmp[j][i]=0;
				}
				
				//큐에 담은거 다시 뿌려줄거임
				
				for(int j=0; j<q.size(); j++) {
					tmp[j][i]=q.poll();
				}
				
				
			}
		}
		
		
		
		return tmp;
	}// pull

	// 숫자 합치는 용
	public static int[][] checkBehind(int fix, int move, int ref, int dir, int[][] tmp) {

		// 만약 현재 숫자가 0이면 return
		if (ref == 0)
			return tmp;

//		// 상 숫자 올라가는 거
//		if (dir == 0) {
//			// 선택된 위치 다음부터 끝까지 비교
//			for (int i = move + 1; i <= N - 1; i++) {
//
//				// 값=0
//				if (tmp[fix][i] == 0)
//					continue;
//
//				// 값 같을 때는 합치고 합친 요소자리 0으로 만들기
//				// 그리고 바로 이 배열을 리턴해서 다음자리부터 또 돌게 하기
//				if (tmp[fix][i] == ref) {
//					tmp[fix][move] = ref * 2;
//					tmp[fix][i] = 0;
//					break;
//				}
//			}
//			return tmp;
		/*} else */if (dir == 2) {
			// 선택된 위치 다음부터 끝까지 비교
			for (int i = move + 1; i <= N - 1; i++) {

				// 값=0
				if (tmp[i][fix] == 0)
					continue;

				// 값 같을 때는 합치고 합친 요소자리 0으로 만들기
				// 그리고 바로 이 배열을 리턴해서 다음자리부터 또 돌게 하기
				if (tmp[i][fix] == ref) {
					tmp[move][fix] = ref * 2;
					tmp[i][fix] = 0;
					break;
				}

			}
//			return tmp;
//		} else if (dir == 1) {
//			// 선택된 위치 다음부터 끝까지 비교
//			for (int i = move - 1; i >= 0; i--) {
//
//				// 값=0
//				if (tmp[fix][i] == 0)
//					continue;
//
//				// 값 같을 때는 합치고 합친 요소자리 0으로 만들기
//				// 그리고 바로 이 배열을 리턴해서 다음자리부터 또 돌게 하기
//				if (tmp[fix][i] == ref) {
//					tmp[fix][move] = ref * 2;
//					tmp[fix][i] = 0;
//					break;
//				}
//
//			}
//			return tmp;
		} else if(dir==3) {
			// 선택된 위치 다음부터 끝까지 비교
			for (int i = move - 1; i >= 0; i--) {

				// 값=0
				if (tmp[i][fix] == 0)
					continue;

				// 값 같을 때는 합치고 합친 요소자리 0으로 만들기
				// 그리고 바로 이 배열을 리턴해서 다음자리부터 또 돌게 하기
				if (tmp[i][fix] == ref) {
					tmp[move][fix] = ref * 2;
					tmp[i][fix] = 0;
					break;
				}

			}
		}
		
		
		/////////////////// 출력존
		for (int[] q : tmp) {
			System.out.println(Arrays.toString(q));
		}
		System.out.println();
		//////////////////////////////////////
		
		
		return tmp;

	}// checkBehind

}// class
