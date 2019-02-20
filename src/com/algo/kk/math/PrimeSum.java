package com.algo.kk.math;

import java.util.ArrayList;

public class PrimeSum {

	public boolean isPrime(int n) {
		if(n <2) {
			return false;
		}
		if(n == 2 || n == 3) {
			return true;
		}
		for(int i = 2; i<= (int)(Math.sqrt(n));i++) {
			if(n % i == 0){
				return false;
			}
		}
		
		return true;
	}
	public ArrayList<Integer> primesum(int A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=2;i<=A/2;i++) {
			if(isPrime(i) && isPrime(A-i)) {
				ans.add(i);
				ans.add(A-i);
				return ans;
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new PrimeSum().primesum(4));
		System.out.println(new PrimeSum().primesum(6));
		System.out.println(new PrimeSum().primesum(12));

	}

}
