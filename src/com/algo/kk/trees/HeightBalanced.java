package com.algo.kk.trees;

public class HeightBalanced {

	public int getHeight(TreeNode A) {
		if(A==null)
			return 0;
		return Math.max(getHeight(A.left)+1, getHeight(A.right)+1);
	}
	public boolean isHeightBalanced(TreeNode A){
		if(A == null){
			return true;
		}
		int lheight = getHeight(A.left);
		int rheight = getHeight(A.right);
		if((Math.abs(lheight-rheight)== 1 ||Math.abs(lheight-rheight)==0) && isHeightBalanced(A.right)&& isHeightBalanced(A.left)){
			return true;
		}
		
		return false;
	}
	public int isBalanced(TreeNode A) {		
		return isHeightBalanced(A) ? 1 : 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
