package com.algo.kk.strings;

public class MinimumInsertionAtBeginningPalindrome {

	boolean ispalindrome(String s,int j)
	{
	     
	    for(int i = 0; i <= j; i++, j--)
	    {
	        if(s.charAt(i) != s.charAt(j))
	            return false;
	    }
	    return true;
	}
	public int findMinInsertions(String str) {
		
		int cnt = 0;
	    int j = str.length()-1;
	    while(str.length()>0)
	    {
	        if(ispalindrome(str,j))
	        {
	             break;
	        }
	        else
	        {
	        cnt++;
	        j--;
	        }
	    }
	     
	    return cnt;  
	}
	public static void main(String[] args) {
		MinimumInsertionAtBeginningPalindrome m = new MinimumInsertionAtBeginningPalindrome();
		System.out.println(m.findMinInsertions("banana"));

	}

}
