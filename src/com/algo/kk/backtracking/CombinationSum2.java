package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CombinationSum2 {

	public void solve(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> currentList, int sumRemaining, int indexToConsider, ArrayList<Integer> list){
		if(sumRemaining == 0){
			Collections.sort(currentList);
			if(!ans.contains(currentList)){
				ans.add(currentList);
			}
			return;
		}
		if(indexToConsider== list.size()){
			return;
		}
		solve(ans,currentList,sumRemaining,indexToConsider+1,list);
		
		if(list.get(indexToConsider)<=sumRemaining){
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(currentList);
			newSet.add(list.get(indexToConsider));
			solve(ans,newSet,sumRemaining-list.get(indexToConsider),indexToConsider+1,list);
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		solve(ans, new ArrayList<Integer>(),b,0,a);
		
		Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
		return ans;
	}
	public static void main(String[] args) {
		CombinationSum2 cs = new CombinationSum2();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(1);nums.add(2);nums.add(7);nums.add(6);nums.add(1);nums.add(5);
		ArrayList<ArrayList<Integer>> ans = cs.combinationSum(nums, 8);
		
		System.out.println(ans);

	}

}
