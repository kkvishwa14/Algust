package com.algo.kk.twopointers;

import java.util.ArrayList;

public class Merge2Lists {

	 public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

	        int aN = a.size();
	        int bN = b.size();        
	        int j = 0;
	        int i = 0;
	        while(i < a.size() && j < b.size()){
	            if(a.get(i) <= b.get(j)){
	                    i++;               
	            }
	            else if(a.get(i) > b.get(j)){
	                    a.add(i,b.get(j));
	                    i++;
	                    j++;                
	            }
	        }
	        
	        while(j < bN){
	            a.add(b.get(j++));
	        }
	        b.clear();
	    
	        for(int k =0; k < a.size(); k++)
	            System.out.print(a.get(k) + " ");
	    }
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(4);
		arr1.add(8);
		arr1.add(16);
		arr1.add(17);
		arr1.add(20);
		arr1.add(28);
		arr1.add(30);
		arr1.add(31);

		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(1);
		arr2.add(2);
		arr2.add(3);
		arr2.add(4);
		arr2.add(7);
		arr2.add(9);
		arr2.add(21);
		
		
		merge(arr1, arr2);
	}

}
