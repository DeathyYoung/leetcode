package com.leetcode.algorithms.traversaltree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.algorithms.TreeNode;

public class L113_PathSumII {
	/**
	 * 113. Path Sum II
	 * <p>
	 * Total Accepted: 92126 Total Submissions: 311360 Difficulty: Medium
	 * <p>
	 * Given a binary tree and a sum, find all root-to-leaf paths where each
	 * path's sum equals the given sum.
	 * 
	 * For example: Given the below binary tree and sum = 22,
	 * 
	 * <pre>
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
	
	return
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	 * </pre>
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (root == null) {
			return rst;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			rst.add(list);
			return rst;
		}
		if (root.left != null) {
			List<List<Integer>> left = pathSum(root.left, sum - root.val);
			for (List<Integer> list : left) {
				list.add(0, root.val);
				rst.add(list);
			}
		}
		if (root.right != null) {
			List<List<Integer>> right = pathSum(root.right, sum - root.val);

			for (List<Integer> list : right) {
				list.add(0, root.val);
				rst.add(list);
			}
		}
		return rst;

	}

	public static void main(String[] args) {
		L113_PathSumII solution = new L113_PathSumII();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
