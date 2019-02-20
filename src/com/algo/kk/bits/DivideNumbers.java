package com.algo.kk.bits;

public class DivideNumbers {

    public static int divide(int A, int B) {
        if(B==0){
            return Integer.MAX_VALUE;
        }
        if(A==Integer.MIN_VALUE && B == -1){
            return Integer.MAX_VALUE;
        }
        if(B == 1){
            return A;
        }
        int k=31;
        boolean sign = false;
        
        if((A<0&&B>0)||(A>0&& B<0)){
            sign = true;
        }
        long long_A = Math.abs(A);
        long long_B = Math.abs(B);
        long power_k = long_B << k;
        long result = 0L;
        while(long_A>=long_B) {
            while(power_k > long_A){
                power_k >>= 1;
                k--;
            }
            result += 1 << k;
            long_A -= power_k;
        }
        
        
        if(sign)
            return -(int)result;
        return (int)result;
    }

	public static void main(String[] args) {
		
		System.out.println(divide(1234, -100));
	}

}
