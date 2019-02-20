package com.algo.kk.twopointers;

public class Closest {

	public static void main(String[] args) {
		int f[] ={3,5,7,10};
		int b[] ={2,3,4,5};
		int res_l=0, res_r=0;  // To store indexes of result pair
		int capacity = 10;
	    int l = 0, r = b.length-1, diff = 1000000;
	    boolean found = false;
	    // While there are elements between l and r
	    while (l<f.length && r >0)
	    {
	    	if(f[l] + b[r] == capacity) {
	    		found = true;
	    		
	    		System.out.println(f[l]+" + "+b[r]+ " -> "+l+" ,"+r);
	    		l++;
	    		r--;
	    	}
	       // Check if this pair is closer than the closest pair so far
	       if (Math.abs(f[l] + b[r] - capacity) < diff)
	       {
	           res_l = l;
	           res_r = r;
	           diff = Math.abs(f[l] + b[r] - capacity);
	       }
	 
	       // If this pair has more sum, move to smaller values.
	       if (f[l] + b[r] > capacity)
	           r--;
	       else // Move to larger values
	           l++;
	    }
	    if(!found)
	    	System.out.println("closest value : "+" "+f[res_l]+" + "+b[res_r]+"->"+res_l+","+res_l);
	}

}
