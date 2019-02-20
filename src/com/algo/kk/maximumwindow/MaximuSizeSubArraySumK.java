package com.algo.kk.maximumwindow;

import java.util.HashMap;

public class MaximuSizeSubArraySumK {

	public static int subarraySum(int[] nums, int k) {
        
        if(nums.length == 0)    return 0;
        
        //This map will store mapping of sums, the value will be index till where the sum occurred starting from 0
        HashMap<Integer, Integer> cumulativeSumIndexMap = new HashMap<>();
        int sumSoFar = 0, sumToExclude = 0, maxLenSoFar = 0, firstIndex = -1, maxLenStartIndex = -1, maxLenEndIndex =-1;
        for(int i = 0; i< nums.length; i++) {
            sumSoFar += nums[i];
            sumToExclude = sumSoFar - k;
            if (sumToExclude == 0){
            	if(i+1 >= maxLenSoFar){
            		maxLenSoFar = i+1;
            		maxLenStartIndex = 0;
            		maxLenEndIndex = i;
            	}
            }
            else if(cumulativeSumIndexMap.containsKey(sumToExclude)){ 
                firstIndex = cumulativeSumIndexMap.get(sumToExclude);
                if(i - firstIndex >= maxLenSoFar){
            		maxLenSoFar = i - firstIndex;
            		maxLenStartIndex = firstIndex + 1;
            		maxLenEndIndex = i;
            	}
            }
            
            //store only the first occurrence index of sum
            if(!cumulativeSumIndexMap.containsKey(sumSoFar)){
            	cumulativeSumIndexMap.put(sumSoFar,i);
            }
        }
        System.out.println("index start = "+ maxLenStartIndex+", index end = "+ maxLenEndIndex);
        return maxLenSoFar; 
    }
	public static void main(String[] args) {
		
		//int[] arr = {12,3,7,-1,2,-12};
		int[] arr = {8,1,3,3};
		System.out.println(subarraySum(arr, 9));
		int[] arr1 = {8,1,3,3,3};
		System.out.println(subarraySum(arr1, 9));
		int[] arr2 = {8,1,3,3,3,1,1,1,1,1,1,1,1,1};
		System.out.println(subarraySum(arr2, 9));
	}


}
