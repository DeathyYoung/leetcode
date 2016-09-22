package com.leetcode.algorithms.array;

public class L059_SpiralMatrixII {
	/**
	 * 59. Spiral Matrix II
	 * 
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix:
	 * 
	 * [
	 * 
	 * [ 1, 2, 3 ],
	 * 
	 * [ 8, 9, 4 ],
	 * 
	 * [ 7, 6, 5 ]
	 * 
	 * ]
	 * 
	 * Tags: Array
	 */
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int begin = 0;
		int right = 0;
		int bottom = 0;
		int num = 1;
		while (begin + begin < n) {

			// GET [begin][begin]
			matrix[begin][begin] = num++;

			// [begin][begin+1] - [begin][right]
			right = n - 1 - begin;
			for (int i = begin + 1; i <= right; i++) {
				matrix[begin][i] = num++;
			}

			// [begin+1][right] - [bottom][right]
			bottom = n - 1 - begin;
			for (int i = begin + 1; i <= bottom; i++) {
				matrix[i][right] = num++;
			}

			// [bottom][right-1] - [bottom][begin]
			if (bottom > begin)
				for (int i = right - 1; i >= begin; i--) {
					matrix[bottom][i] = num++;
				}
			// [bottom-1][begin] - [begin+1][begin]
			if (begin < right)
				for (int i = bottom - 1; i >= begin + 1; i--) {
					matrix[i][begin] = num++;
				}
			begin++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		L059_SpiralMatrixII solution = new L059_SpiralMatrixII();
		int[][] target = solution.generateMatrix(5);
		for(int i = 0; i < target.length;i++){
			for(int j  =0; j < target[i].length;j++){
				System.out.print(target[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
