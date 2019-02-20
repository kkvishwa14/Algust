package com.algo.kk.binary;

public class Sqrt {

	public static int sqrt(int a) {
        int s = 1, e = a, mid = 0;
        int ans = mid;
     
        if( a == 0 || a == 1 )
            return a;
        
        while(s <= e) {
            mid = (s + e)/2;
            
            if(mid  == a/mid) {
                if( a% mid != 0) {
                    s = mid +1;
                    ans = mid;   
                } else {
                    return mid;
                }
            } 
            
            if(mid  < a / mid) {
                s = mid + 1;
                ans = mid; 
            }
            
            else {
                e = mid - 1;
            }
            
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		
			System.out.println(sqrt(5));
	}

}
