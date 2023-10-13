package SWEA_5656_벽돌깨기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	
	static int N,W,H,min;
	static List<Integer>[] list;
	static int[] arr; //순열용
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_5656_벽돌깨기/input.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1; tc<=1; tc++) {
			
			N=sc.nextInt();
			W=sc.nextInt();
			H=sc.nextInt();
			
			int[][] tmparr=new int[H][W];
			arr=new int[W];
			
			//임시로 리스트에 넣게 받아줌
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					tmparr[i][j]=sc.nextInt();
				}
			}
			
			list=new LinkedList[W];
			for(int i=0; i<W; i++) {
				list[i]=new LinkedList<>();
			}//LinkedList 초기화
			
			//리스트에 담기
			for(int w=0; w<W; w++) {
				for(int h=H-1; h>=0;h-- ) {
					if(tmparr[h][w]>0) {
						list[w].add(tmparr[h][w]);
					}
				}
			}//list에 입력
			
			//input fin
			
			////////////////////리스트뽑기
//			for(List<Integer> l : arr) {
//				System.out.println(l);
//			}
//			System.out.println();
			//////////////////////
			
			min=Integer.MAX_VALUE;
			
			
			List<Integer>[] tmp=new LinkedList[W];
			for(int i=0; i<W; i++) {
				tmp[i]=new LinkedList<>();
			}//LinkedList 초기화
			
			//임시 리스트 만들었음,,
			for(int i=0; i<W; i++) {
				for(int j=0; j<list[i].size(); j++) {
					tmp[i].add(list[i].get(j));
				}
			}
			
			
			perm(0,tmp);
			
			
			System.out.printf("#%d %d\n", tc,min);
		}//tc
	}//main

	public static void perm(int depth,List<Integer>[] tmp) {
		
//		List<Integer>[] tmp2=new LinkedList[W];
//		for(int i=0; i<W; i++) {
//			tmp[i]=new LinkedList<>();
//		}//LinkedList 초기화
//		
//		//임시 리스트 만들었음,,
//		for(int i=0; i<W; i++) {
//			for(int j=0; j<tmp[i].size(); j++) {
//				tmp2[i].add(tmp[i].get(j));
//			}
//		}
		
		
		if(depth==N) {
			int cnt=0;
			
			for(List<Integer> l : tmp) {
				if(l.size()>0) cnt+=l.size();
			}
			System.out.println(cnt);
			min=Math.min(cnt, min);
			
//////////////////리스트뽑기
//for(List<Integer> l : tmp) {
//System.out.println(l);
//}
//System.out.println();
//////////////////////
			
			return;
		}
		
		for(int i=0; i<W; i++) {
			if(tmp[i].size()>0) {
				arr[depth]=i;
				perm(depth+1,findMin(tmp,i));
			}
			
		}
	}//perm

	private static  List<Integer>[] findMin(List<Integer>[] tmp, int idx) {
		
		//벽돌에 쓰여진 값
		int num=tmp[idx].get(tmp[idx].size()-1);
		//터트릴 벽돌의 인덱스
		int brick=tmp[idx].size()-1;
		
		//세로줄 지우기
		for(int j=brick; j>=brick+1-num; j--) {
			if(j>=0)		tmp[idx].remove(j);
		}
		//가로 지우기
		for(int j=idx-num; j>=idx+num; j++) {
			//범위 내에 있고 리스트의 길이가 인덱스보다 길면
			if(0<=j && j<W && tmp[idx].size()>brick) {
				tmp[idx].remove(brick);
			}
		}
			
			
		
////////////////////리스트뽑기
//for(List<Integer> l : tmp) {
//	System.out.println(l);
//}
//System.out.println();
//////////////////////
		
		return tmp;
	}//dp
}//class
