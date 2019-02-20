package com.algo.kk.dp;

public class RegularExpressionMatching2 {
	public static String removeContinuosStarWildcard(String pattern) {
		StringBuilder sb = new StringBuilder("");
		if (pattern == null ) {
			return null;
		}
        if(pattern.length()==0){
                return pattern;
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

	public boolean isMatch(String s, String p) {
		
		p = removeContinuosStarWildcard(p);
		if (p == null)
			return false;
		if (s == null)
			return false;
		int sSize = s.length();
		int pSize = p.length();
		if (pSize == 0)
			return (sSize == 0);
		boolean[][] dp = new boolean[sSize + 1][pSize + 1];
    
		dp[0][0] = true;
    
		for (int i = 2; i <= pSize; i++){
			if (p.charAt(i-1) == '*') { 
				dp[0][i] = dp[0][i-2];
			}
		}
    
		for (int i = 1; i <= sSize; i++){
        for (int j = 1; j <= pSize; j++){
            char pChar = p.charAt(j-1);
            char sChar = s.charAt(i-1);
            
            if (pChar != '*'){
                if (pChar == sChar || pChar == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = false;
                }
            }else{
                if (p.charAt(j-2) != sChar && p.charAt(j-2) != '.'){
                    dp[i][j] = dp[i][j-2];
                }else{
                    dp[i][j] = dp[i-1][j]|dp[i][j-2];
                }
            }
        }
    }
    
    
    return dp[sSize][pSize];
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching2 rem = new RegularExpressionMatching2();
		String s = "aa";
		String p = "a";		
		System.out.println(rem.isMatch(s,p));
		
		s = "aa";
		p = "a*";
		System.out.println(rem.isMatch(s,p));
		
		s = "aa";
		p = "a*";
		System.out.println(rem.isMatch(s,p));
		
		s = "ab";
		p = ".*";
		System.out.println(rem.isMatch(s,p));
		
		s = "aab";
		p = "c*a*b";
		System.out.println(rem.isMatch(s,p));
		
		s = "mississippi";
		p = "mis*is*p*.";
		System.out.println(rem.isMatch(s,p));
		
	}
}
