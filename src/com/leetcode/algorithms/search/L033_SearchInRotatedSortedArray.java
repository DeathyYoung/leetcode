package com.leetcode.algorithms.search;

public class L033_SearchInRotatedSortedArray {
	/**
	 * 
	 * 33. Search in Rotated Sorted Array
	 * <p>
	 * My Submissions Total Accepted: 114614 Total Submissions: 370256
	 * Difficulty: Hard Suppose a sorted array is rotated at some pivot unknown
	 * to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 */
	public int search(int[] nums, int target) {

		return search(nums, target, 0, nums.length - 1);

	}

	public int search(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;// [0 1 2 3 4]=2,[0 1 2 3]=1
		int midValue = nums[mid];

		if (target == midValue) {
			return mid;
		}

		if (left == mid) {
			if (target == nums[right])
				return right;
			else
				return -1;
		}

		if (nums[left] < nums[right]) {
			// 正常序列递归
			if (midValue < target) {
				return search(nums, target, mid + 1, right);
			} else {
				return search(nums, target, left, mid - 1);
			}
		} else {
			// 不正常序列递归
			if (nums[left] < midValue) {// 前半段正常
				if (target >= nums[left] && target < midValue) {
					return search(nums, target, left, mid - 1);
				} else {
					return search(nums, target, mid + 1, right);
				}
			} else {// 后半段正常
				if (target <= nums[right] && target > midValue) {
					return search(nums, target, mid + 1, right);
				} else {
					return search(nums, target, left, mid - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		L033_SearchInRotatedSortedArray solution = new L033_SearchInRotatedSortedArray();
		int[] nums = { 3, 1 };
		System.out.println(solution.search(nums, 1));
	}
}
