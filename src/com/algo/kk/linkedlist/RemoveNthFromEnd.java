package com.algo.kk.linkedlist;

public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int lead=0;
        while(lead != n) {
            fast = fast.next;
            lead++;
        }
        if(fast == null){
        	return head.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
	public static void main(String[] args) {
		RemoveNthFromEnd r = new RemoveNthFromEnd();
		ListNode n = new ListNode(10);
		n.next = new ListNode(20);
		n.next.next = new ListNode(30);
		n.next.next.next = new ListNode(40);
		n.next.next.next.next = new ListNode(50);
		System.out.println("Before Operation");
		PrintUtils.print(n);
		n = r.removeNthFromEnd(n, 5);
		System.out.println("After Operation");
		PrintUtils.print(n);
	}

}
