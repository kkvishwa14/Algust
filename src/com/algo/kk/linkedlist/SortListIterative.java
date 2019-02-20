package com.algo.kk.linkedlist;

public class SortListIterative {

	public ListNode getMiddle(ListNode h)  
    { 
        if (h == null) 
            return h; 
        ListNode fastptr = h.next; 
        ListNode slowptr = h; 
          
        while (fastptr != null) 
        { 
            fastptr = fastptr.next; 
            if(fastptr!=null) 
            { 
                slowptr = slowptr.next; 
                fastptr=fastptr.next; 
            } 
        } 
        return slowptr; 
    } 
	
	public ListNode sortList(ListNode a) {
		if(a == null || a.next == null){
			return a;
		}
		
		ListNode middle = getMiddle(a);
		ListNode middleNext = middle.next;
		middle.next = null;
		
		ListNode firstHalf = sortList(a);
		ListNode secondHalf = sortList(middleNext);
		
		ListNode merged = merge(firstHalf, secondHalf);
		return merged;
	}
	public ListNode merge(ListNode a, ListNode b) {
		if(a == null && b == null){
			return null;
		}
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		
		ListNode p = a, q = b, sorted = null, mergedStart = null;
		//assign s
		if(p.val <= q.val){
			sorted = p;
			mergedStart = p;
			p = p.next;
		} else {
			sorted = q;
			mergedStart = q;
			q = q.next;
		}
		//keep forming ll until one is null
		while (q != null && p != null) {
			if(p.val <= q.val){
				sorted.next = p;
				sorted = p;
				p = p.next;
			} else {
				sorted.next = q;
				sorted = q;
				q = q.next;
			}
			
		}
		
		
		//append the non null
		
		if(p == null) {
			sorted.next = q;
		}
		if(q == null) {
			sorted.next = p;
		}
		//
		
		return mergedStart;
	}
	
	public static void main(String[] args) {
		SortListIterative s = new SortListIterative();
		ListNode n = new ListNode(1);
		n.next = new ListNode(3);
		n.next.next = new ListNode(5);
		n.next.next.next = new ListNode(2);
		n.next.next.next.next = new ListNode(4);

		ListNode sorted = s.sortList(n);
		PrintUtils.print(sorted);

	}

}
