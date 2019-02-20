package com.algo.kk.arrays;

import java.util.ArrayList;

public class MinimumSubarraySum {

	
    public static int solve(ArrayList<Integer> A, int B) {
    int currSum = 0;
    int n = A.size(),minLen = n;
    // Initialize starting and ending indexes 
    boolean sumFound = false;
    int start = 0, end = 0; 
    while (end < n) 
    { 
        // Keep adding array elements while current sum 
        // is smaller than x 
        while (currSum < B && end < n) { 
            currSum += A.get(end++);
            
        }
  
        // If current sum becomes greater than x. 
        if(currSum>=B){
            sumFound = true;
        }
        while (currSum >= B && start < n) 
        { 
            // Update minimum length if needed 
            if (end - start < minLen) 
                minLen = end - start; 
  
            // remove starting elements 
            currSum -= A.get(start++); 
        } 
    } 
    if(!sumFound){
        return -1;
    }
    return minLen; 
    }
	public static void main(String[] args) {
		
		
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);

		a.add(1);
		a.add(3);
		System.out.println(solve(a, 4));
		
		//complete solution : https://leetcode.com/articles/shortest-subarray-with-sum-atleast-k/
	}

}
