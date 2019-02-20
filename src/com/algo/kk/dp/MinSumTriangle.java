package com.algo.kk.dp;

import java.util.ArrayList;

public class MinSumTriangle {

	public static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		int[] dp = new int[a.size()];
		for(int i=0;i<a.size();i++){
			dp[i] = a.get(a.size()-1).get(i); 
		}
		for(int row =a.size()-2; row>=0; row--){
			ArrayList<Integer> rowData = a.get(row);
			for(int i=0;i<rowData.size();i++){
				dp[i] = rowData.get(i) + Math.min(dp[i], dp[i+1]);
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(2);
		triangle.add(row1);
		
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(3);
		row2.add(4);
		triangle.add(row2);
		
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(6);
		row3.add(5);
		row3.add(7);
		triangle.add(row3);
		
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		
		triangle.add(row4);
		
		System.out.println(minimumTotal(triangle));
		
	}

}
