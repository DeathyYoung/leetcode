package com.leetcode.algorithms.search;

public class L035_SearchInsertPosition {
	/**
	 * 
	 * 35. Search Insert Position
	 * <p>
	 * Total Accepted: 117807 Total Submissions: 309431 Difficulty: Medium
	 * <p>
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
	 * [1,3,5,6], 0 → 0
	 * 
	 * Array, Binary Search
	 * 
	 */
	public int searchInsert(int[] nums, int target) {
		return searchInsert(nums, target, 0, nums.length - 1);
	}

	private int searchInsert(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		int midValue = nums[mid];
		if (midValue == target) {
			return mid;
		}
		if (target < midValue) {
			int index = searchInsert(nums, target, left, mid - 1);
			if (index == -1) {
				return mid;
			} else {
				return index;
			}
		} else {
			int index = searchInsert(nums, target, mid + 1, right);
			if (index == -1) {
				return mid + 1;
			} else {
				return index;
			}
		}
	}

	public static void main(String[] args) {
		L035_SearchInsertPosition solution = new L035_SearchInsertPosition();
		int[] nums1 = {2,2};
		System.out.println(solution.searchInsert(nums1, 2));
	}
}
