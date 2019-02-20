package com.algo.kk.backtracking;

import java.util.ArrayList;

public class LetterPhone {
	String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno",
	        "pqrs", "tuv", "wxyz"};
	public void generate(String digitsTyped, String currentStringGenerated, int indexToFill, ArrayList<String> resultList) {
		if(indexToFill >= digitsTyped.length()){
			resultList.add(currentStringGenerated);
			return;
		}
		int key = digitsTyped.charAt(indexToFill) - '0';
		String keyMap = map[key];
		for(int i =0; i<keyMap.length(); i++){
			generate(digitsTyped, currentStringGenerated + keyMap.charAt(i), indexToFill +1, resultList);
		}
	}
	public static void main(String[] args) {
		ArrayList<String> ans = new ArrayList<String>();
		LetterPhone lp = new LetterPhone();
		lp.generate("234","",0, ans);
		System.out.println(ans);
	}

}
