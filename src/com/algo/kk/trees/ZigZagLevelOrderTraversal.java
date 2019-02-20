package com.algo.kk.trees;

import java.util.ArrayList;

public class ZigZagLevelOrderTraversal {

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		
		if(A == null) {
			return ans;
		}
		
		ArrayList<TreeNode> q1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
		
		q1.add(A);

		ArrayList<Integer> levelElements = new ArrayList<Integer>();
		levelElements.add(A.val);
		ans.add(levelElements);
		while (!(q1.isEmpty() && q2.isEmpty())) {
			ArrayList<Integer> levelElements1 = new ArrayList<Integer>();
			if (q2.isEmpty()) {

				while (!q1.isEmpty()) {
					TreeNode n = q1.remove(q1.size() - 1);
					if (n.right != null) {
						q2.add(n.right);
						levelElements1.add(n.right.val);
					}
					if (n.left != null) {
						q2.add(n.left);
						levelElements1.add(n.left.val);
					}
				}

			} else {
				while (!q2.isEmpty()) {
					TreeNode n = q2.remove(q2.size() - 1);
					if (n.left != null) {
						q1.add(n.left);
						levelElements1.add(n.left.val);
					}
					if (n.right != null) {
						q1.add(n.right);
						levelElements1.add(n.right.val);
					}

				}

			}
			if (!levelElements1.isEmpty()) {
				ans.add(levelElements1);
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(9);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(15);
		t.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(t));
	}

}
