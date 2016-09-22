package com.leetcode.algorithms;

public class L377 {

	/**
	 * Given an integer array with all positive numbers and no duplicates, find
	 * the number of possible combinations that add up to a positive integer
	 * target.
	 * 
	 * Example:
	 * 
	 * nums = [1, 2, 3] target = 4
	 * 
	 * The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1,
	 * 3) (2, 1, 1) (2, 2) (3, 1)
	 * 
	 * Note that different sequences are counted as different combinations.
	 * 
	 * Therefore the output is 7.
	 */
	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0 || target < 0)
			return 0;
		int[] rsts = new int[target + 1];
		rsts[0] = 1;
		for (int i = 1; i <= target; i++) {
			int rst = 0;
			for (int n = 0; n < nums.length; n++) {
				if (i >= nums[n]) {
					int j = i - nums[n];
					rst += rsts[j];
				}
			}
			rsts[i] = rst;
		}

		return rsts[rsts.length - 1];
	}

	public static void main(String[] args) {
		L377 solution = new L377();

		int rst = solution.combinationSum4(new int[] { 1, 2, 3 }, 5);
		System.out.println(rst);
	}
}
