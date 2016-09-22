package com.leetcode.algorithms.search;

public class L074_SearchA2DMatrix {
	/**
	 * 74. Search a 2D Matrix
	 * <p>
	 * Total Accepted: 89516 Total Submissions: 257712 Difficulty: Medium
	 * <p>
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 * 
	 * 
	 * Array, Binary Search
	 * 
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private boolean searchMatrix(int[][] matrix, int target, int start0, int start1, int end0, int end1) {
		if (start0 > end0)
			return false;
		if (start0 == end0 && start1 > end1)
			return false;

		int[] mids = mid(start0, start1, end0, end1, matrix[0].length);
		int midValue = matrix[mids[0]][mids[1]];

		if (target == midValue) {
			return true;
		}

		if (target < midValue) {
			if (mids[1] == 0) {
				mids[0]--;
				mids[1] = matrix[0].length - 1;
			} else {
				mids[1]--;
			}
			return searchMatrix(matrix, target, start0, start1, mids[0], mids[1]);
		} else {
			if (mids[1] == matrix[0].length - 1) {
				mids[0]++;
				mids[1] = 0;
			} else {
				mids[1]++;
			}
			return searchMatrix(matrix, target, mids[0], mids[1], end0, end1);
		}
	}

	private int[] mid(int start0, int start1, int end0, int end1, int row) {
		int[] mid = new int[2];

		int midtemp = ((start0 + end0) * row + start1 + end1) >> 1;

		mid[0] = midtemp / row;
		mid[1] = midtemp % row;

		return mid;
	}

	public static void main(String[] args) {
		L074_SearchA2DMatrix solution = new L074_SearchA2DMatrix();
		int[][] matrix = { 
				{ -9, -7, -7, -7, -6, -6, -6, -4, -3, -1, 0 }, 
				{ 3, 5, 6, 8, 8, 10, 12, 14, 14, 16, 17 },
				{ 20, 22, 23, 23, 23, 23, 25, 25, 27, 28, 28 }, 
				{ 29, 31, 33, 33, 35, 37, 37, 39, 39, 41, 42 },
				{ 43, 45, 46, 48, 49, 50, 50, 51, 51, 53, 53 }, 
				{ 56, 57, 58, 58, 58, 58, 58, 60, 61, 62, 64 },
				{ 65, 67, 68, 70, 72, 74, 74, 76, 76, 76, 77 }, 
				{ 78, 79, 79, 80, 81, 82, 83, 85, 87, 89, 90 },
				{ 92, 94, 96, 98, 99, 100, 100, 102, 102, 103, 105 },
				{ 106, 106, 106, 108, 109, 111, 113, 115, 117, 119, 120 },
				{ 123, 124, 126, 128, 128, 130, 131, 131, 132, 132, 133 },
				{ 134, 136, 138, 140, 140, 142, 144, 145, 146, 148, 150 },
				{ 152, 153, 154, 156, 158, 159, 161, 163, 165, 166, 167 },
				{ 170, 171, 173, 173, 173, 173, 174, 175, 176, 178, 180 },
				{ 181, 182, 184, 186, 187, 189, 191, 193, 195, 196, 196 } };
		System.out.println(solution.searchMatrix(matrix, 10));
	}

}
