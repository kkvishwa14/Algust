package com.algo.kk.bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySorting {

	static int countBits(int a) 
	{ 
	    int count = 0; 
	    while (a > 0) 
	    { 
	        if ((a & 1) > 0) 
	            count+= 1; 
	        a = a >> 1; 
	    } 
	    return count; 
	} 
	  
	// Function to simultaneously  
	// sort both arrays using  
	// insertion sort  
	// (http://quiz.geeksforgeeks.org/insertion-sort/ ) 
	static void insertionSort(int arr[], 
	                          int aux[], int n) 
	{ 
	    for (int i = 1; i < n; i++) 
	    { 
	        // use 2 keys because we  
	        // need to sort both 
	        // arrays simultaneously 
	        int key1 = aux[i]; 
	        int key2 = arr[i]; 
	        int j = i - 1; 
	  
	        /* Move elements of arr[0..i-1]  
	        and aux[0..i-1], such that  
	        elements of aux[0..i-1] are 
	        greater than key1, to one  
	        position ahead of their current 
	        position */
	        while (j >= 0 && aux[j] < key1) 
	        { 
	            aux[j + 1] = aux[j]; 
	            arr[j + 1] = arr[j]; 
	            j = j - 1; 
	        } 
	        aux[j + 1] = key1; 
	        arr[j + 1] = key2; 
	    } 
	} 
	  
	// Function to sort according 
	// to bit count using an  
	// auxiliary array 
	static void sortBySetBitCount(int arr[], 
	                              int n) 
	{ 
	    // Create an array and  
	    // store count of 
	    // set bits in it. 
	    int aux[] = new int[n]; 
	    for (int i = 0; i < n; i++) 
	        aux[i] = countBits(arr[i]); 
	  
	    // Sort arr[] according  
	    // to values in aux[] 
	    insertionSort(arr, aux, n); 
	} 
	  
	// Utility function 
	// to print an array 
	static void printArr(int arr[], int n) 
	{ 
	    for (int i = 0; i < n; i++) 
	        System.out.print(arr[i] + " "); 
	} 
	  
	// Driver Code 
	public static void main (String[] args)  
	{ 
	     
	    List<Integer> arr1 = new ArrayList<Integer>();
	    arr1.add(8);
	    arr1.add(7);
	    arr1.add(6);
	    arr1.add(5);
	    
	    Collections.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bitsA = countBits(a);
                int bitsB = countBits(b);
                if(bitsA != bitsB){
                	return Integer.compare(bitsA, bitsB);
                }
                return Integer.compare(a, b);
            }
        });
	    System.out.println(arr1);
	} 

}
