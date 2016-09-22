package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetcode.algorithms.TreeNode;

public class L145_BinaryTreePostorderTraversal {
	/**
	 * 145. Binary Tree Postorder Traversal
	 * <p>
	 * Total Accepted: 108616 Total Submissions: 295272 Difficulty: Hard
	 * <p>
	 * Given a binary tree, return the postorder traversal of its nodes' values.
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
	 * return [3,2,1].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * Tags: Tree Stack
	 * 
	 * 迭代后序遍历
	 * 
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.empty()) {
			
			TreeNode tn = stack.peek();
			if (tn.left == null && tn.right == null) {
				list.add(tn.val);
				stack.pop();
			} else {
				if (tn.right != null)
					stack.push(tn.right);
				if (tn.left != null)
					stack.push(tn.left);
				tn.left = null;
				tn.right = null;
			}
			
		}
		return list;

	}

	public static void main(String[] args) {
		L145_BinaryTreePostorderTraversal solution = new L145_BinaryTreePostorderTraversal();
		Integer[] nums1 = { null, 4, 2, 5, 1, 3, null, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		tn1.printPostorder();
		List<Integer> list = solution.postorderTraversal(tn1);
		System.out.println(list);
	}

}
