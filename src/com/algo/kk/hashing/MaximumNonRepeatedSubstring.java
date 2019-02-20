package com.algo.kk.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaximumNonRepeatedSubstring {

	public static String getMaxNonRepeatedSubstring(String str) {
		Map<String,Integer> lastIndexes = new HashMap<String, Integer>();
		int max_start = -1;
		int max_end = -1;
		int curr_start = 0;
		int max_length = 0;
		int curr_length = 0;
		int i=0;
		Set<String> removeChars = new HashSet<String>();
		for(i=0;i<str.length();i++) {
			String curr_char= str.charAt(i)+"";
			if(!lastIndexes.containsKey(curr_char)) {
				lastIndexes.put(curr_char, i);
			} else {
				curr_length = i - curr_start;
				if(curr_length > max_length) {
					max_length = curr_length;
					max_start = curr_start;
					max_end = i-1;
				}

				curr_start = lastIndexes.get(curr_char)+1;
				lastIndexes.put(curr_char,i);
				for(Entry<String, Integer> entry : lastIndexes.entrySet()) {
					if(entry.getValue() < curr_start){
						removeChars.add(entry.getKey());
					}
				}
				for(String char_to_remove : removeChars){
					lastIndexes.remove(char_to_remove);
				}
				removeChars.clear();
			}
		}
		curr_length = i - curr_start;
		if(curr_length > max_length) {
			max_length = curr_length;
			max_start = curr_start;
			max_end = i-1;
		}
		return str.substring(max_start, max_end+1);
	}
	public static void main(String[] args) {
		
		System.out.println(getMaxNonRepeatedSubstring("abcde"));
		System.out.println(getMaxNonRepeatedSubstring("abdcde"));
		System.out.println(getMaxNonRepeatedSubstring("geksfor"));
	}

}
