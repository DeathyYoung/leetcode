package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L129_SumRootToLeafNumbers {
	/**
	 * 129. Sum Root to Leaf Numbers
	 * <p>
	 * Total Accepted: 85775 Total Submissions: 253242 Difficulty: Medium
	 * <p>
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
	 * path could represent a number.
	 * 
	 * An example is the root-to-leaf path 1->2->3 which represents the number
	 * 123.
	 * 
	 * Find the total sum of all root-to-leaf numbers.
	 * 
	 * For example,
	 * 
	 * <pre>
	    1
	   / \
	  2   3
	 * </pre>
	 * 
	 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf
	 * path 1->3 represents the number 13.
	 * 
	 * Return the sum = 12 + 13 = 25.
	 * 
	 * Tags: Tree Depth-first Search
	 */
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		int sum = sumNumbersWithSum(root, 0, 0);
		return sum;
	}

	public int sumNumbersWithSum(TreeNode node, int fatherVal, int sum) {

		int val = fatherVal * 10 + node.val;

		if (node.left == null && node.right == null) {
			sum += val;
			return sum;
		}

		if (node.right != null) {
			sum = sumNumbersWithSum(node.right, val, sum);
		}

		if (node.left != null) {
			sum = sumNumbersWithSum(node.left, val, sum);
		}

		return sum;
	}

	public static void main(String[] args) {
		L129_SumRootToLeafNumbers solution = new L129_SumRootToLeafNumbers();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
