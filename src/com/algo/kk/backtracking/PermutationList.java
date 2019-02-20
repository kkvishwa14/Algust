package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationList {

	
	public void helper(int nums[], List<Integer> currList, List<List<Integer>> res){
		if(nums.length == currList.size()){
			res.add(new ArrayList<Integer>(currList));
			return;
		}
		
		for(int i = 0; i<nums.length;i++){
			if(currList.contains(nums[i])){
				continue;
			}
			currList.add(nums[i]);
			helper(nums,currList,res);
			currList.remove(currList.size()-1);
		}
	}
	public List<List<Integer>> permute(int nums[]) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return ans;
		}
		helper(nums,new ArrayList<Integer>(),ans);
		return ans;
	}
	
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		PermutationList pl = new PermutationList();
		System.out.println(pl.permute(nums));
	}

}
