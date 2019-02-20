package com.algo.kk.twopointers;

import java.util.ArrayList;

public class MissingWords {

	public static ArrayList<String> printMissing(String[] S, String[] T){
		ArrayList<String> ans = new ArrayList<String>();
		
		int sLen = S.length;
		int tLen = T.length;
		for(int i=0,j=0;i<sLen && j<tLen;){
			if(S[i].equals(T[j])){
				i++;
				j++;
			} else{
				ans.add(S[i]);
				i++;
				
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] S = {"I", "am","using","hackerrank","to","improve","programming"};
		String[] T = {"am","hackerrank","to","programming"};
		System.out.println(printMissing(S,T));
	}

}
