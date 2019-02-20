package com.algo.kk.dp;

import java.util.Arrays;
import java.util.List;

public class CoinsInAlinePair {

	static class Pair{
        int first, second;
        int pick=0;
        public String toString(){
            return first + " " + second + " " + pick;
        }
    }
	
	public static int optimalPoints(List<Integer> coins){
		int n = coins.size();
		Pair[][] moves = new Pair[n][n];
        
        for(int i=0; i < moves.length; i++){
            for(int j=0; j < moves[i].length; j++){
                moves[i][j] = new Pair();
            }
        }
        
        for(int i=0; i < n; i++){
            moves[i][i].first = coins.get(i);
            //to track the sequence of moves
            moves[i][i].pick = i;
        }
        
        for(int l = 2; l <= n; l++){
            for(int i=0; i <= n - l; i++){
                int j = i + l -1;
                if(coins.get(i) + moves[i+1][j].second > moves[i][j-1].second + coins.get(j)){
                    moves[i][j].first = coins.get(i) + moves[i+1][j].second;
                    moves[i][j].second = moves[i+1][j].first;
                    moves[i][j].pick = i;
                }else{
                    moves[i][j].first = coins.get(j) + moves[i][j-1].second;
                    moves[i][j].second = moves[i][j-1].first;
                    moves[i][j].pick =j;
                }
            }
        }
        
        return moves[0][n-1].first;
	}
	public static void main(String[] args) {
		Integer coins[] = {3,9,1,2};
		System.out.println(optimalPoints(Arrays.asList(coins)));

	}

}
