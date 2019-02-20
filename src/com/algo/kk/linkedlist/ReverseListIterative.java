package com.algo.kk.linkedlist;

public class ReverseListIterative {

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
	public static void main(String[] args) {
		
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		ReverseListIterative r = new ReverseListIterative();
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
