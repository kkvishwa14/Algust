package com.algo.kk.dp;

import java.util.ArrayList;

public class DungeonPrincess {
	public static int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int dp[][] = new int[m][n]; 
        dp[m-1][n-1] = A.get(m-1).get(n-1) > 0 ? 1: 
                       Math.abs(A.get(m-1).get(n-1)) + 1; 
       
        for (int i = m-2; i >= 0; i--) 
             dp[i][n-1] = Math.max(dp[i+1][n-1] - A.get(i).get(n-1), 1); 
        for (int j = n-2; j >= 0; j--) 
             dp[m-1][j] = Math.max(dp[m-1][j+1] - A.get(m-1).get(j), 1); 
       
        // fill the table in bottom-up fashion 
        for (int i=m-2; i>=0; i--) 
        { 
            for (int j=n-2; j>=0; j--) 
            { 
                int min_points = Math.min(dp[i+1][j], dp[i][j+1]); 
                dp[i][j] = Math.max(min_points - A.get(i).get(j), 1); 
            } 
         } 
       
         return dp[0][0]; 
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(-2);
		row1.add(-3);
		row1.add(3);
		
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(-5);
		row2.add(-10);
		row2.add(3);
		
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(10);
		row3.add(30);
		row3.add(-5);
		
		grid.add(row1);
		grid.add(row2);
		grid.add(row3);
		
		
		
		System.out.println(calculateMinimumHP(grid));

	}

}
