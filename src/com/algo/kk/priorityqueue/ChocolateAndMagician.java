package com.algo.kk.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChocolateAndMagician {

	public static int nchoc(int A, ArrayList<Integer> B) {
    
		
		int ans = 0, divi = 1000000007;
	    
		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<B.size();i++){
			q.add(B.get(i));
		}
	    while(A!=0){
	        int top = q.peek();
	        
	        ans = (ans + (top%divi))%divi;
	        
	        q.poll();
	        q.add(top/2);
	        
	        A--;
	    }
	    
	    return ans;
	}
	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(6);
		data.add(5);
		System.out.println(nchoc(3, data));

	}

}
