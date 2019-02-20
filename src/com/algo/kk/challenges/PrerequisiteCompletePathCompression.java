package com.algo.kk.challenges;

import java.util.ArrayList;

public class PrerequisiteCompletePathCompression {

    // Naive implementation of find 
    int find(int parent[], int i) 
    { 
        if (parent[i] == -1) 
            return i; 
        parent[i] = find(parent,parent[i]);
        return parent[i]; 
    } 
       
    // Naive implementation of union() 
    void Union(int parent[], int from, int to) 
    { 
        int fromEdge = find(parent, from); 
        int toEdge = find(parent, to); 
        parent[fromEdge] = toEdge; 
    } 
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int parents[] = new int[A];
        for(int i=0;i<A;i++){
            parents[i] = -1;
        }
        
        for(int i=0;i<B.size();i++){
            
            int parentOfDependent = find(parents, C.get(i)-1); 
            int parentOfDependency = find(parents, B.get(i)-1); 
      
            if (parentOfDependent == parentOfDependency) 
                return 0; 
      
            Union(parents, parentOfDependent, parentOfDependency); 
        }
        return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
