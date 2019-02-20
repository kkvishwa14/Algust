package com.algo.kk.linkedlist;

public class ReverseSublist {
	
	public void print(Node n) {
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println("NULL");
	}	

    public Node reverse(Node a) {
        if(a == null || a.next == null){
            return a;
        }
        
        Node first = a;
        Node rest = a.next;
        Node reverseRest = reverse(rest);
        first.next.next = first;
        first.next = null;
        return reverseRest;
    }
    public Node reverseBetween(Node A, int B, int C) {
        if(B == C || A== null || A.next == null) {
            return A;
        }
        Node bPrev = null, cNext = null, bNode = null, cNode = null;
        Node curr = A;
        int i = 1;
         while( curr != null && i<=C) {
             if(i < B)
                bPrev = curr;
                
             if( i == B )
                bNode = curr;
                
             if( i== C ) {
                cNode = curr;
                cNext = curr.next;
               
             }
             i++;
             curr = curr.next;
         }
         cNode.next = null;
         cNode = reverse(bNode);
         if(bPrev != null){
             bPrev.next  = cNode;
         }
         else {
             A = cNode;
         }
         bNode.next = cNext;
         return A;
         
    }


	public static void main(String[] args) {

		
		Node head = new Node(10);
		head.next = new Node(20);
		 head.next.next = new Node(30);
		 head.next.next.next = new Node(40);
		 head.next.next.next.next = new Node(50);
		 head.next.next.next.next.next = new Node(60);
		 head.next.next.next.next.next.next = new Node(70);
		ReverseSublist r = new ReverseSublist();
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverseBetween(head,3,6);
		System.out.println("After reverse");
		r.print(head);
		
		System.out.println();
		
		head = new Node(10);
		head.next = new Node(20);
		System.out.println("Before reverse");
		r.print(head);
		head  = r.reverseBetween(head,1,2);
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
		head  = r.reverseBetween(head,1,7);
		System.out.println("After reverse");
		r.print(head);
		
	

	}

}
