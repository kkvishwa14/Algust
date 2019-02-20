package com.algo.kk.strings;

import java.io.CharConversionException;
import java.util.Stack;


public class MinimumInsertionToBalance {

	public static int minInsertions(String S) {
		
	        int ans = 0, bal = 0;
	        for (int i = 0; i < S.length(); ++i) {
	            bal += S.charAt(i) == '(' ? 1 : -1;
	            // It is guaranteed bal >= -1
	            if (bal == -1) {
	                ans++;
	                bal++;
	            }
	        }

	        return ans + bal;
	    
	}
	public static int minInsertions2(String S) {
		
        int ans = 0;
        int size = S.length();
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i < size; ++i) {
            if(S.charAt(i)=='('){
            	brackets.add('(');
            } else {
            	if(!brackets.isEmpty()){
            		brackets.pop();
            		
            	} else{
            		ans++;
            	}
            }
        }
        
        return ans +brackets.size();
    
}
	public static void main(String[] args) {
		System.out.println(minInsertions("))("));
		System.out.println(minInsertions("()"));
		System.out.println(minInsertions("())"));
		System.out.println(minInsertions2("))("));
		System.out.println(minInsertions2("()"));
		System.out.println(minInsertions2("())"));
	}

}
