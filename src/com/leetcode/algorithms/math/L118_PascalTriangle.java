package com.leetcode.algorithms.math;

import java.util.LinkedList;
import java.util.List;

public class L118_PascalTriangle {
	/**
	 * 
	 * 118. Pascal's Triangle
	 * 
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * 
	 * [
	 * 
	 * [1],
	 * 
	 * [1,1],
	 * 
	 * [1,2,1],
	 * 
	 * [1,3,3,1],
	 * 
	 * [1,4,6,4,1]
	 * 
	 * ]
	 * 
	 * 
	 * 
	 * Tags: Array
	 * 
	 * 
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (numRows == 0)
			return list;
		List<Integer> row = new LinkedList<Integer>();
		row.add(1);
		list.add(row);
		for (int i = 1; i < numRows; i++) {
			row = new LinkedList<Integer>();
			row.add(1);
			int mid = i / 2;
			List<Integer> pre = list.get(list.size() - 1);
			for (int j = 1; j <= mid; j++) {
				row.add(pre.get(j) + pre.get(j - 1));
			}

			int start = i / 2 + 1;

			for (int j = start; j <= i; j++) {
				row.add(row.get(i - j));
			}
			list.add(row);
		}
		return list;
	}

	public static void main(String[] args) {
		L118_PascalTriangle solution = new L118_PascalTriangle();
		List<List<Integer>> nums = solution.generate(5);
		for(List<Integer> l : nums){
			System.out.println(l);
		}
	}

}
