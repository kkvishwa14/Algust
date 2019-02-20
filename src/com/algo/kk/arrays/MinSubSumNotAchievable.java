package com.algo.kk.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinSubSumNotAchievable {

	public static long findMinSumNotAchievable(List<Integer> list) {
		Collections.sort(list);
		long sumSoFar = 0;
		
		for(int element : list){
			if(element-sumSoFar > 1 ){
				break;
			}
			sumSoFar+=element;
		}
		
		return sumSoFar + 1;
	}
	
	public static long findMinSumNotAchievable(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for(int a : arr){
			list.add(a);
		}
		return findMinSumNotAchievable(list);
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,6};
		System.out.println(findMinSumNotAchievable(a));

		int[] b = {1,2,3,7};
		System.out.println(findMinSumNotAchievable(b));
		
		int[] c = {1,2,3,8};
		System.out.println(findMinSumNotAchievable(c));
		
		int[] d = {1,2,5};
		System.out.println(findMinSumNotAchievable(d));
		
		int[] e = {1,2,3,2};
		System.out.println(findMinSumNotAchievable(e));
		
		int[] f = {9,8,3,1,1};
		System.out.println(findMinSumNotAchievable(f));
	}

}
