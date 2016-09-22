package com.leetcode.algorithms.dp;

public class L096_UniqueBinarySearchTrees {
	/**
	 * 96. Unique Binary Search Trees
	 * <p>
	 * Total Accepted: 93044 Total Submissions: 241198 Difficulty: Medium
	 * <p>
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * <pre>
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 * </pre>
	 * 
	 * Tags: Tree, Dynamic Programming
	 * 
	 */
	public int numTrees(int n) {
		if (n < 1)
			return 0;
		int[] rst = new int[n + 1];
		rst[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				rst[i] += rst[j] * rst[i - 1 - j]; 
			}
		}
		return rst[n];
	}

	public static void main(String[] args) {
		L096_UniqueBinarySearchTrees solution = new L096_UniqueBinarySearchTrees();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		System.out.println(solution.numTrees(5));
	}
}
