package com.algo.kk.linkedlist;

public class PrintUtils {
	public static void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}
	
	public static void print(ListNode n) {
		ListNode cur = n;
		while (cur != null) {
			System.out.print(cur.val + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}
}
