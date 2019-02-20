package com.algo.kk.twopointers;

import java.util.Arrays;

public class TotalTriangles {
public static int triangleCount(int[] a) {
	int ans = 0;
	int mod = 1000000007;
	Arrays.sort(a);
	
	for(int k=a.length-1;k>=2;k--){
		int i=0, j=k-1;
		while(i<j) {
			long miniSum = a[i] + a[j], maxi = a[k];
            if(miniSum > maxi){
                ans = (ans + (j - i)%mod)%mod;
                j--;
            }   
            else{
                i++;    
            }
		}
		
	}
	return ans;
}
	public static void main(String[] args) {
		int[] arr ={2,2,2};
		System.out.println(triangleCount(arr));
	}

}
