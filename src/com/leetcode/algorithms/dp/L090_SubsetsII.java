package com.leetcode.algorithms.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L090_SubsetsII {
	/**
	 * 90. Subsets II
	 * <p>
	 * Total Accepted: 77287 Total Submissions: 241558 Difficulty: Medium
	 * <p>
	 * Given a collection of integers that might contain duplicates, nums,
	 * return all possible subsets.
	 * 
	 * Note: The solution set must not contain duplicate subsets.
	 * 
	 * <pre>
	For example,
	If nums = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
	 * </pre>
	 * 
	 * Tags: Array, Backtracking
	 * 
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> rst = new LinkedList<List<Integer>>();
		rst.add(new ArrayList<Integer>());

		for (int num : nums) {
			map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
		}

		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			int num = entry.getKey();
			int count = entry.getValue();
			int size = rst.size();
			List<Integer> next = new ArrayList<Integer>();
			for (int i = 1; i <= count; i++) {
				next.add(num);
				for (int s = 0; s < size; s++) {
					List<Integer> list = new ArrayList<Integer>();
					list.addAll(rst.get(s));
					list.addAll(next);
					rst.add(list);
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		L090_SubsetsII solution = new L090_SubsetsII();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
