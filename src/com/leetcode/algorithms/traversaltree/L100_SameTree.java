package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L100_SameTree {
	/**
	 * 100. Same Tree
	 * <p>
	 * Total Accepted: 147947 Total Submissions: 335012 Difficulty: Easy
	 * <p>
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;
	}

	public static void main(String[] args) {
		L100_SameTree solution = new L100_SameTree();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
