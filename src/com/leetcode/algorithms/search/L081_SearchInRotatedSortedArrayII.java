package com.leetcode.algorithms.search;

public class L081_SearchInRotatedSortedArrayII {
	/**
	 * 81. Search in Rotated Sorted Array II
	 * <p>
	 * Total Accepted: 70013 Total Submissions: 216168 Difficulty: Medium
	 * <p>
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 * 
	 * Array, Binary Search
	 */
	public boolean search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	public boolean search(int[] nums, int target, int left, int right) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;// [0 1 2 3 4]=2,[0 1 2 3]=1
		int midValue = nums[mid];

		if (target == midValue) {
			return true;
		}

		if (left == mid) {
			return (target == nums[right]);
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
			} else if (nums[right] > midValue){// 后半段正常
				if (target <= nums[right] && target > midValue) {
					return search(nums, target, mid + 1, right);
				} else {
					return search(nums, target, left, mid - 1);
				}
			} else {
				boolean rst1 = search(nums, target, left, mid - 1);
				boolean rst2 = search(nums, target, mid + 1, right);
				return rst1 | rst2;
			}
		}
	}

	public static void main(String[] args) {
		L081_SearchInRotatedSortedArrayII solution = new L081_SearchInRotatedSortedArrayII();
		int[] nums = { 1, 1, 3, 1 };
		System.out.println(solution.search(nums, 3));
	}
}
