package com.algo.kk.trees;



public class SumRootToLeaf {

	public static int dfs(TreeNode node, int num, int sum){
	    if(node == null) return sum;
	 
	    num = num*10 + node.val;
	 
	    // leaf
	    if(node.left == null && node.right == null) {
	        sum += num;
	        return sum;
	    }
	 
	    // left subtree + right subtree
	    sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
	    return sum;
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(3);
		System.out.println(dfs(root,0,0));
	}

}
