package com.algo.kk.twopointers;

public class MaxDifference {

	public static int maxDifference(int[] arr) {
		if(arr.length <2){
			return -1;
		}
		if(arr.length == 2){
			if(arr[1] >= arr[0]){
				return arr[1] - arr[0];
			}else{
				return -1;
			}
		}
		int maxDiff = arr[1] - arr[0];
		int minYet =  arr[0];
		  int diff;
		  for(int i = 1; i < arr.length; i++)
		  {       
			  diff = arr[i] - minYet;
		    if (diff > maxDiff)                               
		      maxDiff = diff;
		    if (arr[i] < minYet)
		      minYet = arr[i];                     
		  }
		  if(maxDiff < 0){
			  return -1;
		  }
		  return maxDiff;
	}
	public static void main(String[] args) {
		int[] arr = {2,3,10,2,4,8,1};
        System.out.println(maxDifference(arr));
        
        int[] arr2 = {7,9,5,6,3,2};
        System.out.println(maxDifference(arr2));
        
	}

}
