package com.algo.kk.linkedlist;

public class InsertionSortList {

	public ListNode reverse(ListNode n) {
		
		if(n == null || n.next == null){
			return n;
		}
		ListNode curr = n, next= null, prev = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		n = prev;
		return n;
	}
	
	public ListNode insertNodeInSorted(ListNode n, ListNode node) {
		if(n == null){
			return node;
		}
		if(node == null){
			return n;
		}
		
		ListNode prev = null;
		ListNode curr = n;
		ListNode sortedHead = n;
		while(curr != null){
			if(node.val >= curr.val){
				if(prev==null){
					node.next = curr;
					sortedHead = node;
					return sortedHead;
				}else {
					node.next = curr;
					prev.next = node;
					return sortedHead;
				}
			}else{
				prev = curr;
				curr = curr.next;
			}
		}
		prev.next = node;
		return sortedHead;
		
	}
	public ListNode sortList(ListNode n){
		if(n== null || n.next == null){
			return n;
		}
		ListNode sortedStart = n, curr = n.next, restUnsorted = curr.next;
		sortedStart.next = null;
		while(curr != null) {
			curr.next = null;
			sortedStart = insertNodeInSorted(sortedStart, curr);
			curr = restUnsorted;
			if(curr!= null)
				restUnsorted = restUnsorted.next;
		}
		
		n = reverse(sortedStart);
		return n;
	}
	public static void main(String[] args) {
		InsertionSortList s = new InsertionSortList();
		ListNode n = new ListNode(14);
		n.next = new ListNode(12);
		
		n.next.next = new ListNode(36);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(15);

		n.next.next.next.next.next = new ListNode(61);
		n.next.next.next.next.next.next = new ListNode(7);
		ListNode sorted = s.sortList(n);
		PrintUtils.print(sorted);
		n = new ListNode(16);
		n.next = new ListNode(2);
		n.next.next = new ListNode(13);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(56);

		n.next.next.next.next.next = new ListNode(6);
		n.next.next.next.next.next.next = new ListNode(17);
		n.next.next.next.next.next.next.next = new ListNode(8);
		sorted = s.sortList(n);
		PrintUtils.print(sorted);
		

	}

}
