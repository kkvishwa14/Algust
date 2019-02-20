package com.algo.kk.dp;

import java.util.ArrayList;

public class MaxSumNonAdjacent {

	public static  int adjacent(ArrayList<ArrayList<Integer>> A) {
        int incl = Math.max(A.get(0).get(0), A.get(1).get(0)); 
       
        int excl = Integer.MIN_VALUE;
        int exclNew = 0; 
       
        for (int i = 1; i < A.get(0).size(); i++ ) 
        { 
            exclNew = Math.max(excl, incl); 
            if(i==1)
            incl = Math.max(A.get(0).get(i), A.get(1).get(i)); 
            else
            incl = excl + Math.max(A.get(0).get(i), A.get(1).get(i)); 
       
            excl = exclNew; 
        } 
       
        return Math.max(excl, incl); 
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(74);
		row1.add(37);
		row1.add(82);
		row1.add(1);
		
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(66);
		row2.add(38);
		row2.add(16);
		row2.add(1);
		
		grid.add(row1);
		grid.add(row2);
		
		System.out.println(adjacent(grid));
	}

}
