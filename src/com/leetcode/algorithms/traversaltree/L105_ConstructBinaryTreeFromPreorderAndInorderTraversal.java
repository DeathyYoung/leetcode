package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	/**
	 * 105. Construct Binary Tree from Preorder and Inorder Traversal
	 * <p>
	 * Total Accepted: 72975 Total Submissions: 245379 Difficulty: Medium
	 * <p>
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * Tags: Tree Array Depth-first Search
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length) {
			return null;
		}
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
		if (pl > pr)
			return null;
		
		TreeNode tn = new TreeNode(preorder[pl]);
		int im = il;
		for (; im <= ir; im++) {
			if (inorder[im] == tn.val) {
				break;
			}
		}

		tn.left = buildTree(preorder, inorder, pl + 1, im - il + pl, il, im - 1);
		tn.right = buildTree(preorder, inorder, im - il + pl + 1, pr, im + 1, ir);
		return tn;
	}

	public static void main(String[] args) {
		L105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new L105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		Integer[] nums1 = { null, 4, 2, 5, 1, 3, null, 6 };
		TreeNode tn1 = TreeNode.getTree(nums1);
		int[] preorder = { 4, 2, 1, 3, 5, 6 };
		int[] inorder = { 1, 2, 3, 4, 5, 6 };
		TreeNode tn2 = solution.buildTree(preorder, inorder);
		tn1.printInorder();
		tn2.printInorder();
		tn1.printPostorder();
		tn2.printPostorder();
		tn1.printPreorder();
		tn2.printPreorder();
		
	}

}
