package com.algo.kk.trees;

public class HasSumPath {
	public static boolean hasPathSum(TreeNode root, int sum){
	if (root == null)
		return false;
	if (root.val == sum && (root.left == null && root.right == null))
		return true;
 
	return hasPathSum(root.left, sum - root.val)
			|| hasPathSum(root.right, sum - root.val);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
