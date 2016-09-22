package com.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class L349 {

	/**
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Note: Each element in the result must be unique. The result can be in any
	 * order.
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (int n : nums1) {
			set.add(n);
		}
		for (int n : nums2) {
			if (set.contains(n))
				set2.add(n);
		}
		int[] rst = new int[set2.size()];
		int count = 0;
		for (int n : set2) {
			rst[count++] = n;
		}
		return rst;
	}

	public static void main(String[] args) {
		L349 solution = new L349();
		int[] nums1 = { 0, 1, 0, 3, 12 };
		int[] nums2 = { 0, 3, 12 };
		int[] nums = solution.intersection(nums1, nums2);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}
}
