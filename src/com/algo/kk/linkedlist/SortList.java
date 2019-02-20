package com.algo.kk.linkedlist;

public class SortList {

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
		if(a.val < b.val){
			a.next = merge(a.next , b);
			return a;
		}
		else{
			b.next = merge(a , b.next);
			return b;
		}
	}
	public static void main(String[] args) {
		SortList s = new SortList();
		ListNode n = new ListNode(1);
		n.next = new ListNode(3);
		n.next.next = new ListNode(5);
		n.next.next.next = new ListNode(2);
		n.next.next.next.next = new ListNode(4);

		ListNode sorted = s.sortList(n);
		PrintUtils.print(sorted);

	}

}
