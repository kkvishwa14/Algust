package com.algo.kk.backtracking;

import java.util.ArrayList;

public class GenerateParenthesis {

	public void generate(ArrayList<String> resultList, String generateParentheseisYet, int openUsed, int closeUsed, int bracesToBeUsed ) {
		if(openUsed == bracesToBeUsed && closeUsed == bracesToBeUsed){
			resultList.add(generateParentheseisYet);
		}
		if(openUsed > bracesToBeUsed || closeUsed > bracesToBeUsed){
			return;
		}
		if(openUsed < bracesToBeUsed)
			generate(resultList, generateParentheseisYet +"(", openUsed+1, closeUsed, bracesToBeUsed);
		if(closeUsed < openUsed)
			generate(resultList, generateParentheseisYet +")", openUsed, closeUsed+1, bracesToBeUsed);
		
	}
	public ArrayList<String> generateParentheses(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		generate(ans, "", 0, 0, n);
		return ans;
	}
	public static void main(String[] args) {
	
	System.out.println(new GenerateParenthesis().generateParentheses(4));

	}

}
