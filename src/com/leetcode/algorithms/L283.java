package com.leetcode.algorithms;

public class L283 {

	/**
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
	 * nums should be [1, 3, 12, 0, 0].
	 * 
	 * Note: You must do this in-place without making a copy of the array.
	 * Minimize the total number of operations.
	 */
	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int t = nums[i];
				nums[i] = nums[index];
				nums[index] = t;
				index++;
			}
		}
	}

	public static void main(String[] args) {
		L283 solution = new L283();
		int[] nums = { 0, 1, 0, 3, 12 };
		solution.moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}
}
