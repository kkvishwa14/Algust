package com.algo.kk.trees;

import java.util.Scanner;
import java.util.Stack;

public class soln {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		
		int type=0,T=0;
		T = Integer.parseInt(sc.nextLine());
		while(T >0) {
			String line = sc.nextLine();
			String tok[] = line.split(" ");
			if("2".equals(tok[0])) {
				st.push(Integer.parseInt(tok[1]));
			} else {
				if(!st.empty()){
					System.out.println(st.pop());
				}else {
					System.out.println("No Code");
				}
			}
			
			T--;
		}
		
	}
}
