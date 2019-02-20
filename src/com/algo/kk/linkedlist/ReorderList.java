package com.algo.kk.linkedlist;

public class ReorderList {

	public ListNode getMiddle(ListNode h) {
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
	public ListNode reverse(ListNode n) {
		ListNode current= n, prev = null, next = null;
		while(current !=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		n = prev;
		return n;
	}
	public ListNode reorderList(ListNode n) {
		if(n == null || n.next ==  null || n.next.next == null){
			return n;
		}
		ListNode middle = getMiddle(n);
		ListNode middleNext = middle.next;
		middleNext = reverse(middleNext);
		middle.next = null;
		ListNode curr = n;
		while(middleNext != null) {
			ListNode temp = curr.next;
			curr.next = middleNext;
			middleNext = middleNext.next;
			curr.next.next = temp;
			curr = temp;
		}
		
		return n;
	}
	public static void main(String[] args) {
		ReorderList s = new ReorderList();
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(5);

		n.next.next.next.next.next = new ListNode(6);
		n.next.next.next.next.next.next = new ListNode(7);
		ListNode sorted = s.reorderList(n);
		PrintUtils.print(sorted);
		
		n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(5);

		n.next.next.next.next.next = new ListNode(6);
		n.next.next.next.next.next.next = new ListNode(7);
		n.next.next.next.next.next.next.next = new ListNode(8);
		sorted = s.reorderList(n);
		PrintUtils.print(sorted);

	}

}
