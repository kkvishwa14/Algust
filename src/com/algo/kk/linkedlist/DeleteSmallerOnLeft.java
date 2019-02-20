package com.algo.kk.linkedlist;

public class DeleteSmallerOnLeft {

	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}
	public Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node first = head;
		Node rest = first.next;
		Node reversedRest = reverse(rest);
		first.next.next = first;
		first.next = null;
		return reversedRest;
	}
	public Node  delete2(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node reversedList = reverse(head);
		Node curr = reversedList;
		Node prev = null;
		int max = Integer.MIN_VALUE;
		while(curr != null) {
			if(curr.data < max){
				prev.next = curr.next;
				curr = curr.next;
			} else if(curr.data > max) {
				
				max = curr.data;
				prev = curr;
				curr = curr.next;
			}
			
		}
		reversedList = reverse(reversedList);
		return null;
		
	}
	public Node delete(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node curr = head, prev = null;
		
		while(curr.next != null) {
			if(curr.data < curr.next.data) {
				if(prev == null) {
					curr = curr.next;
					head = curr.next;
				} else {
					prev.next = curr.next;
					curr = curr.next;		
				}
			} else {
				prev = curr;
				curr = curr.next;
				
			}
		}
		return head;
	}
	public static void main(String[] args) {
		
		//NOT WORKING
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		DeleteSmallerOnLeft r = new DeleteSmallerOnLeft();
		System.out.println("Before Delete");
		r.print(head);
		head  = r.delete2(head);
		System.out.println("After Delete");
		r.print(head);
		
		System.out.println();

		
		head = new Node(12);
		head.next = new Node(15);
		 head.next.next = new Node(10);
		 head.next.next.next = new Node(11);
		 head.next.next.next.next = new Node(5);
		 head.next.next.next.next.next = new Node(6);
		 head.next.next.next.next.next.next = new Node(2);
		 head.next.next.next.next.next.next.next = new Node(3);
		System.out.println("Before Delete");
		r.print(head);
		head  = r.delete2(head);
		System.out.println("After Delete");
		r.print(head);
		
		System.out.println();
		
		head = new Node(70);
		head.next = new Node(60);
		 head.next.next = new Node(50);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(30);
		 head.next.next.next.next.next = new Node(20);
		 head.next.next.next.next.next.next = new Node(10);
		System.out.println("Before Delete");
		r.print(head);
		head  = r.delete2(head);
		System.out.println("After Delete");
		r.print(head);
		
		System.out.println();
		
		
		
		//wrong
		head = new Node(60);
		head.next= new Node(58);
		head.next.next = new Node(50);
		 head.next.next.next = new Node(70);
		 System.out.println("Before Delete");
			r.print(head);
			head  = r.delete2(head);
			System.out.println("After Delete");
			r.print(head);
			
			System.out.println();
			
			
			head = new Node(709); 
			head.next = new Node(206); 
			head.next.next = new Node(45);
			head.next.next.next = new Node(415);
			head.next.next.next.next = new Node(649);
			head.next.next.next.next.next = new Node(120);
		    head.next.next.next.next.next.next = new Node(80);
			head.next.next.next.next.next.next.next = new Node(47);
			head.next.next.next.next.next.next.next.next = new Node(415);
			head.next.next.next.next.next.next.next.next.next = new Node(606);
			head.next.next.next.next.next.next.next.next.next.next = new Node(275);
			head.next.next.next.next.next.next.next.next.next.next.next = new Node(500);
		    head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(900);
		    head.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(11);
		    head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(767);
		    System.out.println("Before Delete");
			r.print(head);
			head  = r.delete2(head);
			System.out.println("After Delete");
			r.print(head);
			
			System.out.println();																					
			
			head = new Node(906); 
			head.next = new Node(334); 
			head.next.next = new Node(176);
			head.next.next.next = new Node(9);
			head.next.next.next.next = new Node(563);
			System.out.println("Before Delete");
			r.print(head);
			head  = r.delete2(head);
			System.out.println("After Delete");
			r.print(head);
			
			System.out.println();																					
			
	}

}
