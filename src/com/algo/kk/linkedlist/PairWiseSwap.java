package com.algo.kk.linkedlist;

public class PairWiseSwap {

	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	
	public Node swap(Node head) {
		if(head == null || head.next == null){
			return head;
		}
		Node p, q, temp;
		p = head;
		head = p.next;
		
		while(true) {
			 q = p.next;
			 temp = q.next;
			 q.next = p;
			 if(temp == null || temp.next == null){
				 p.next = temp;
				 break;
			 }
			 
			 p.next = temp.next;
			 p = temp;
		}
		
		
		
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
		PairWiseSwap r = new PairWiseSwap();
		System.out.println("Before swap");
		r.print(head);
		head  = r.swap(head);
		System.out.println("After swap");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		System.out.println("Before swap");
		r.print(head);
		head  = r.swap(head);
		System.out.println("After swap");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Before swap");
		r.print(head);
		head  = r.swap(head);
		System.out.println("After swap");
		r.print(head);
		
		System.out.println();
	}

}
