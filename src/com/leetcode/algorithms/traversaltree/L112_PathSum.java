package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L112_PathSum {
	/**
	 * 112. Path Sum
	 * <p>
	 * Total Accepted: 117633 Total Submissions: 367245 Difficulty: Easy
	 * <p>
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * For example: Given the below binary tree and sum = 22,
	 * 
	 * <pre>
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	 * </pre>
	 * 
	 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is
	 * 22
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		if (root.left == null && root.right != null)
			return hasPathSum(root.right, sum - root.val);
		if (root.left != null && root.right == null)
			return hasPathSum(root.left, sum - root.val);
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		L112_PathSum solution = new L112_PathSum();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
