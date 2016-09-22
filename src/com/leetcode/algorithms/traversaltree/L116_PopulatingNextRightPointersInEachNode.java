package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeLinkNode;

public class L116_PopulatingNextRightPointersInEachNode {
	/**
	 * 116. Populating Next Right Pointers in Each Node
	 * <p>
	 * Total Accepted: 98722 Total Submissions: 269110 Difficulty: Medium
	 * <p>
	 * 
	 * Populate each next pointer to point to its next right node. If there is
	 * no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. You may assume that it is a
	 * perfect binary tree (ie, all leaves are at the same level, and every
	 * parent has two children). For example, Given the following perfect binary
	 * tree,
	 * 
	 * <pre>
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	 * </pre>
	 * 
	 * After calling your function, the tree should look like:
	 * 
	 * <pre>
	               1       -> NULL
	         /           \
	        2     ->      3   -> NULL
	     /    \        /     \
	    4  ->  5  ->  6  ->   7 -> NULL
	   / \    / \    / \     / \
	  8->9->10->11->12->13->14->15 -> NULL
	 * </pre>
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public void connect(TreeLinkNode root) {
		connect(root, null, null);
	}

	public void connect(TreeLinkNode root, TreeLinkNode left, TreeLinkNode right) {
		if (root == null)
			return;
		left = root.left;
		right = root.right;
		while (left != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
		connect(root.left, left, right);
		connect(root.right, left, right);
	}

	public static void main(String[] args) {
		L116_PopulatingNextRightPointersInEachNode solution = new L116_PopulatingNextRightPointersInEachNode();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
