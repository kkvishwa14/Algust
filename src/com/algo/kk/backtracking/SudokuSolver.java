package com.algo.kk.backtracking;

import java.util.ArrayList;

import com.algo.kk.trees.soln;

public class SudokuSolver {
	
	 public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		 int grid[][] = new int[a.size()][a.size()];
		 for(int i=0;i<grid.length;i++){
			 ArrayList<Character> aRow = a.get(i);
			 for(int j=0;j<grid.length;j++){
				 if(aRow.get(j)=='.')
					 grid[i][j]=0;
				 else
					 grid[i][j]=aRow.get(j)-'0';
			 }
		 }
		 solveSudoku(grid);
		 for(int i=0;i<grid.length;i++){
			 ArrayList<Character> aRow = a.get(i);
			 aRow.clear();
			 for(int j=0;j<grid.length;j++){
				 if(grid[i][j]!=0)
					 aRow.add((char)(grid[i][j]+'0'));
				 else
					 aRow.add('.');
			 }
		 }
	 }
	
	boolean solveSudoku(int grid[][]) {
		if (isCompletelyFilled(grid))
			return true;
		int row = 0, col = 0;
		boolean found = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					row = i;
					col = j;
					found = true;
					break;
				}
			}
			if(found)
				break;
		}
		for (int guess = 1; guess <= grid.length; guess++) {
			if (isSafe(grid, row, col, guess)) {
				// System.out.println("placing "+guess+" at row :"+(row+1)+", col:"+(col+1));
				grid[row][col] = guess;
				if (solveSudoku(grid)) {
					return true;
				}
				grid[row][col] = 0;
			}
		}

		return false;

	}
	boolean isCompletelyFilled(int grid[][]){
	    for (int row = 0; row < grid.length; row++) 
	    { 
	       for (int col = 0; col < grid[0].length; col++) {
	    	   if(grid[row][col] == 0){
	    		   return false;
	    	   }
	       }	              
	    } 
	    return true;
	}
	
	boolean isNumAlreadyPlacedInRow(int grid[][], int row, int num) 
	{ 
		int N = grid[0].length;
	    for (int col = 0; col < N; col++) 
	        if (grid[row][col] == num) 
	            return true; 
	    return false; 
	} 
	boolean isNumAlreadyPlacedInCol(int grid[][], int col, int num) 
	{ 
		int N = grid.length;
	    for (int row = 0; row < N; row++) 
	        if (grid[row][col] == num) 
	            return true; 
	    return false; 
	} 
	  
	boolean isNumAlreadyPlacedInBox(int grid[][], int boxStartRow, int boxStartCol, int num) 
	{ 
	    for (int row = 0; row*row <grid.length; row++) 
	        for (int col = 0; col*col < grid.length; col++) 
	            if (grid[row+boxStartRow][col+boxStartCol] == num) 
	                return true; 
	    return false; 
	} 
	boolean isSafe(int grid[][], int row, int col, int num) 
	{ 
		int boxSize = (int)Math.sqrt(grid.length*1.0);
	    return !isNumAlreadyPlacedInRow(grid, row, num) && 
	           !isNumAlreadyPlacedInCol(grid, col, num) && 
	           !isNumAlreadyPlacedInBox(grid, row - row%boxSize , col - col%boxSize, num); 
	} 
	
	void printGrid(int grid[][]) 
	{ 
	    for (int row = 0; row < grid.length; row++) 
	    { 
	       for (int col = 0; col < grid[0].length; col++) 
	             System.out.print(" "+grid[row][col]); 
	       System.out.println(); 
	    } 
	} 

	public static void main(String[] args) {
		int grid[][] = {{8, 0, 9, 4, 5, 0, 7, 0, 0}, 
                {0, 3, 7, 0, 0, 2, 0, 0, 0}, 
                {1, 0, 0, 0, 0, 0, 0, 6, 9}, 
                {4, 0, 0, 8, 7, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 2, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 9, 5, 0, 0, 7}, 
                {3, 4, 0, 0, 0, 0, 0, 0, 8}, 
                {0, 0, 0, 3, 0, 0, 5, 1, 0}, 
                {0, 0, 1, 0, 8, 9, 3, 0, 2}};
                 
		 
		 SudokuSolver ss = new SudokuSolver();
		 long millisStart = System.currentTimeMillis(); 
		 ss.solveSudoku(grid);
		 ss.printGrid(grid);
		 System.out.println("Total Time taken :"+((System.currentTimeMillis()-millisStart))+" msec");
		 
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /*ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		 for(int i=0;i<9;i++){
			 a.add(new ArrayList<Character>());
		 }
		 for(int i=0;i<grid.length;i++){
			 ArrayList<Character> aRow = a.get(i);
			 aRow.clear();
			 for(int j=0;j<grid.length;j++){
				 if(grid[i][j]!=0)
					 aRow.add((char)(grid[i][j]+'0'));
				 else
					 aRow.add('.');
			 }
		 }
		 
		 
		 System.out.println(a);

		 ss.solveSudoku(a);*/
	}

}
