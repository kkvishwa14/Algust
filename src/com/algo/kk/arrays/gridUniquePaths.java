package com.algo.kk.arrays;

import java.util.ArrayList;

public class gridUniquePaths {
	public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        if(A== null || A.size()==0){
            return 0;
        }
        int m = A.size();
        int n = A.get(0).size();
        int[][] sol = new int[m][n];
        if(A.get(0).get(0) == 0){
        	sol[0][0] = 1;
        } else {
        	sol[0][0] = 0;
        }
        
        for(int i=1;i<m;i++){
        	int curCell = (A.get(i)).get(0);
            if(curCell == 1) {
            	sol[i][0] = 0;
            } else {
            	sol[i][0] = sol[i-1][0];
            }
        }
        
        for(int j=1;j<n;j++){
        	int curCell = (A.get(0)).get(j);
            if(curCell == 1) {
            	sol[0][j] = 0;
            } else {
            	sol[0][j] = sol[0][j-1];
            }
        }
        int OBSTACLE = 1;
        
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int curCell = (A.get(i)).get(j);
                if(curCell == OBSTACLE){
                    sol[i][j] = 0;
                } else{
                    sol[i][j] = sol[i-1][j]+sol[i][j-1];
                }
            }
        }
        
        return sol[m-1][n-1];
    }

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(0);
		row.add(0);
		row.add(0);
		input.add(row);

		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(0);
		row1.add(1);
		row1.add(0);
		input.add(row1);

		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(0);
		row2.add(0);
		row2.add(0);
		input.add(row2);
		
		System.out.println(uniquePathsWithObstacles(input));

	}

}
