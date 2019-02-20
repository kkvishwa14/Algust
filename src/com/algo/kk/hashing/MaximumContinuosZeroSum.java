package com.algo.kk.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumContinuosZeroSum {

	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
	       
        HashMap<Integer, Integer> sumAndIndex = new HashMap<Integer, Integer>(); 
  
        int sum = 0;      // Initialize sum of elements 
        int max_len = 0;  // Initialize result 
  
        // Traverse through the given array
        sumAndIndex.put(0,-1);
        int indexStart = 0, indexEnd = 0;
        boolean found = false;
        for (int i = 0; i < A.size(); i++) 
        { 
            sum += A.get(i); 
            if (sum == 0) {
               // max_len = i+1;
                found = true;
            }
            // Look this sum in hash table 
            Integer prev_i = sumAndIndex.get(sum); 
  
            // If this sum is seen before, then update max_len 
            // if required 
            if (prev_i != null) {
                found = true;
               if(max_len < (i-prev_i)){
                    max_len = Math.max(max_len, i-prev_i);
                    indexStart = prev_i + 1;
                    indexEnd = i ;
               }
            }
            else  // Else put this sum in hash table 
               sumAndIndex.put(sum, i); 
        } 
        ArrayList<Integer> ans= new ArrayList<Integer>();
        if(found) {
            for(int i=indexStart;i<=indexEnd;i++){
                ans.add(A.get(i));
            }
        }
        return ans; 
    }
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(-3);
		a.add(3);
		System.out.println(lszero(a));
	}

}
