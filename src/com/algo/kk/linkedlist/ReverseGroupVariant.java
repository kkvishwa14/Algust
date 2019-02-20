package com.algo.kk.linkedlist;


/*
 * 
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.


 */
public class ReverseGroupVariant {
	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	
	public Node reverse(Node head) {
		Node current= head, prev = null, next = null;
		while(current !=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
    public Node reverseGroup(Node head, int k) {
        Node current= head, prev = null, next = null;
		int count = 0;
		while(current !=null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if(count < k) {
            return reverse(prev);
        }
		if(current != null)
			head.next = reverseGroup(current, k);
		return prev;    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		ReverseGroupVariant r = new ReverseGroupVariant();
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverseGroup(head,3);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverseGroup(head,2);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		 head.next.next.next.next.next.next.next = new Node(80);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverseGroup(head,5);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
	}

}
