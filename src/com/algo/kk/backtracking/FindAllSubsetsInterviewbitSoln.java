package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class FindAllSubsetsInterviewbitSoln {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add(new ArrayList<Integer>());
		if (a.size() == 0)
			return output;
		Collections.sort(a);
		generate(a, output, new ArrayList<Integer>(), 0);
		return output;
	}
	
	public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
	{
		for (int i = index; i < a.size(); i++)
		{
			temp.add(a.get(i));
			output.add(new ArrayList<Integer>(temp));
			generate(a, output, temp, i+1);
			temp.remove(temp.size() - 1);
		}
	}
	

	public static void main(String[] args) {
		FindAllSubsetsInterviewbitSoln s = new FindAllSubsetsInterviewbitSoln();
		ArrayList<Integer> inp = new ArrayList<Integer>();
		inp.add(1);
		inp.add(2);
		System.out.println(s.subsets(inp));
	}
}
