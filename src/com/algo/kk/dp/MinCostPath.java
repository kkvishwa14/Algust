package com.algo.kk.dp;

public class MinCostPath {

	public static int minPathSum(int[][] A) {
        if(A == null){
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int cost[][] = new int[m][n];
        cost[0][0] = A[0][0];
        for(int i=1;i<n;i++){
            cost[0][i] = cost[0][i-1] + A[0][i];
        }
        for(int i=1;i<m;i++){
            cost[i][0] = cost[i-1][0]+A[i][0];
        }
        
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                cost[i][j] = Math.min(cost[i][j-1],cost[i-1][j]) + A[i][j];
            }
        }
        
        return cost[m-1][n-1];
        
    }
	public static void main(String[] args) {
		int a[][] = {
		             		{20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
		            		  {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
		            		  {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
		            		  {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
		            		  {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
		            		  {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
		            		  {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
		            		  {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
		            };
		
		System.out.println(minPathSum(a));

	}

}
