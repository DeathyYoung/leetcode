package com.leetcode.algorithms.array;

public class L080_RemoveDuplicatesFromSortedArrayII {
	/**
	 * 80. Remove Duplicates from Sorted Array II
	 * 
	 * Total Accepted: 84991 Total Submissions: 251461 Difficulty: Medium Follow
	 * up for "Remove Duplicates":
	 * 
	 * What if duplicates are allowed at most twice?
	 * 
	 * For example, Given sorted array nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the
	 * new length.
	 * 
	 * 
	 * 
	 * Tags: Array Two Pointers
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		int most = 2;
		if (nums == null)
			return 0;
		if (nums.length <= most)
			return nums.length;
		int count = 1;
		int len = 1;
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
				if (count <= most) {
					nums[index++] = nums[i];
					len++;
				}
			} else {
				count = 1;
				len++;
				nums[index++] = nums[i];
			}
		}
		return len;
	}

	public static void main(String[] args) {
		L080_RemoveDuplicatesFromSortedArrayII solution = new L080_RemoveDuplicatesFromSortedArrayII();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int rst = solution.removeDuplicates(nums);
		System.out.println("len:"+rst);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
