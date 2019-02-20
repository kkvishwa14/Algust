package com.algo.kk.backtracking;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinSorting {

	
	private static int countBits(int a) 
	{ 
		
	    int count = 0; 
	    int NUM_1 = 1;
	    while (a > 0) 
	    { 
	        if ((a & NUM_1) > 0) 
	            count+= 1; 
	        a = a >> 1; 
	    } 
	    return count; 
	}
	
	public static List<Integer> rearrange(List<Integer> elements){
		 Collections.sort(elements, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer a, Integer b) {
	                int bitsA = countBits(a);
	                int bitsB = countBits(b);
	                if(bitsA != bitsB){
	                	return Integer.compare(bitsA, bitsB);
	                }
	                return Integer.compare(a, b);
	            }
	        });
		 return elements;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
