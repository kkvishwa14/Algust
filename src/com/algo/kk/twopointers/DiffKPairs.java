package com.algo.kk.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffKPairs {

	
	public static int diffk(int[] arr, int k){
		Arrays.sort(arr);
		int l = 0, r = 1; 
		int n = arr.length, count =0; 
		while(r < n) 
		{ 
			if(arr[r] - arr[l] == k) 
			{ 
				l++; 
				r++; 
				count++;
			} 
			else if(arr[r] - arr[l] > k) 
				l++; 
			else  
				r++; 
		} 
		return count;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(diffk(a, 2));

	}

}
