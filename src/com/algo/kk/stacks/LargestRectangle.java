package com.algo.kk.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangle {
	public int largestRectangleArea2(ArrayList<Integer> A) {
        Stack<Integer> indicesInc = new Stack<Integer>();
        int maxArea = 0;
        int i =0;
        for (;i<A.size();i++) {
            if(!(indicesInc.isEmpty() || A.get(indicesInc.peek())<=A.get(i))){
                while(!indicesInc.isEmpty() && A.get(indicesInc.peek()) > A.get(i)) {
                    int stkTop = indicesInc.pop();
                    int currHeightArea = A.get(stkTop)*(i-stkTop);
                    if(currHeightArea >= maxArea){
                        maxArea = currHeightArea;
                    }
                }
            }
            
            indicesInc.push(i);
            
            
        }
        
        while(!indicesInc.isEmpty()) {
                int stkTop = indicesInc.pop();
                int currHeightArea = A.get(stkTop)*(i-stkTop);
                if(currHeightArea >= maxArea){
                    maxArea = currHeightArea;
                }
        }
        
        return maxArea;
    }
	public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> indicesInc = new Stack<Integer>();
        int maxArea = 0;
        int i =0;
        for (;i<A.size();i++) {
            if(indicesInc.isEmpty() || A.get(indicesInc.peek())<=A.get(i)){
                indicesInc.push(i);
            } else {
                while(!indicesInc.isEmpty() && A.get(indicesInc.peek()) > A.get(i)) {
                    int stkTop = indicesInc.peek();
                indicesInc.pop();
                int currHeightArea = A.get(stkTop)*(indicesInc.isEmpty() ? i :  
                                   i - indicesInc.peek() -1);
                    if(currHeightArea >= maxArea){
                        maxArea = currHeightArea;
                    }
                }
            }
            indicesInc.push(i);
            
            
        }
        
        while(!indicesInc.isEmpty()) {
                int stkTop = indicesInc.peek();
                indicesInc.pop();
                int currHeightArea = A.get(stkTop)*(indicesInc.isEmpty() ? i :  
                                   i - indicesInc.peek() -1);
                if(currHeightArea >= maxArea){
                    maxArea = currHeightArea;
                }
        }
        
        return maxArea;
    }
	
	public static void main(String[] args) {
		LargestRectangle lr = new LargestRectangle();
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ar1.add(6);
		ar1.add(2);
		ar1.add(2);
		ar1.add(2);
		ar1.add(2);
		ar1.add(5);
		ar1.add(4);
		ar1.add(5);
		ar1.add(1);
		ar1.add(6);
		System.out.println(lr.largestRectangleArea(ar1));
	}

}
