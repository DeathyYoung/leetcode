package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
	/**
	 * 106. Construct Binary Tree from Inorder and Postorder Traversal
	 * <p>
	 * Total Accepted: 63133 Total Submissions: 210375 Difficulty: Medium
	 * <p>
	 * Given inorder and postorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * Tags: Tree Array Depth-first Search
	 * 
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0
				|| postorder.length != inorder.length) {
			return null;
		}
		return buildTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] postorder, int[] inorder, int pl, int pr, int il, int ir) {
		if (pl > pr)
			return null;

		TreeNode tn = new TreeNode(postorder[pr]);
		int im = il;
		for (; im <= ir; im++) {
			if (inorder[im] == tn.val) {
				break;
			}
		}
		tn.left = buildTree(postorder, inorder, pl, im - il + pl - 1, il, im - 1);
		tn.right = buildTree(postorder, inorder, im - il + pl, pr - 1, im + 1, ir);
		return tn;
	}

	public static void main(String[] args) {
		L106_ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new L106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
		Integer[] nums1 = { null, 4, 2, 5, 1, 3, null, 6 };
		int[] postorder = { 1, 3, 2, 6, 5, 4 };
		int[] inorder = { 1, 2, 3, 4, 5, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		TreeNode tn2 = solution.buildTree(inorder, postorder);
		tn1.printInorder();
		tn2.printInorder();
		tn1.printPostorder();
		tn2.printPostorder();
		tn1.printPreorder();
		tn2.printPreorder();
	}

}
