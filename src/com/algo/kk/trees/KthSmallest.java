package com.algo.kk.trees;

public class KthSmallest {
	 //static int counter = 0;
	static class counter {
		int val;
	}
	    public static Node inorder(Node root, int n,counter c){
	        if(root == null){
	            return null;    
	        }
	        Node ans = inorder(root.left,n,c);
	        if(ans != null){
	            return ans;
	        }
	        c.val++;
	        if(n==c.val){
	            return root;
	        }
	        return inorder(root.right,n, c);
	        
	    }
	    public static int kthSmallest(Node root,int k)
	    {
	    	counter c = new counter();
	    	c.val = 0;
	        //Add your code here.
	        Node smallest = inorder(root,k,c);
	        if(smallest != null)
	        	return smallest.key;
	        return 0;
	    }
	public static void main(String[] args) {
		Node root = new Node(962);
		
		root.left = new Node(29);
		root.left.left = new Node(8);
		
		root.left.right = new Node(643);
		
		root.left.right.left = new Node(291);
		root.left.right.right = new Node(916);

		root.left.right.left.left = new Node(133);
		root.left.right.left.right = new Node(298);
		
		root.left.right.left.left.right = new Node(175);
		
		root.left.right.left.right.right = new Node(481);
		
		root.left.right.right.right = new Node(948);
		
		System.out.println(kthSmallest(root, 11));
		
	}

}
