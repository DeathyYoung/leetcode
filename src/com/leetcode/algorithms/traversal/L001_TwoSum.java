package com.leetcode.algorithms.traversal;

public class L001_TwoSum {
	/**
	 * 1. Two Sum
	 * 
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * 
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * 
	 * return [0, 1].
	 * 
	 * UPDATE (2016/2/13): The return format had been changed to zero-based
	 * indices. Please read the above updated description carefully.
	 * 
	 * Tags: Array Hash Table
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		L001_TwoSum solution = new L001_TwoSum();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		int[] rst = solution.twoSum(nums1, 15);
		System.out.println(rst[0]);
		System.out.println(rst[1]);
	}

}
