package com.leetcode.algorithms.dp;

public class L064_MinimumPathSum {
	/**
	 * 64. Minimum Path Sum
	 * <p>
	 * Total Accepted: 81392 Total Submissions: 225492 Difficulty: Medium
	 * <p>
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * Tags: Array Dynamic Programming
	 */
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}

		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		L064_MinimumPathSum solution = new L064_MinimumPathSum();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
