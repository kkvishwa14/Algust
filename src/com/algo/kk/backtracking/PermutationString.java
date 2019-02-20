package com.algo.kk.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

	public void helper(String str, String currStr, List<String> res){
		if(str.length() == currStr.length()){
			res.add(currStr);
			return;
		}
		
		for(int i = 0; i<str.length();i++){
			if(currStr.indexOf(str.charAt(i)) != -1){
				continue;
			}
			currStr = currStr+str.charAt(i);
			helper(str,currStr,res);
			currStr = currStr.substring(0,currStr.length()-1);
		}
	}
	public List<String> permute(String str) {
		List<String> ans = new ArrayList<String>();
		if(str == null || str.length() == 0 || str.equals("")){
			return ans;
		}
		helper(str,"",ans);
		return ans;
	}
	
	
	public static void main(String[] args) {
		String str = "ABC";
		PermutationString pl = new PermutationString();
		System.out.println(pl.permute(str));
		//System.out.println(str.substring(0,str.length()-1));
	}

}
