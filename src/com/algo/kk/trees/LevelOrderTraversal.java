package com.algo.kk.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
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

	class BinaryTree {
		// Root of Binary Tree
		Node root;

		// Constructors
		BinaryTree(int key) {
			root = new Node(key);
		}

		BinaryTree() {
			root = null;
		}

		/**
		 * This prints the nodes of each level in separate lines.
		 * 
		 * @param root
		 */
		public void printLevelOrderTraversal(Node root) {
			if (root == null) {
				System.out.println("Tree empty");
				return;
			}
			Queue<Node> queue = new LinkedList<LevelOrderTraversal.Node>();

			// 1. push the root node into queue;
			queue.add(root);

			// 2. keep doing below until queue is not empty
			while (!queue.isEmpty()) {
				
				
				// 3. find the total elements in queue currently.
				// this iteration is for a new level..so the ocunt here means
				// the total nodes at this level.

				
				int count = queue.size();

				// 4. now for these many elements do the below task.

				for (int i = 0; i < count; i++) {
					// 5. remove the element and push its
					// elements
					Node n = queue.poll(); 
					
					// since loop runs for count times, all previous level
					// elements wll be removed from the queue..the queue at the
					// end will have next level elements only.
					
					//6. push its children
					if(n.left != null) {
						queue.add(n.left);
					}

					if(n.right != null) {
						queue.add(n.right);
					}
					//7.do the computation with this node
					System.out.print(n.key+" ");
					
				}
				System.out.println();
				
				
			}

		}

	}

	public static void main(String[] args) {


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
    */
		LevelOrderTraversal lot = new LevelOrderTraversal();
		BinaryTree bt = lot.new BinaryTree(4);
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

		n2.getLeft().getRight().setLeft(28);
		;

		bt.printLevelOrderTraversal(bt.root);
	}
}
