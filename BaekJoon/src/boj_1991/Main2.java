package boj_1991;

import java.util.Arrays;
import java.util.Scanner;


class Node{
	char node;
	Node left;
	Node right;
	
	public Node() {
	}

	public Node(char node, Node left, Node right) {
		super();
		this.node = node;
		this.left = left;
		this.right = right;
	}
	
	
}


public class Main2 {
	static char[][] tree;
	static int L,N;
	static String ans="";
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		tree=new char[N+1][3];

		
		
		for(int i=1; i<=N; i++) { 
			tree[i][0]=sc.next().charAt(0);
			tree[i][1]=sc.next().charAt(0);
			tree[i][2]=sc.next().charAt(0);
			
			
			
		}//for i
		
		
		preorder(1);
		System.out.println(ans);
//		ans="";
//		inorder(1);
//		System.out.println(ans);
//		ans="";
//		postorder(1);
//		System.out.println(ans);
//		
		
		
		
		
	}//main

	private static void preorder(int i) {
		if(i<N) {
			if(tree[i][0]!='.') ans+=tree[i][0];
			if(tree)
		preorder(i*2); //L
		preorder(i*2+1); //R
//		i++;
		}
	}//preorder
	
//	private static void inorder(int i) {
//		if(i<N) {
//			if(tree[i][0]!='.') ans+=tree[i][0];
//		inorder(i*2); //L
//		inorder(i*2+1); //R
//		}
//	}//inorder
//	
//	private static void postorder(int i) {
//		if(i<N) {
//			postorder(i*2); //L
//			postorder(i*2+1); //R
//			if(tree[i][0]!='.') ans+=tree[i][0];
//		}
//	}//postorder

}//class
