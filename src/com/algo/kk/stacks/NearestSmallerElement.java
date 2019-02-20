package com.algo.kk.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	
	public static int[] nearestSmallest(int[] arr) {
		 Stack<Integer> S = new Stack<Integer>();
		 int[] ans = new int[arr.length];
		    // Traverse all array elements
		    for (int i=0; i<arr.length; i++)
		    {
		        while (!S.empty() && S.peek() >= arr[i])
		            S.pop();
		 
		        if (S.empty())
		            ans[i] = -1;
		        else  
		            ans[i] = S.peek();
		 
		        S.push(arr[i]);
		    }
		    return ans;
	}
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {3,6,1,5,4};
		printArr(nearestSmallest(arr));

	}

}
