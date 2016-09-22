package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L101_SymmetricTree {
	/**
	 * 101. Symmetric Tree
	 * <p>
	 * Total Accepted: 124067 Total Submissions: 351525 Difficulty: Easy
	 * <p>
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	 * 
	 * <pre>
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	 * </pre>
	 * 
	 * But the following [1,2,2,null,3,null,3] is not:
	 * 
	 * <pre>
	    1
	   / \
	  2   2
	   \   \
	    3   3
	 * </pre>
	 * 
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
	 * 
	 * Tags: Tree Depth-first Search Breadth-first Search 遍历变种
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return false;
		return mirror(root.left, root.right);
	}

	private boolean mirror(TreeNode tn1, TreeNode tn2) {
		if (tn1 == null && tn2 == null)
			return true;
		if (tn1 == null || tn2 == null)
			return false;
		if (tn1.val != tn2.val)
			return false;
		return mirror(tn1.left, tn2.right) && mirror(tn1.right, tn2.left);
	}

	public static void main(String[] args) {
		L101_SymmetricTree solution = new L101_SymmetricTree();
		Integer[] nums1 = { null, 1, 2, 2, 3, 4, 4, 3 };
		Integer[] nums2 = { null, 1, 2, 2, null, 3, null, 3 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		TreeNode tn2 = TreeNode.getTree(nums2);
		System.out.println(solution.isSymmetric(tn1));
		System.out.println(solution.isSymmetric(tn2));
	}

}
