package com.algo.kk.linkedlist;

import java.security.Principal;

public class RotateList {

	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + "  ");
			cur = cur.next;
		}
		System.out.println();
	}

	public int length(Node head) {
		if (head == null) {
			return 0;
		}
		return 1 + length(head.next);
	}

	public Node rotate(Node head, int k) {
		// add code here.

		int len = length(head);
		k = k % len;
		if (k != 0) {
			Node cur = head;
			for (int i = 0; i < k - 1; i++) {
				//System.out.println("i is : " + i);
				//System.out.println("cur value is :" + cur.data);
				//System.out.println("going to next cur");
				cur = cur.next;
				//System.out.println("cur now is :" + cur.data);

			}
			Node rest = cur.next;
			Node headPrev = head;
			if (rest == null) {
				return head;
			}
			Node c = rest;
			while (c.next != null) {
				c = c.next;
			}

			cur.next = null;
			c.next = headPrev;
			head = rest;
		}
		return head;
		
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
		RotateList r = new RotateList();
		System.out.println("before rotate");
		r.print(head);
		System.out.println("after rotate");
		head = r.rotate(head, 4);
		r.print(head);
		/*head = new Node(10);
		head.next = new Node(20);
		r.rotate(head, 1);*/

		
		/*head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		r.rotate(head, 7);*/
	}

}
