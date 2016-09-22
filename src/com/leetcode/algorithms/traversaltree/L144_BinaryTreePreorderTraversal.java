package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetcode.algorithms.TreeNode;

public class L144_BinaryTreePreorderTraversal {
	/**
	 * 145. Binary Tree Postorder Traversal
	 * <p>
	 * Total Accepted: 108616 Total Submissions: 295272 Difficulty: Hard
	 * <p>
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3},
	 * 
	 * <pre>
	   1
	    \
	     2
	    /
	   3
	 * </pre>
	 * 
	 * return [1,2,3].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * Tags: Tree Stack
	 * 
	 * 迭代前序遍历
	 * 
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.empty()) {
			TreeNode tn = stack.pop();
			if (tn.right != null)
				stack.push(tn.right);
			if (tn.left != null)
				stack.push(tn.left);
			list.add(tn.val);
		}
		return list;
	}

	public static void main(String[] args) {
		L144_BinaryTreePreorderTraversal solution = new L144_BinaryTreePreorderTraversal();
		Integer[] nums1 = { null, 4, 2, 5, 1, 3, null, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		tn1.printPreorder();
		List<Integer> list = solution.preorderTraversal(tn1);
		System.out.println(list);
	}

}
