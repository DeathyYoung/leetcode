package com.leetcode.algorithms.traversaltree;

import java.util.Stack;

import com.leetcode.algorithms.TreeNode;

public class L114_FlattenBinaryTreetoLinkedList {
	/**
	 * 114. Flatten Binary Tree to Linked List
	 * <p>
	 * Total Accepted: 92750 Total Submissions: 288426 Difficulty: Medium
	 * <p>
	 * Given a binary tree, flatten it to a linked list in-place.
	 * 
	 * For example, Given
	 * 
	 * <pre>
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	 * </pre>
	 * 
	 * The flattened tree should look like:
	 * 
	 * <pre>
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	 * </pre>
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode tn = stack.pop();
			if (tn.right != null)
				stack.push(tn.right);
			if (tn.left != null)
				stack.push(tn.left);
			tn.left = null;
			if (stack.empty())
				tn.right = null;
			else
				tn.right = stack.peek();
		}
	}

	public static void main(String[] args) {
		L114_FlattenBinaryTreetoLinkedList solution = new L114_FlattenBinaryTreetoLinkedList();
		Integer[] nums1 = { null, 1, 2, 5, 3, 4, null, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		solution.flatten(tn1);
		tn1.printInorder();
		tn1.printPreorder();
	}

}
