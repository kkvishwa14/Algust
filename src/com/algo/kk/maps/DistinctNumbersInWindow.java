package com.algo.kk.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersInWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		ArrayList<Integer> windowIndexValues = new ArrayList<Integer>();
		Map<Integer, List<Integer>> valueIndexMap = new HashMap<Integer, List<Integer>>();
		
		for(int i =0;i<B;i++) {
			int val = A.get(i);
			windowIndexValues.add(val);
			List<Integer> positions = valueIndexMap.get(val);
			if(positions == null){
				positions = new ArrayList<Integer>();
			}
			positions.add(i);
			valueIndexMap.put(val, positions);
		}
		ans.add(valueIndexMap.size());
		
		for(int i=B;i<A.size();i++) {
			int toRemove = windowIndexValues.remove(0);
			List<Integer> positionList = valueIndexMap.get(toRemove);
			positionList.remove(0);
			if(positionList.size()==0){
				valueIndexMap.remove(toRemove);
			}
			
			int val = A.get(i);
			windowIndexValues.add(val);
			List<Integer> positions = valueIndexMap.get(val);
			if(positions == null){
				positions = new ArrayList<Integer>();
			}
			positions.add(i);
			valueIndexMap.put(val, positions);
			ans.add(valueIndexMap.size());
		}
		
		return ans;
	}
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(1);
		A.add(3);
		A.add(2);
		A.add(2);
		A.add(5);
		A.add(1);
		DistinctNumbersInWindow dniw = new DistinctNumbersInWindow();
		System.out.println(dniw.dNums(A,3));
	}

}
