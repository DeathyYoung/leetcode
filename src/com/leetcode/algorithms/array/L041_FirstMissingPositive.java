package com.leetcode.algorithms.array;

public class L041_FirstMissingPositive {
	/**
	 * 41. First Missing Positive
	 * 
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 * 
	 * Tags: Array
	 */
	public int firstMissingPositive(int[] nums) {
		int[] target = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length) {
				target[nums[i] - 1]++;
			}
		}
		for (int i = 0; i < target.length; i++) {
			if (target[i] == 0) {
				return i + 1;
			}
		}
		return target.length + 1;
	}

	public static void main(String[] args) {
		L041_FirstMissingPositive solution = new L041_FirstMissingPositive();
		int[] nums1 = { 1, 2, 6, 7, 8, 9, 10 };
		int[] nums2 = { 3, 4, -1, 1 };
		System.out.println(solution.firstMissingPositive(nums1));
		System.out.println(solution.firstMissingPositive(nums2));
	}

}
