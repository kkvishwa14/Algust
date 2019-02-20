package com.algo.kk.stacks;

public class TrappingRainWater {

	public static int totalWater(int[] bars){
		int ans = 0, n= bars.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = bars[0];
		right[n-1] = bars[n-1];
		for(int i=1;i<n;i++){
			left[i] = Math.max(left[i-1], bars[i]);
			right[n-i-1] = Math.max(right[n-i], bars[n-i-1]);
		}
		for(int i=0;i<n;i++){
			ans+=Math.min(left[i], right[i])-bars[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		int bars[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(totalWater(bars));

	}

}
