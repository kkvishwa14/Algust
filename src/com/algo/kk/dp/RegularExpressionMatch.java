package com.algo.kk.dp;

import java.util.Arrays;

public class RegularExpressionMatch {

	public static String removeContinuosStarWildcard(String pattern) {
		StringBuilder sb = new StringBuilder("");
		if (pattern == null || pattern.trim().length() == 0) {
			return null;
		}
		sb.append(pattern.charAt(0));
		char lastChar = pattern.charAt(0);
		int len = pattern.length();
		for (int patternInd = 1; patternInd < len; patternInd++) {
			char currChar = pattern.charAt(patternInd);
			if (currChar == lastChar && lastChar == '*') {
				continue;
			} else {
				sb.append(currChar);
				lastChar = currChar;
			}
		}
		return sb.toString();
	}

	static boolean strmatch(String str, String pattern) {
		if (pattern == null)
			return false;
		pattern = removeContinuosStarWildcard(pattern);
		if (str == null)
			return false;
		int stringSize = str.length();
		int patternSize = pattern.length();
		if (patternSize == 0)
			return (stringSize == 0);

		boolean[][] lookup = new boolean[stringSize + 1][patternSize + 1];

		for (int i = 0; i < stringSize + 1; i++)
			Arrays.fill(lookup[i], false);

		lookup[0][0] = true;

		for (int j = 1; j <= patternSize; j++)
			if (pattern.charAt(j - 1) == '*')
				lookup[0][j] = lookup[0][j - 1];

		for (int i = 1; i <= stringSize; i++) {
			for (int j = 1; j <= patternSize; j++) {
				char currPatternChar = pattern.charAt(j-1);
				char currStringChar = pattern.charAt(j-1);
				if (currPatternChar == '*')
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

				else if (currPatternChar == '?'
						|| currStringChar == currPatternChar)
					lookup[i][j] = lookup[i - 1][j - 1];

				else
					lookup[i][j] = false;
			}
		}

		return lookup[stringSize][patternSize];
	}

	public static void main(String args[]) {

		System.out.println(removeContinuosStarWildcard("**AB"));
		System.out.println(removeContinuosStarWildcard("**AB**"));
		System.out.println(removeContinuosStarWildcard("**AB*"));
		System.out.println(removeContinuosStarWildcard("*AB*C*"));

		String str = "baaabab";
		String pattern = "*****ba*****ab";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// String pattern = "ba*****ab";
		// String pattern = "ba*ab";
		// String pattern = "a*ab";
		// String pattern = "a*****ab";
		// String pattern = "*a*****ab";
		// String pattern = "ba*ab****";
		// String pattern = "****";
		// String pattern = "*";
		// String pattern = "aa?ab";
		// String pattern = "b*b";
		// String pattern = "a*a";
		// String pattern = "baaabab";
		// String pattern = "?baaabab";
		// String pattern = "*baaaba*";

		if (strmatch(str, pattern))
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
