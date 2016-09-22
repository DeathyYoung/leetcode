package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L111_MinimumDepthOfBinaryTree {
	/**
	 * 111. Minimum Depth of Binary Tree
	 * <p>
	 * Total Accepted: 121857 Total Submissions: 387979 Difficulty: Easy
	 * <p>
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 * 
	 * Tags: Tree Depth-first Search Breadth-first Search
	 * 
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.right == null && root.left != null) {
			return 1 + minDepth(root.left);
		}
		if (root.right != null && root.left == null) {
			return 1 + minDepth(root.right);
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static void main(String[] args) {
		L111_MinimumDepthOfBinaryTree solution = new L111_MinimumDepthOfBinaryTree();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
