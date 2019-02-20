package com.algo.kk.math;

import java.util.ArrayList;

public class Max3Product {

	public static int maxProduct(ArrayList<Integer> A) {
		int n = A.size();
	    if (n < 3) 
	        return -1; 
	   
	    int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE; 
	  
	    int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE; 
	  
	    for (int i = 0; i < n; i++) 
	    { 
	    	int currVal = A.get(i);
	        if (currVal > maxA) 
	        { 
	            maxC = maxB; 
	            maxB = maxA; 
	            maxA = currVal; 
	        } 
	        else if (currVal > maxB) 
	        { 
	            maxC = maxB; 
	            maxB = currVal; 
	        } 
	        else if (currVal > maxC) {
	            maxC = currVal; 
	        }
	  
	        if (currVal < minA) 
	        { 
	            minB = minA; 
	            minA = currVal; 
	        } 
	        else if(currVal < minB) { 
	            minB = currVal; 
	        }
	    } 
	  
	    return Math.max(minA * minB * maxA, 
	               maxA * maxB * maxC);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
