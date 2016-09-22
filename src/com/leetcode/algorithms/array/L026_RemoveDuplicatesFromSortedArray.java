package com.leetcode.algorithms.array;

public class L026_RemoveDuplicatesFromSortedArray {
	/**
	 * 26. Remove Duplicates from Sorted Array
	 * <p>
	 * Total Accepted: 150141 Total Submissions: 436307 Difficulty: Easy
	 * <p>
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	 * the new length.
	 * 
	 * Tags Array Two Pointers
	 * 
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 2)
			return nums.length;
		int len = 1;
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[index++] = nums[i];
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		L026_RemoveDuplicatesFromSortedArray solution = new L026_RemoveDuplicatesFromSortedArray();
		int[] nums1 = { 2, 5, 6, 6, 7, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		System.out.println(solution.removeDuplicates(nums1));
	}

}
