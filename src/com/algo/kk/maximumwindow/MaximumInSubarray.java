package com.algo.kk.maximumwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumInSubarray {

	public static int[] maxValues(int arr[], int window) {List<Integer> deque = new ArrayList<Integer>();
    int[] ans = new int[arr.length-window+1];
    int k=0;
    for(int i=0;i<window;i++) {
            if(!deque.isEmpty()) {
                int valLastIndex = deque.get(deque.size()-1);
                while(!deque.isEmpty()  && arr[i] >= arr[valLastIndex]) {
                    deque.remove(deque.size()-1);
                    if(!deque.isEmpty())
                        valLastIndex = deque.get(deque.size()-1);
                }
            }
            deque.add(i);
            
    }
    ans[k++]=arr[deque.get(0)];
    for(int i=window ; i<arr.length;i++) {
        if(!deque.isEmpty()) {
            int valLastIndex = deque.get(deque.size()-1);
            while(!deque.isEmpty()  && arr[i]>= arr[valLastIndex]) {
                deque.remove(deque.size()-1);
                if(!deque.isEmpty())
                    valLastIndex = deque.get(deque.size()-1);
            }
        }
        deque.add(i);
        if(deque.get(0)<=i-window){
            deque.remove(0);
        }
        ans[k++]=(arr[deque.get(0)]);
    }
    return ans;
    }
	public static void main(String[] args) {
		int arr[] = {10,9,8,7,6,5,4,3,2};
		System.out.println(maxValues(arr, 2));

	}

}
