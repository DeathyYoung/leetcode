package com.leetcode.algorithms.traversal;

public class L073_SetMatrixZeroes_unclear {
	/**
	 * 73. Set Matrix Zeroes
	 * 
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * click to show follow up.
	 * 
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 * 
	 * Tags: Array
	 * 
	 * 空间要求是in place。
	 * 用矩阵第一行记录哪些列要被设定为0，
	 * 然后用一个变量记录第一行本身是否要被设定为0，
	 * 同理用另外一个变量记录第一列本身是否要被设定为0.
	 * 
	 */
	public void setZeroes(int[][] matrix) {
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		if (matrix.length == 0)
			return;
		for (int i = 0; i < matrix[0].length; ++i) {
			if (matrix[0][i] == 0) {
				firstRowHasZero = true;
				break;
			}
		}
		for (int i = 0; i < matrix.length; ++i) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 1; j < matrix[i].length; ++j) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 1; j < matrix[i].length; ++j) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRowHasZero) {
			for (int i = 0; i < matrix[0].length; ++i) {
				matrix[0][i] = 0;
			}
		}
		if (firstColHasZero) {
			for (int i = 0; i < matrix.length; ++i) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		L073_SetMatrixZeroes_unclear solution = new L073_SetMatrixZeroes_unclear();
		int[][] mat1 = { { 1, 2, 3, 0, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 0, 0, 5 }, { 1, 0, 3, 3, 5 },
				{ 1, 2, 3, 4, 5 }, };
		solution.setZeroes(mat1);
		for (int[] arr : mat1) {
			for (int i : arr) {
				System.out.print(i + "\t");
			}
			System.out.println('\n');
		}
	}

}
