package com.algo.kk.dp;

public class DecodeWays {

	
    public int numDecodings(String s) {
        if(s== null || s.trim().length()<1){
            return 0;
        }
        int count[] = new int[s.length()+1];
        
        count[0] = 1;
        count[1] = 1;
        if(s.charAt(0) == '0'){
            count[1] = 0;
        }
        int n = s.length();
        for(int i= 1; i<n; i++){
            count[i + 1] = 0;
            char digit = s.charAt(i);
            if(digit > '0'){
                count[i+1] = count[i];
            }
            
            if (s.charAt(i-1) == '1'
					|| (s.charAt(i - 1) == '2' && digit < '7'))
				count[i+1] += count[i - 1];
        }
        
        return count[n];
    }
	static int countDecodingDP(char digits[], int n) {
		// A table to store results of subproblems
		int count[] = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			// If the last digit is not 0,
			// then last digit must add to
			// the number of words
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			// If second last digit is smaller
			// than 2 and last digit is smaller
			// than 7, then last two digits
			// form a valid character
			if (digits[i - 2] == '1'
					|| (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

	public static void main(String[] args) {
		// 1 2 3 4
		// 12 3 4
		// 1 23 4
		
		char digits[] = { '1', '2', '3', '4' };
		int n = digits.length;
		System.out.println("Count is " + countDecodingDP(digits, n));
	}
}
