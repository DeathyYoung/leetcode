package com.leetcode.algorithms.array;

public class L088_MergeSortedArray {
	/**
	 * 88. Merge Sorted Array
	 * 
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
	 * as one sorted array.
	 * 
	 * Note: You may assume that nums1 has enough space (size that is greater or
	 * equal to m + n) to hold additional elements from nums2. The number of
	 * elements initialized in nums1 and nums2 are m and n respectively.
	 * 
	 * Tags: Array Two Pointers
	 * 
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len = m + n;
		m--;
		n--;
		for (int i = len - 1; i >= 0; i--) {
			if (m >= 0 && n >= 0) {
				if (nums1[m] <= nums2[n]) {
					nums1[i] = nums2[n--];
				} else {
					nums1[i] = nums1[m--];
				}
			} else if (n >= 0) {
				nums1[i] = nums2[n--];
			}
		}
	}

	public static void main(String[] args) {
		L088_MergeSortedArray solution = new L088_MergeSortedArray();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10, 0, 0, 0 };
		int[] nums2 = { 1, 3, 4 };
		solution.merge(nums1, 7, nums2, 3);
		for (int i : nums1) {
			System.out.println(i);
		}
	}

}
