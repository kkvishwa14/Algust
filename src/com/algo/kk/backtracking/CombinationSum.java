package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class CombinationSum {

	public void solve(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> currentList, int sumRemaining, int indexToConsider, ArrayList<Integer> list){
		if(sumRemaining==0){
			ArrayList<Integer> newList1 = new ArrayList<Integer>();
			newList1.addAll(currentList);
            ans.add(newList1);
            return;
        }
        if(indexToConsider==list.size() || sumRemaining<0)
        return;
        solve(ans,currentList,sumRemaining,indexToConsider+1,list);	
        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.addAll(currentList);
        newList.add(list.get(indexToConsider));
        solve(ans,newList,sumRemaining-list.get(indexToConsider),indexToConsider,list);
        newList.remove(newList.size()-1);
        	
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(a);
		a.clear();
		a.addAll(set);
		Collections.sort(a);
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
		CombinationSum cs = new CombinationSum();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(3);nums.add(6);nums.add(7);
		ArrayList<ArrayList<Integer>> ans = cs.combinationSum(nums, 7);
		
		System.out.println(ans);

	}

}
