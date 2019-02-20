package com.algo.kk.maps;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

	public static String fractionToDecimal(int A, int B) {
		 // If the numerator is zero, answer is 0 
	    if (A == 0) 
	        return "0"; 
	  
	    // If any one (out of numerator and denominator) 
	    // is -ve, sign of resultant answer -ve. 
	    int sign = (A < 0) ^ (B < 0) ? -1 : 1; 
	    long aNew = A;
	    long bNew = B;
	    aNew = Math.abs(aNew); 
	    bNew = Math.abs(bNew); 
	  
	    // Calculate the absolute part (before decimal point). 
	    long initial = aNew / bNew; 
	  
	    // Output string to store the answer 
	    String res=""; 
	  
	    // Append sign 
	    if (sign == -1) 
	        res += "-"; 
	  
	    // Append the initial part 
	    res += initial; 
	  
	    // If completely divisible, return answer. 
	    if (aNew % bNew == 0) 
	        return res; 
	  
	    res += "."; 
	  
	    // Initialize Remainder 
	    long rem = aNew % bNew;  
	    Map<Long, Integer> mp = new HashMap<Long, Integer>(); 
	  
	    // Position at which fraction starts repeating 
	    // if it exists 
	    int index = 0; 
	    boolean repeating = false; 
	    while (rem > 0 && !repeating) { 
	  
	        // If this remainder is already seen, 
	        // then there exists a repeating fraction. 
	        if (mp.containsKey(rem)) { 
	  
	            // Index to insert parantheses 
	            index = mp.get(rem); 
	            repeating = true; 
	            break; 
	        } 
	        else
	            mp.put(rem,res.length()); 
	  
	        rem = rem * 10; 
	  
	        // Calculate quotient, append it to result and 
	        // calculate next remainder 
	        long temp = rem / bNew; 
	        res += temp; 
	        rem = rem % B; 
	    } 
	  
	    // If repeating fraction exists, insert parantheses. 
	    if (repeating) { 
	        String ans = res.substring(0,index)+"("+res.substring(index)+")";
	        res = ans;
	    } 
	  
	    // Return result. 
	    return res; 
    }
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648, -1));

	}

}
