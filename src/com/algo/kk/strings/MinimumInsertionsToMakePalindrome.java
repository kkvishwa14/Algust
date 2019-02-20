package com.algo.kk.strings;

import java.util.HashMap;
import java.util.Map;


public class MinimumInsertionsToMakePalindrome {

	Map<String,Integer> ans = new HashMap<String, Integer>();
	public int findMinInsertions(String str, int l,int h) {
		String key = ""+l+"-"+h;
		if(ans.containsKey(key)){
			return ans.get(key);
		}
		// Base Cases 
	    if (l > h) return Integer.MAX_VALUE; 
	    if (l == h) return 0; 
	    if (l == h - 1) return (str.charAt(l) == str.charAt(h))? 0 : 1; 
	   
	    int res = (str.charAt(l) == str.charAt(h))?  
                findMinInsertions(str, l + 1, h - 1): 
                (Math.min(findMinInsertions(str, l, h - 1), 
                findMinInsertions(str, l + 1, h)) + 1);
        ans.put(key,res);
	    return res; 
	}
	public static void main(String[] args) {
		MinimumInsertionsToMakePalindrome m = new MinimumInsertionsToMakePalindrome();
		System.out.println(m.findMinInsertions("abcb", 0, 3));
	}

}
