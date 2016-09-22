package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L104_MaximumDepthOfBinaryTree {
	/**
	 * 104. Maximum Depth of Binary Tree
	 * <p>
	 * Total Accepted: 169183 Total Submissions: 343564 Difficulty: Easy
	 * <p>
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 * 
	 * Tags: Tree Depth-first Search 
	 * 
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static void main(String[] args) {
		L104_MaximumDepthOfBinaryTree solution = new L104_MaximumDepthOfBinaryTree();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
