package com.leetcode.algorithms;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	/*
	 * (non-Javadoc) <p>Title: toString <p>TODO
	 *
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @since 2016年8月25日
	 */
	@Override
	public String toString() {
		return val + "";
	}

	public void printInorder() {
		printInorder(this);
		System.out.println();
	}

	private void printInorder(TreeNode root) {
		if (root.left != null) {
			printInorder(root.left);
		}
		System.out.print(root.val);
		System.out.print(", ");
		if (root.right != null) {
			printInorder(root.right);
		}
	}

	public void printPreorder() {
		printPreorder(this);
		System.out.println();
	}

	private void printPreorder(TreeNode root) {
		System.out.print(root.val);
		System.out.print(", ");
		if (root.left != null) {
			printPreorder(root.left);
		}
		if (root.right != null) {
			printPreorder(root.right);
		}
	}

	public void printPostorder() {
		printPostorder(this);
		System.out.println();
	}

	private void printPostorder(TreeNode root) {
		if (root.left != null) {
			printPostorder(root.left);
		}
		if (root.right != null) {
			printPostorder(root.right);
		}
		System.out.print(root.val);
		System.out.print(", ");
	}

	private static TreeNode getTreeFirstNull(Integer[] nums) {
		if (nums.length < 2 || nums[1] == null) {
			return null;
		}
		TreeNode[] tns = new TreeNode[nums.length];
		tns[1] = new TreeNode(nums[1]);
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != null) {
				tns[i] = new TreeNode(nums[i]);
				if ((i & 1) == 0) {// left
					tns[i >> 1].left = tns[i];
				} else {// right
					tns[i >> 1].right = tns[i];
				}
			}
		}
		return tns[1];
	}

	public static TreeNode getTree(Integer[] nums) {
		if (nums == null)
			return null;
		if (nums[0] == null) {
			return getTreeFirstNull(nums);
		}
		if (nums.length < 1) {
			return null;
		}
		TreeNode[] tns = new TreeNode[nums.length];
		tns[0] = new TreeNode(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != null) {
				tns[i] = new TreeNode(nums[i]);
				if ((i & 1) == 0) {// right
					tns[(i - 1) >> 1].right = tns[i];
				} else {// left
					tns[(i - 1) >> 1].left = tns[i];
				}
			}
		}
		return tns[0];
	}
}
