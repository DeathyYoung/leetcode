package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L124_BinaryTreeMaximumPathSum_XX {
	/**
	 * 124. Binary Tree Maximum Path Sum
	 * <p>
	 * Total Accepted: 72191 Total Submissions: 299723 Difficulty: Hard
	 * <p>
	 * Given a binary tree, find the maximum path sum.
	 * 
	 * For this problem, a path is defined as any sequence of nodes from some
	 * starting node to any node in the tree along the parent-child connections.
	 * The path does not need to go through the root.
	 * 
	 * For example: Given the below binary tree,
	 * 
	 * <pre>
	       1
	      / \
	     2   3
	 * </pre>
	 * 
	 * Return 6.
	 * 
	 * Tags: Tree Depth-first Search 遍历变种
	 */
	public int maxPathSum2(TreeNode root) {
		int rootMaxPath = 0;
		if (root == null)
			return 0;
		{// 经过root，找两条最长的计算
			int leftMax = getDepthMax(root.left);
			int rightMax = getDepthMax(root.right);
			rootMaxPath = root.val + leftMax + rightMax;
		}
		int leftMaxPath = maxPathSum(root.left);
		int rightMaxPath = maxPathSum(root.right);
		if (root.left != null && rootMaxPath < leftMaxPath) {
			rootMaxPath = leftMaxPath;
		}
		if (root.right != null && rootMaxPath < rightMaxPath) {
			rootMaxPath = rightMaxPath;
		}
		return rootMaxPath;
	}

	/**
	* <p> TODO
	*
	* @param root
	* @return
	*/ 
	private int getDepthMax(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return root.val > 0 ? root.val : 0;
		} else if (root.left != null && root.right == null) {
			int sub = getDepthMax(root.left);
			return root.val + sub > 0 ? root.val + sub : 0;
		} else if (root.left == null && root.right != null) {
			int sub = getDepthMax(root.right);
			return root.val + sub > 0 ? root.val + sub : 0;
		} else {
			int sub = Math.max(getDepthMax(root.left), getDepthMax(root.right));
			return root.val + sub > 0 ? root.val + sub : 0;
		}

	}

	//////////////////////
	
	int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
	public static void main(String[] args) {
		L124_BinaryTreeMaximumPathSum_XX solution = new L124_BinaryTreeMaximumPathSum_XX();
		Integer[] nums1 = { -2, -1 };
		TreeNode tn = TreeNode.getTree(nums1);
		System.out.println(solution.maxPathSum(tn));
	}

}
