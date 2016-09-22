package com.leetcode.algorithms.array;

import java.util.LinkedList;
import java.util.List;

public class L054_SpiralMatrix {
	/**
	 * 54. Spiral Matrix
	 * 
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * 
	 * [
	 * 
	 * [ 1, 2, 3 ],
	 * 
	 * [ 4, 5, 6 ],
	 * 
	 * [ 7, 8, 9 ]
	 * 
	 * ]
	 * 
	 * You should return [1,2,3,6,9,8,7,4,5].
	 * 
	 * Tags: Array
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return list;
		int m = matrix.length;
		int n = matrix[0].length;
		int begin = 0;
		int right = 0;
		int bottom = 0;
		while (begin + begin < n && begin + begin < m) {

			// GET [begin][begin]
			list.add(matrix[begin][begin]);

			// [begin][begin+1] - [begin][right]
			right = n - 1 - begin;
			for (int i = begin + 1; i <= right; i++) {
				list.add(matrix[begin][i]);
			}

			// [begin+1][right] - [bottom][right]
			bottom = m - 1 - begin;
			for (int i = begin + 1; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}

			// [bottom][right-1] - [bottom][begin]
			if (bottom > begin)
				for (int i = right - 1; i >= begin; i--) {
					list.add(matrix[bottom][i]);
				}
			// [bottom-1][begin] - [begin+1][begin]
			if (begin < right)
				for (int i = bottom - 1; i >= begin + 1; i--) {
					list.add(matrix[i][begin]);
				}
			begin++;
		}
		return list;
	}

	public static void main(String[] args) {
		L054_SpiralMatrix solution = new L054_SpiralMatrix();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		int[][] mat = { 
				{  1,  2,  3,  4,  5,  6 }, 
				{  7,  8,  9, 10, 11, 12 }, 
				{ 13, 14, 15, 16, 17, 18 } };
		int[][] mat4 = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 } };
		int[][] mat3 = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 }, 
				{ 7, 8, 9 }, 
				{10,11,12 }, 
				{13,14,15 } };
		int[][] mat2 = { 
				{ 1, 2 }, 
				{ 3, 4 } };
		int[][] mat1 = { { 1 } };
		int[][] target = mat3;
		System.out.println(solution.spiralOrder(target));
	}

}
