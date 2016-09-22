package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.leetcode.algorithms.TreeNode;

public class L107_BinaryTreeLevelOrderTraversalII {
	/**
	 * 107. Binary Tree Level Order Traversal II
	 * <p>
	 * Total Accepted: 93108 Total Submissions: 261096 Difficulty: Easy
	 * <p>
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * For example: Given binary tree [3,9,20,null,null,15,7],
	 * 
	 * <pre>
	    3
	   / \
	  9  20
	    /  \
	   15   7
	 * </pre>
	 * 
	 * return its bottom-up level order traversal as:
	 * 
	 * <pre>
	[
	  [15,7],
	  [9,20],
	  [3]
	]
	 * </pre>
	 * 
	 * Tags: Tree Breadth-first Search
	 * 
	 * 
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> level = new LinkedList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				level.add(tn.val);
				if (tn.left != null) {
					q.offer(tn.left);
				}
				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
			list.add(0, level);
		}
		return list;
	}

	public static void main(String[] args) {
		L107_BinaryTreeLevelOrderTraversalII solution = new L107_BinaryTreeLevelOrderTraversalII();
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = TreeNode.getTree(nums);
		List<List<Integer>> list = solution.levelOrderBottom(root);
		for (List l : list) {
			System.out.println(l);
		}
	}

}
