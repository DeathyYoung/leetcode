package com.leetcode.algorithms.math;

public class L070_ClimbingStairs {
	/**
	 * 70. Climbing Stairs
	 * <p>
	 * Total Accepted: 123798 Total Submissions: 329339 Difficulty: Easy
	 * <p>
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * 
	 * <p>
	 * Tags: Dynamic Programming
	 * 
	 * 
	 */
	public int climbStairs(int n) {
		if (n < 0)
			return 0;
		if (n == 1)
			return n;
		int[] rst = new int[n];
		rst[0] = 1;
		rst[1] = 2;
		for (int i = 2; i < n; i++) {
			rst[i] = rst[i - 1] + rst[i - 2];
		}
		return rst[n-1];
	}

	public static void main(String[] args) {
		L070_ClimbingStairs solution = new L070_ClimbingStairs();
		System.out.println(solution.climbStairs(4));
	}

}
