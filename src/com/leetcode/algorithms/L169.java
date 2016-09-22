package com.leetcode.algorithms;

import java.util.LinkedHashMap;

public class L169 {

	/**
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	public int majorityElement(int[] nums) {
		int size = nums.length / 2;
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.get(i) == null)
				map.put(i, 0);
			int count = map.get(i) + 1;
			if (count > size) {
				return i;
			}
			map.put(i, count);
		}
		return -1;
	}

	public static void main(String[] args) {
		L169 solution = new L169();
		int[] nums1 = { 0, 1, 0, 0,0, 3, 12 };
		int[] nums2 = { 0, 3, 12 };
		int num = solution.majorityElement(nums1);
		System.out.println(num);
	}
}
