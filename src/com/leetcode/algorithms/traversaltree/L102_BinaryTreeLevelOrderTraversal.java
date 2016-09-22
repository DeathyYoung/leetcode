package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.leetcode.algorithms.TreeNode;

public class L102_BinaryTreeLevelOrderTraversal {
	/**
	 * 102. Binary Tree Level Order Traversal
	 * <p>
	 * Total Accepted: 119266 Total Submissions: 345079 Difficulty: Easy
	 * <p>
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
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
	 * return its level order traversal as:
	 * 
	 * <pre>
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	 * </pre>
	 * 
	 * Tags: Tree Breadth-first Search
	 * 
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
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
			list.add(level);
		}
		return list;
	}

	public static void main(String[] args) {
		L102_BinaryTreeLevelOrderTraversal solution = new L102_BinaryTreeLevelOrderTraversal();
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeNode tn = TreeNode.getTree(nums);
		List<List<Integer>> list = solution.levelOrder(tn);
		for (List l : list) {
			System.out.println(l);
		}
	}

}
