package com.algo.kk.strings;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

	static String getStringForFreq(int[] freq){
		String str = "";
		for(int i=0;i<26;i++){
			if(freq[i] != 0){
				str += (char)('a'+i)+":"+freq[i];
			}
		}
		return str;
	}
	static void fillFrequencyMapofEachAnagramString(String s, Map<String,Integer> map){
		s = s.toLowerCase();
		int size = s.length();
		for(int start = 0; start < size; start++ ){
			int frequencies[] = new int[26];//initialize frequency for new substrings from this char onward.
			for(int end=start; end < size; end++){
				frequencies[s.charAt(end)-'a']++; //increment the frequency of this char index.
				String frequencyString = getStringForFreq(frequencies);
				if(map.containsKey(frequencyString)){
					map.put(frequencyString, map.get(frequencyString)+1);
				} else {
					map.put(frequencyString, 1);
				}
			}
		}
	}
	static int sherlockAndAnagrams(String s) {
		Map<String,Integer> substringAnagramCount = new HashMap<String, Integer>();
		fillFrequencyMapofEachAnagramString(s, substringAnagramCount);
		Long sum = 0L;
		for(Map.Entry<String, Integer> entry : substringAnagramCount.entrySet()){
			Integer count = entry.getValue();
			if(count > 1){
				sum += (count*(count-1))/2;
			}
		}
		return sum.intValue();
    }
	public static void main(String[] args) {
		
		System.out.println(sherlockAndAnagrams("abca"));
	}

}
