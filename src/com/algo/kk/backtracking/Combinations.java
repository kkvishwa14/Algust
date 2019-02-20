package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combinations {

	public void solve(List<List<Integer>> ans, int indexToConsider, ArrayList<Integer> currList,int n, int k) {
		if(currList.size()==k){
			Collections.sort(currList);
			if(!ans.contains(currList))
				ans.add(currList);
			return;
		}
		if(indexToConsider == n){
			return;
		}
		solve(ans, indexToConsider+1, currList, n, k);
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.addAll(currList);
		newList.add(indexToConsider+1);
		solve(ans, indexToConsider+1, newList, n, k);
		
		
	}
	public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    solve(ans, 0, new ArrayList<Integer>(), n, k);
    /*Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
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
    });*/
    return ans;
	}
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));

	}

}
