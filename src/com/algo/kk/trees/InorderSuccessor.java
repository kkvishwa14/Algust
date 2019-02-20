package com.algo.kk.trees;

public class InorderSuccessor {

	  public Node inorder(Node root, Node k){
	        
		  	if(root == null) {
	           //System.out.println("root is null");
		  		return null;
		  	}
		  	//System.out.println("Root->"+root.key);
	        /*if(succ != null) {
	        	System.out.println("succ is set "+succ.key);
	        	return root;
	        } else {
	        	System.out.println("succ is null");
	        }*/
	        
	        Node succ = inorder(root.left, k);
	        if(succ != null){
	        	return succ;
	        }
	        if(root.key > k.key) {
	        	//System.out.println("setting succ as "+root.key);
	            return root;
	        }
	            
	        succ = inorder(root.right,k);
	        return succ;
	    }
		public Node inorderSuccessor(Node root,Node k)
	         {
	          //add code here.
	          //Node succ = null;
	          Node succ = inorder(root, k);
	          return succ;
	         }
	public static void main(String[] args) {
		Node root = new Node(600);
		
		
		root.left = new Node(400);
		root.right = new Node(700);
		root.right.right = new Node(900);
		
		Node k = new Node(900);
		InorderSuccessor is = new InorderSuccessor();
		Node succ = is.inorderSuccessor(root, k);
		if(succ != null)
			System.out.println(succ.key);
		else
			System.out.println("Null");
	}

}
