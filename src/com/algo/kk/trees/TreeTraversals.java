package com.algo.kk.trees;

import java.util.Stack;




class Node
{
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
    public Node getLeft() {
    	return left;
    }
    public Node getRight() {
    	return right;
    }
    
    public void setLeft(int val) {
    	this.left = new Node(val);
    }
    public void setRight(int val) {
    	this.right = new Node(val);
    }
}

class BinaryTree
{
    // Root of Binary Tree
    Node root;
 
    // Constructors
    BinaryTree(int key)
    {
        root = new Node(key);
    }
 
    BinaryTree()
    {
        root = null;
    }
    
    public void printInorderTraversalRecursive(Node root) {
    	if(root == null)
    		return;
    	printInorderTraversalRecursive(root.getLeft());
    	System.out.print(root.key+" ");
    	printInorderTraversalRecursive(root.getRight());
    }
    public void printPreorderTraversalRecursive(Node root) {
    	if(root == null)
    		return;
    	System.out.print(root.key+" ");
    	printPreorderTraversalRecursive(root.getLeft());
    	printPreorderTraversalRecursive(root.getRight());
    }
    
    public void printPostorderTraversalRecursive(Node root) {
    	if(root == null)
    		return;
    	
    	printPostorderTraversalRecursive(root.getLeft());
    	printPostorderTraversalRecursive(root.getRight());
    	System.out.print(root.key+" ");
    }
    
    public void printPreorderTraversalNonRecursive(Node root) {
    	if(root == null)
    		return; 
    	Stack<Node> stack = new Stack<Node>();
    	stack.push(root);
    	
    	while(!stack.empty()) {
    		Node n = stack.pop();
    		System.out.print(n.key+ " ");
    		if(n.getRight() != null)
    			stack.push(n.getRight());
    		if(n.getLeft() != null)
    			stack.push(n.getLeft());
    	}
    	
    	
    }
    
    public void printInorderTraversalNonRecursive(Node root) {
    	if(root == null)
    		return;
    	Stack<Node> stack = new Stack<Node>();
    	
    	Node current = root;
    	
    	while (!stack.isEmpty() || current != null) {
    		if( current != null) {
    			stack.push(current);
    			current = current.getLeft();
    		} else {
    			current = stack.pop();
    			System.out.print(current.key+" ");
    			current = current.getRight();
    		}
    	}
    }
    
    public void printPostorderTraversalNonRecursive2Stacks(Node root) {
    	
    	if(root == null)
    		return;
    	Stack<Node> stack = new Stack<Node>();
    	Stack<Integer> postOrderData = new Stack<Integer>();
    	
    	stack.push(root);
    	
    	while(!stack.isEmpty()) {
			Node topNode = stack.pop();
			postOrderData.push(topNode.key);

			if (topNode.getLeft() != null) {
				stack.push(topNode.getLeft());
			}
			if (topNode.getRight() != null) {
				stack.push(topNode.getRight());
			}
		}

		while (!postOrderData.isEmpty()) {
			System.out.print(postOrderData.pop() + " ");
		}
    }
    
}
/*
				   4
				/     \	
			  1	        7
			/	       /   \
	      2           6      9
	    /   \        /        \
	  21  	23      24         25
	   \              \
	   26              27
     /
    28
    
    Inorder : 21 28 26 2 23 1 4  24 27 6 7 9 25
    
    
    Preorder : 4 1 2 21 26 28 23 7 6 24 27 9 25 
    
    Postorder : 28 26 21 23 2 1 27 24 6 25 9 7 4
    
    
*/
public class TreeTraversals {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(4);
		bt.root.setLeft(1);
		bt.root.setRight(7);
		
		bt.root.getLeft().setLeft(2);
		bt.root.getRight().setLeft(6);
		bt.root.getRight().setRight(9);
		
		Node n2 = bt.root.getLeft().getLeft();
		n2.setLeft(21);
		n2.setRight(23);
		
		Node n6 = bt.root.getRight().getLeft();
		Node n9 = bt.root.getRight().getRight();
		
		n6.setLeft(24);
		n9.setRight(25);
		
		n2.getLeft().setRight(26);
		n6.getLeft().setRight(27);
		
		n2.getLeft().getRight().setLeft(28);;
		
		System.out.println("Recursive Inorder");
		bt.printInorderTraversalRecursive(bt.root);
		System.out.println();
		
		System.out.println("Non recursive Inorder");
		bt.printInorderTraversalNonRecursive(bt.root);
		System.out.println();
		
		System.out.println("Recursive Preorder");
		bt.printPreorderTraversalRecursive(bt.root);
		System.out.println();
		

		System.out.println("Non recursive Preorder");
		bt.printPreorderTraversalNonRecursive(bt.root);
		System.out.println();
		
		System.out.println("Recursive Postorder");
		bt.printPostorderTraversalRecursive(bt.root);
		System.out.println();
		
		System.out.println("Non recursive Postorder");
		bt.printPostorderTraversalNonRecursive2Stacks(bt.root);
		System.out.println();
	}
}
