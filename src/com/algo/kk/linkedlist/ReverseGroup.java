package com.algo.kk.linkedlist;

public class ReverseGroup {
	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	
	
	public Node reverseGroup(Node head, int K) {
		
		Node current= head, prev = null, next = null;
		int count = 0;
		while(current !=null && count < K) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(current != null)
			head.next = reverseGroup(current, K);
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
		ReverseGroup r = new ReverseGroup();
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
	}

}
