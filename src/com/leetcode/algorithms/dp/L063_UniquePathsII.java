package com.leetcode.algorithms.dp;

public class L063_UniquePathsII {
	/**
	 * 63. Unique Paths II
	 * <p>
	 * Total Accepted: 75309 Total Submissions: 249822 Difficulty: Medium
	 * <p>
	 * Follow up for "62. Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * <pre>
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	 * </pre>
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * Tags: Array Dynamic Programming
	 * 
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] grid = new int[m][n];

        grid[0][0] = obstacleGrid[0][0] ^ 1;

		for (int j = 1; j < n; j++) {
			grid[0][j] = (obstacleGrid[0][j] ^ 1) & grid[0][j-1];
		}
		for (int i = 1; i < m; i++) {
			grid[i][0] = (obstacleGrid[i][0] ^ 1) & grid[i - 1][0];
			for (int j = 1; j < n; j++) {
			    if(obstacleGrid[i][j]==0){
				    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			    }
			}
		}

		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		L063_UniquePathsII solution = new L063_UniquePathsII();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		int a = 0;
		System.out.println(a ^ 1);
	}

}
