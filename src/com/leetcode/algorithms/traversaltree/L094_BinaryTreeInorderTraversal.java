package com.leetcode.algorithms.traversaltree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetcode.algorithms.TreeNode;

public class L094_BinaryTreeInorderTraversal {
	/**
	 * 94. Binary Tree Inorder Traversal
	 * <p>
	 * Total Accepted: 142289 Total Submissions: 343305 Difficulty: Medium
	 * <p>
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree [1,null,2,3],
	 * 
	 * <pre>
	   1
	    \
	     2
	    /
	   3
	 * </pre>
	 * 
	 * return [1,3,2].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * Tags: Tree Hash Table Stack
	 * 
	 * 迭代中序遍历
	 * 
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
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
				if (tn.right != null){
					tn = stack.pop();
					stack.push(tn.right);
					tn.right=null;
					stack.push(tn);
				}
				if (tn.left != null)
					stack.push(tn.left);
				tn.left = null;
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		L094_BinaryTreeInorderTraversal solution = new L094_BinaryTreeInorderTraversal();
		Integer[] nums1 = { null, 4, 2, 5, 1, 3, null, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		tn1.printInorder();
		List<Integer> list = solution.inorderTraversal(tn1);
		System.out.println(list);
	}

}
