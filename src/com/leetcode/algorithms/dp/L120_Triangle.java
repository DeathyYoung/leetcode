package com.leetcode.algorithms.dp;

import java.util.LinkedList;
import java.util.List;

public class L120_Triangle {
	/**
	 * 120. Triangle
	 * <p>
	 * Total Accepted: 78883 Total Submissions: 251884 Difficulty: Medium
	 * <p>
	 * Given a triangle, find the minimum path sum from top to bottom. Each step
	 * you may move to adjacent numbers on the row below.
	 * 
	 * <pre>
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	 * </pre>
	 * 
	 * Note: Bonus point if you are able to do this using only O(n) extra space,
	 * where n is the total number of rows in the triangle.
	 * 
	 * Tags: Array Dynamic Programming
	 * 
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int[] mins = new int[triangle.get(triangle.size() - 1).size()];
		for (int i = 0; i < mins.length; i++) {
			mins[i] = triangle.get(triangle.size() - 1).get(i);
		}
		for (int j = triangle.size() - 2; j >= 0; j--) {
			for (int i = 0; i < triangle.get(j).size(); i++) {
				mins[i] = triangle.get(j).get(i) + (mins[i] > mins[i + 1] ? mins[i + 1] : mins[i]);
			}
		}
		return mins[0];
	}

	public static void main(String[] args) {
		L120_Triangle solution = new L120_Triangle();
		
	}

}
