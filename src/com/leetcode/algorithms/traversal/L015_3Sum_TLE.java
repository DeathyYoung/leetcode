package com.leetcode.algorithms.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L015_3Sum_TLE {
	/**
	 * 15. 3Sum
	 * 
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * 
	 * 
	 * A solution set is:
	 * 
	 * [
	 * 
	 * [-1, 0, 1],
	 * 
	 * [-1, -1, 2]
	 * 
	 * ]
	 * 
	 * 
	 * 
	 * Tags: Array Two Pointers
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<Integer> numsList = new ArrayList<Integer>();
		for (int i : nums) {
			numsList.add(i);
		}
		Collections.sort(numsList);
		System.out.println(numsList);

		List<List<Integer>> rst = new LinkedList<List<Integer>>();
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
					if (numsList.get(i) + numsList.get(j) + numsList.get(k) == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(numsList.get(i));
						list.add(numsList.get(j));
						list.add(numsList.get(k));
						rst.add(list);
						break;
					}
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		L015_3Sum_TLE solution = new L015_3Sum_TLE();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		for (List<Integer> list : solution.threeSum(nums)) {
			System.out.println(list);
		}
	}

}
