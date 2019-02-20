package com.algo.kk.linkedlist;


public class ReverseList {

	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	
	public Node reverse(Node head) {
		if(head == null || head.next == null){
			return head;
		} else {
			Node first = head;
			Node rest = head.next;
			Node reverseRest = reverse(rest);
			first.next.next = first;
			first.next = null;
			return reverseRest;
		}
	}
	public static void main(String[] args) {
		
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		ReverseList r = new ReverseList();
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverse(head);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(20);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverse(head);
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
		head  = r.reverse(head);
		System.out.println("After reverse");
		r.print(head);
		
	}

}
