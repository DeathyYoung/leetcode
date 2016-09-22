package com.leetcode.algorithms.math;

import java.util.ArrayList;
import java.util.List;

public class L119_PascalTriangleII {
	/**
	 * 
	 * 119. Pascal's Triangle II
	 * 
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * 
	 * 
	 * Tags: Array
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			list.add(1);
			for (int j = i - 1; j > 0; j--) {
				list.set(j, list.get(j) + list.get(j - 1));
			}
		}
		return list;
	}

	public List<Integer> getRow2(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			list.add(C(rowIndex, i));
		}
		return list;
	}
	
	private static int C(int n, int m) {
		int rst = 1;
		if(m + m > n){
			m = n - m;
		}
		for (int i = n - m + 1; i <= n; i++) {
			rst *= i;
		}
		for(int i = 1; i <= m;i++){
			rst /= i;
		}
		return rst;
	}

	public static void main(String[] args) {
		L119_PascalTriangleII solution = new L119_PascalTriangleII();
//		System.out.println(solution.getRow(18));
//		System.out.println(solution.getRow2(18));
		System.out.println(solution.C(18, 9));
	}

}
