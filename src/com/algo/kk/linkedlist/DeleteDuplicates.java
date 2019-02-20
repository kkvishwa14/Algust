package com.algo.kk.linkedlist;

public class DeleteDuplicates {
	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	


	public Node deleteDuplicates(Node A) {
        if(A == null || A.next == null) {
            return A;
        }
        int prevVal = A.data;
        Node curr = A.next;
        Node prev = A;
        while ( curr != null) {
            if(curr.data == prevVal) {
                curr = curr.next;
            }else {
                prev.next = curr;
                prevVal = curr.data;
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = null;
        return A;
    }
	
	public static void main(String[] args) {
		
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(20);
		 head.next.next.next = new Node(30);
		 head.next.next.next.next = new Node(30);
		 head.next.next.next.next.next = new Node(30);
		 head.next.next.next.next.next.next = new Node(40);
		DeleteDuplicates r = new DeleteDuplicates();
		System.out.println("Before reverse");
		r.print(head);
		head  = r.deleteDuplicates(head);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(10);
		head.next.next = new Node(10);
		head.next.next.next = new Node(10);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.deleteDuplicates(head);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.deleteDuplicates(head);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
	}

}
