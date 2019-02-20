package com.algo.kk.challenges;

import java.util.ArrayList;

public class PrerequisiteComplete {

	// Naive implementation of find 
	int find(int parent[], int i) 
	{ 
	    if (parent[i] == -1) 
	        return i; 
	    return find(parent, parent[i]); 
	} 
	   
	// Naive implementation of union() 
	void Union(int parent[], int x, int y) 
	{ 
	    int xset = find(parent, x); 
	    int yset = find(parent, y); 
	    parent[xset] = yset; 
	} 
	
	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int parents[] = new int[A];
		for(int i=0;i<A;i++){
			parents[i] = -1;
		}
		
		for(int i=0;i<B.size();i++){
			
			int x = find(parents, C.get(i)); 
	        int y = find(parents, B.get(i)); 
	  
	        if (x == y) 
	            return 0; 
	  
	        Union(parents, x, y); 
		}
		return 1;
	}
	public static void main(String[] args) {
		
		
	}

}
