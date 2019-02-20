package com.algo.kk.dp;

import java.util.Arrays;
import java.util.List;

public class CoinsInALine {

	public static int optimalPoints(List<Integer> coins){
		int n = coins.size();
		int table[][] = new int[n][n]; 
		   
	    for (int diagonal = 0; diagonal < n; ++diagonal) { 
	        for (int i = 0, j = diagonal; j < n; ++i, ++j) { 
	  
	            // Here x is value of F(i+2, j), y is F(i+1, j-1) and 
	            // z is F(i, j-2) in above recursive formula 
	            int x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
	            int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
	            int z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
	  
	            table[i][j] = Math.max(coins.get(i) + Math.min(x, y), coins.get(j) + Math.min(y, z)); 
	        } 
	    } 
	  
	    return table[0][n - 1];
	}
	
	
	public static void main(String[] args) {
		Integer coins[] = {3,9,1,2};
		System.out.println(optimalPoints(Arrays.asList(coins)));
	}

}
