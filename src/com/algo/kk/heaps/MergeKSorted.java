package com.algo.kk.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.algo.kk.linkedlist.ListNode;

class ListNodeComparator implements Comparator<ListNode>{ 
    
    
    public int compare(ListNode l1, ListNode l2) { 
        if (l1.val < l2.val) 
            return -1; 
        else if (l1.val > l2.val) 
            return 1; 
        return 0; 
        } 
} 
public class MergeKSorted {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        Queue<ListNode> q = new PriorityQueue<ListNode>(new ListNodeComparator());
        ListNode newList = new ListNode(0);
        for(int i=0;i<a.size();i++){
            ListNode firstNode = a.get(i);
            if(firstNode != null)
                q.add(firstNode);
        }
        ListNode newNode = newList;
        while(!q.isEmpty()){
            ListNode poppedNode = q.remove();
            newNode.next = poppedNode;
            newNode = poppedNode;
            if(poppedNode.next != null){
                q.add(poppedNode.next);
            }
        }
        return newList.next;
    }
}
