package com.leetcode.algorithms.dp;

public class L062_UniquePaths {
	/**
	 * 
	 * 62. Unique Paths
	 * 
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * 
	 * Above is a 3 x 7 grid. How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * 
	 */
	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];

		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			grid[i][0] = 1;
			for (int j = 1; j < n; j++) {
				grid[i][j]=grid[i-1][j]+grid[i][j-1];
			}
		}

		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		L062_UniquePaths solution = new L062_UniquePaths();
		int m = 3;
		int n = 7;
		System.out.println(solution.uniquePaths(m, n));
	}

}
