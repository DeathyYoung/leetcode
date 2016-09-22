package com.leetcode.algorithms.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L078_Subsets {
	/**
	 * 78. Subsets
	 * <p>
	 * Total Accepted: 110757 Total Submissions: 329719 Difficulty: Medium
	 * <p>
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * 
	 * Note: The solution set must not contain duplicate subsets.
	 * 
	 * <pre>
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	 * </pre>
	 * 
	 * Tags: Array, Backtracking, Bit Manipulation
	 * 
	 * 
	 */
	public List<List<Integer>> subsets(int[] nums) {
		long max = 1;
		int t = nums.length;
		while (t > 0) {
			max <<= 1;
			t--;
		}
		List<List<Integer>> rst = new LinkedList<List<Integer>>();
			
		for(long i = 0; i < max;i++){
			long mask = 1;
			List<Integer> list = new ArrayList<Integer>();
			for(int offset = 0; offset < nums.length;offset++){
				if( (i & (mask << offset)) != 0){
					list.add(nums[offset]);
				}
			}
			rst.add(list);
		}
		
		return rst;
	}

	public static void main(String[] args) {
		L078_Subsets solution = new L078_Subsets();
		int[] nums = { 1, 2, 3, 4 };
		for(List l : solution.subsets(nums)){
			System.out.println(l);
		}
	}

}
