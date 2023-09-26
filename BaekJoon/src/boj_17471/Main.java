package boj_17471;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int N,min; //town quan
	static int[][] adjarr, town;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		adjarr=new int[N][N]; //idx starts from 0
		town=new int[N][2];
		visited=new boolean[N];
		min=Integer.MAX_VALUE;
		
		for(int i=0; i<N;i++) {
			town[i][0]=sc.nextInt();
			town[i][1]=i;
		}
		
		for(int i=0; i<N; i++) {
			int n=sc.nextInt();
			for(int j=0; j<n; j++) {
				adjarr[i][j]=1;
			}
		}
		
		//input fin
		
		
		powerset(0);
		
		System.out.println(min);
		
	}//main

	public static void powerset(int idx) {
		
		//recursion terminates
		if(idx==N) {
			List<Integer> group1=new ArrayList<>();
			List<Integer> group2=new ArrayList<>();
			for(int i=0; i<N;i++) {
				if(visited[i]) {
					group1.add(i);
				}else {
					group2.add(i);
				}
			}
			
			//when 2 groups are all connected
			if(union_Find(group1,group2)) {
				int sum1=0;
				for(int n : group1) {
					sum1+=n;
				}
				int sum2=0;
				for(int n : group2) {
					sum2+=n;
				}
				int diff=Math.abs(sum1-sum2);
				min=Math.min(min, diff);
				
				
			}
			return;
		}
		
		visited[idx]=true;
		powerset(idx+1);
		
		visited[idx]=false;
		powerset(idx+1);
		
	}//powerset

	
	public static boolean union_Find(List<Integer> g1, List<Integer> g2) {
		Set<Integer> set=new HashSet<Integer>();
		Queue<Integer> q=new LinkedList<Integer>();
		
		
		boolean[] sel1=new boolean[N];
		boolean[] sel2=new boolean[N];
		
		//filter size==all
		if(g1.size()==N || g2.size()==N) return false;
		
		q.add(g1.get(0));
		sel1[g1.get(0)]=true;
		
		while(!q.isEmpty()) {
			int t=q.poll();
			
			for(int i=1; i<g1.size(); i++) {
				if(!sel1[i]&&adjarr[t][i]==1) {
					union(t,i);
				}
			}
		}//while g1
		
		q.clear();
		q.add(g2.get(0));
		sel2[g2.get(0)]=true;
		
		while(!q.isEmpty()) {
			int t=q.poll();
			
			for(int i=1; i<g2.size(); i++) {
				if(!sel2[i]&&adjarr[t][i]==1) {
					union(t,i);
				}
			}
		}//while g2
		
		for(int i=0; i<N; i++) {
			set.add(town[i][1]);
		}
		System.out.println(set);
		if(set.size()==2) return true;
		else return false;
		
	}//union_Find

	public static void union(int a, int b) {
		int fa=findset(a);
		int fb=findset(b);
		
		if(fa!=fb) town[b][1]=fa;
		
	}//union

	public static int findset(int x) {
		
		if(town[x][1]!=x) {
			town[x][1]=findset(town[x][1]);
		}
		
		return town[x][1];
	}//findset
	
}//class
