package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L110_BalancedBinaryTree_XX {
	/**
	 * 110. Balanced Binary Tree
	 * <p>
	 * Total Accepted: 127312 Total Submissions: 363076 Difficulty: Easy
	 * <p>
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 * 遍历变种
	 */
	public boolean isBalancedErrorCheck(TreeNode root) {
		if (root == null)
			return false;
		int[] infos = maxDepthCheck(root);
		return infos[1] == 1;
	}

	private int[] maxDepthCheck(TreeNode root) {
		int[] infos = new int[2];
		if (root == null) {
			infos[0] = 0;
			infos[1] = 1;
			return infos;
		}
		int[] lefts = maxDepthCheck(root.left);
		int[] rights = maxDepthCheck(root.right);
		if (lefts[1] != 0 || rights[1] != 0) {
			infos[1] = Math.abs(lefts[0] - rights[0]) > 1 ? 0 : 1;
			infos[0] = 1 + Math.max(lefts[0], rights[0]);
		}
		return infos;
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left_depth = depth(root.left);
			int right_depth = depth(root.right);
			if (left_depth == -1 || right_depth == -1 || (left_depth - right_depth > 1)
					|| (left_depth - right_depth < -1))
				return -1;
			else if (left_depth - right_depth > 0)
				return left_depth + 1;
			else
				return right_depth + 1;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else
			return (depth(root) != -1);
	}

	// 1
	// 2 3
	// 4 5 n 6
	// 7 n n n n 8

	public static void main(String[] args) {
		L110_BalancedBinaryTree_XX solution = new L110_BalancedBinaryTree_XX();
		Integer[] nums = { 1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8 };
		TreeNode root = TreeNode.getTree(nums);
		System.out.println(solution.isBalanced(root));
	}

}
