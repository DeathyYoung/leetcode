package com.leetcode.algorithms.search;

public class L034_SearchForARange {
	/**
	 * 34. Search for a Range
	 * <p>
	 * Total Accepted: 94789 Total Submissions: 316768 Difficulty: Medium Given
	 * <p>
	 * a sorted array of integers, find the starting and ending position of a
	 * given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 * 
	 * Array, Binary Search
	 */
	public int[] searchRange(int[] nums, int target) {
		return searchBinaryTarget(nums, target, 0, nums.length - 1);
	}

	public int[] searchBinaryTarget(int[] nums, int target, int left, int right) {
		int[] rst = { -1, -1 };
		if (left > right) {
			return rst;
		}

		int mid = (left + right) / 2;
		int midValue = nums[mid];

		if (midValue == target) {
			rst[0] = searchBinaryLeftBound(nums, target, left, mid);
			rst[1] = searchBinaryRightBound(nums, target, mid, right);
			return rst;
		} else if (midValue > target) {
			return searchBinaryTarget(nums, target, left, mid - 1);
		} else {
			return searchBinaryTarget(nums, target, mid + 1, right);
		}
	}

	public int searchBinaryLeftBound(int[] nums, int target, int left, int right) {
		if (left == right)
			return left;
		int mid = (left + right) / 2;
		int midValue = nums[mid];

		if (midValue == target) {
			return searchBinaryLeftBound(nums, target, left, mid);
		} else {
			return searchBinaryLeftBound(nums, target, mid + 1, right);
		}
	}

	public int searchBinaryRightBound(int[] nums, int target, int left, int right) {
		if (left == right)
			return right;
		int mid = (left + right + 1) / 2;
		int midValue = nums[mid];

		if (midValue == target) {
			return searchBinaryRightBound(nums, target, mid, right);
		} else {
			return searchBinaryRightBound(nums, target, left, mid - 1);
		}
	}

	public static void main(String[] args) {
		L034_SearchForARange solution = new L034_SearchForARange();
		int[] nums1 = { 2, 2 };
		int[] nums2 = { 5, 7, 7, 8, 8, 10 };
		int[] rst = solution.searchRange(nums1, 2);
		System.out.println(rst[0]);
		System.out.println(rst[1]);
	}
}
