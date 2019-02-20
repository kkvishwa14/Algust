package com.algo.kk.binary;

public class CountOccurrences {

	//finds the first occurrence index of the key 
	static int lowerBound(int a[], int key) {
		int s = 0, e = a.length - 1 , m = 0;
		while(s <= e) {
			m = (s+e) / 2;
			if( a[m] == key && (m==0 || a[m-1] != key) ){
				return m;
			} else if( a[m] < key) {
				s = m+1;
			} else {
				//as our motive is to find the first occurrence, we will have to keep shifting our end index, so keep it in else case.
				e = m-1;
			}
		}
		return -1;
	}
	
	//finds the last occurrence index of the key
	static int higherBound(int a[], int key) {
		int s = 0, e = a.length - 1 , m = 0;
		while(s <= e) {
			m = (s+e) / 2;
			if( a[m] == key && ( m== (a.length -1) || a[m+1] != key) ){
				return m;
			} else if( a[m] > key) {
				e = m - 1;
			} else {
				//as our motive is to find the last occurrence, we will have to keep shifting our start index, so keep it in else case.
			    s = m + 1;
			}
		}
		return -1;
	}
	
	static int countOccurrences(int a[],int key) {
		int l_b = lowerBound(a, key);
		if(l_b != -1) {
			int h_b = higherBound(a, key);
			return h_b - l_b +1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 3, 3, 3};
		System.out.println(" LB of 2-> "+lowerBound(arr, 2));
		System.out.println(" UB of 2-> "+higherBound(arr, 2));
		System.out.println("Total 2's -> "+ countOccurrences(arr, 2));
		
		System.out.println(" LB of 1-> "+lowerBound(arr, 1));
		System.out.println(" UB of 1-> "+higherBound(arr, 1));
		System.out.println("Total 1's -> "+ countOccurrences(arr, 1));

		System.out.println(" LB of 3-> "+lowerBound(arr, 3));
		System.out.println(" UB of 3-> "+higherBound(arr, 3));
		System.out.println("Total 3's -> "+ countOccurrences(arr, 3));

		System.out.println(" LB of 4-> "+lowerBound(arr, 4));
		System.out.println(" UB of 4-> "+higherBound(arr, 4));
		System.out.println("Total 4's -> "+ countOccurrences(arr, 4));
	}

}
