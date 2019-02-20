package com.algo.kk.hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.FREE_MEM;

public class Anagrams {

	public static String getFreqStr(String str){
		Map<String,Integer> wordsCount = new HashMap<String, Integer>();
		String str1 = "";
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(!wordsCount.containsKey(ch+"")){
				wordsCount.put(ch+"", 1);
			} else {
				wordsCount.put(ch+"", wordsCount.get(ch+"")+1);
			}
			
		}
		for(Map.Entry<String, Integer> entry : wordsCount.entrySet()){
			str1 +=entry.getKey()+entry.getValue();
		}
		return str1;
	}
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		Map<String,ArrayList<Integer>> lists = new HashMap<String, ArrayList<Integer>>();
		for(int i=1;i<=A.size();i++){
			String str = A.get(i-1);
			String hash = getFreqStr(str);
			if(lists.containsKey(hash)){
				ArrayList<Integer> list = lists.get(hash);
				list.add(i);
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				lists.put(hash, list);
			}
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(Map.Entry<String, ArrayList<Integer>> entry : lists.entrySet()){
			ans.add(entry.getValue());
		}
		return ans;
	}
	public static void main(String[] args) {
		/*String str = "hjkkdAKlm#(0*";
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("cat");
		strs.add("dog");
		strs.add("god");
		strs.add("tac");
		System.out.println(anagrams(strs));
		*/
		String[] input ={"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
				"abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
				"babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
				"bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
				"abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
				"aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
				"abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
				"aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};
		for(String s:input){
		System.out.println(getFreqStr(s));
		}
	}

}
