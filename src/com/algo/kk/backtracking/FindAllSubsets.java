package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindAllSubsets {

	public void enumerate(int[] array, ArrayList<Integer> currentSubset,  int indexToDecide, ArrayList<ArrayList<Integer>> ans) {
		if(indexToDecide >=array.length){
			Collections.sort(currentSubset);
			ans.add(currentSubset);
			return;
		}
		
		enumerate(array, currentSubset, indexToDecide + 1, ans);
		ArrayList<Integer> newSet = new ArrayList<Integer>();
		newSet.addAll(currentSubset);
		newSet.add(array[indexToDecide]);
		enumerate(array, newSet, indexToDecide + 1, ans);
		
	}
	public static void main(String[] args) {
		int[] array  = {1,2};
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		FindAllSubsets fs = new FindAllSubsets();
		
		fs.enumerate(array,start,0,ans);
		
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
		System.out.println(ans);
	}

}
