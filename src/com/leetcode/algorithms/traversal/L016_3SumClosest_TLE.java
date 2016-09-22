package com.leetcode.algorithms.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L016_3SumClosest_TLE {
	/**
	 * 16. 3Sum Closest
	 * 
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * 
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * 
	 * 
	 * 
	 * Tags: Array Two Pointers
	 */
	public int threeSumClosest(int[] nums, int target) {

		List<Integer> numsList = new ArrayList<Integer>();

		int rst = 0;
		long distance = Long.MAX_VALUE;

		for (int i : nums) {
			numsList.add(i);
		}
		Collections.sort(numsList);
		System.out.println(numsList);

		Set<Integer> setI = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (setI.contains(numsList.get(i)))
				continue;
			setI.add(numsList.get(i));
			Set<Integer> setJ = new HashSet<Integer>();
			for (int j = i + 1; j < nums.length; j++) {
				if (setJ.contains(numsList.get(j)))
					continue;
				setJ.add(numsList.get(j));
				for (int k = j + 1; k < nums.length; k++) {
					int sum = numsList.get(i) + numsList.get(j) + numsList.get(k);
					long tempD = Math.abs((long) sum - target);
					if (tempD < distance) {
						rst = sum;
						distance = tempD;
					}
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		L016_3SumClosest_TLE solution = new L016_3SumClosest_TLE();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
