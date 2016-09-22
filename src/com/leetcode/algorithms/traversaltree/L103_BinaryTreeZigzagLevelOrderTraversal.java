package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.leetcode.algorithms.TreeNode;

public class L103_BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * 103. Binary Tree Zigzag Level Order Traversal
	 * <p>
	 * Total Accepted: 69945 Total Submissions: 231216 Difficulty: Medium
	 * <p>
	 * Given a binary tree, return the zigzag level order traversal of its
	 * nodes' values. (ie, from left to right, then right to left for the next
	 * level and alternate between).
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
	 * return its zigzag level order traversal as:
	 * 
	 * <pre>
	[
	  [3],
	  [20,9],
	  [15,7]
	]
	 * </pre>
	 * 
	 * 
	 * Tags: Tree Breadth-first Search Stack 层次遍历变种
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
		q.offer(root);
		boolean zigzag = false;
		while (!q.isEmpty()) {
			List<Integer> level = new LinkedList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (zigzag) {
					level.add(0, tn.val);
				} else {
					level.add(tn.val);
				}
				if (tn.left != null) {
					q.offer(tn.left);
				}
				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
			zigzag = !zigzag;
			list.add(level);
		}
		return list;
	}

	public static void main(String[] args) {
		L103_BinaryTreeZigzagLevelOrderTraversal solution = new L103_BinaryTreeZigzagLevelOrderTraversal();
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeNode tn = TreeNode.getTree(nums);
		List<List<Integer>> list = solution.zigzagLevelOrder(tn);
		for (List l : list) {
			System.out.println(l);
		}
	}

}
