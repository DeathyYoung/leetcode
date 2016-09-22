package com.leetcode.algorithms.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L018_4Sum_TLE {
	/**
	 * 18. 4Sum
	 * 
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: The solution set must not contain duplicate quadruplets.
	 * 
	 * 
	 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * 
	 * 
	 * A solution set is:
	 * 
	 * [
	 * 
	 * [-1, 0, 0, 1],
	 * 
	 * [-2, -1, 1, 2],
	 * 
	 * [-2, 0, 0, 2]
	 * 
	 * ]
	 * 
	 * Tags: Array Hash Table Two Pointers
	 * 
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
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
				Set<Integer> setK = new HashSet<Integer>();
				for (int k = j + 1; k < nums.length; k++) {
					if (setK.contains(numsList.get(k)))
						continue;
					setK.add(numsList.get(k));
					for (int l = k + 1; l < nums.length; l++) {
						if (numsList.get(i) + numsList.get(j) + numsList.get(k) + numsList.get(l) == target) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(numsList.get(i));
							list.add(numsList.get(j));
							list.add(numsList.get(k));
							list.add(numsList.get(l));
							rst.add(list);
							break;
						}
					}
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		L018_4Sum_TLE solution = new L018_4Sum_TLE();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		for (List<Integer> list : solution.fourSum(nums, -1)) {
			System.out.println(list);
		}
	}

}
