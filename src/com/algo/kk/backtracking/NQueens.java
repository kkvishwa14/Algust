package com.algo.kk.backtracking;

import java.util.ArrayList;

public class NQueens {

	public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a < 4)
            return result;
        int[] queens = new int[a];
        enumerate(queens, 0, result);
        return result;
    }
    public static void enumerate(int[] queens, int placingAtRow, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        
        if(placingAtRow == N)
            addQueensToResult(queens, result);
        else{
            for(int placingAtColumn = 0; placingAtColumn < N; placingAtColumn++){
                queens[placingAtRow] = placingAtColumn;
                if(isSafeToPlace(queens, placingAtRow))
                    enumerate(queens, placingAtRow+1, result);
            }
        }
    }
    public static boolean isSafeToPlace(int[] queens, int n){
        for(int i =0; i < n; i++){
            if(queens[i] == queens[n]){
                return false;
            }
            if(Math.abs(queens[i] - queens[n]) == Math.abs(n - i)) {// same major diagonal
                return false;
            }
        }
        return true;
    }
    public static void addQueensToResult(int[] queens, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        ArrayList<String> temp = new ArrayList<String>();
        for(int i =0; i < N; i++){
            String row = "";
            for(int j = 0; j < N; j++){
                if(queens[i] == j)
                    row += "Q";
                else
                    row += ".";
            }
            temp.add(row);
        }
        result.add(temp);
    }
	public static void main(String[] args) {
		System.out.println(solveNQueens(4));

	}

}
