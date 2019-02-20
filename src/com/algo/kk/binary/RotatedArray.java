package com.algo.kk.binary;

public class RotatedArray {

	
	static int findPivot(int []a, int s, int e) {
		
		if(s > e){
			return -1;
		}
		
		int m = (s+e)/2;
		 
		if( m < e && a[m]  > a[m+1])
			return m + 1;
		
		if(m > s && a[m] < a[m-1])
			return m;
		
		if(a[s] > a[m]) 
			return findPivot(a, s, m -1);
		
		return findPivot(a, m +1, e);
	}
	static int minVal(int a[]) {
		int pivot = findPivot(a,0, a.length -1);
		
		if(pivot != -1){
			System.out.println("index : ->" + pivot);
			return a[pivot];
		}
		System.out.println("index : -> 0");
		return a[0];
	}
	public static void main(String[] args) {
		
		int a[] = {3,5,6,7,0,1,2};
		System.out.println("min val : ->"+minVal(a));
		int b[] = {0,1,2,3,4,5};
		System.out.println("min val : ->"+minVal(b));
		int c[] = {3,5,6,7,8,2};
		System.out.println("min val : ->"+minVal(c));
	}

}
