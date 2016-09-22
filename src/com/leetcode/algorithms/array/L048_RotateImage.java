package com.leetcode.algorithms.array;

public class L048_RotateImage {
	/**
	 * 48. Rotate Image
	 * 
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 * 
	 * Tags: Array
	 * 
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int h = n / 2;
		int w = (n + 1) / 2;
		int temp = 0;
		for(int i = 0; i < h;i++){
			for(int j = 0; j < w;j++){
//				matrix[i, j] = 移动到 > matrix[j, n - i - 1]
				
				temp = matrix[i][j];//temp=[1]
				matrix[i][j] = matrix[n - j - 1][i];//[1]=[4]
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];// [4]=[3]
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];// [3]=[2]
//				matrix[j][n - i - 1] = matrix[i][j];// [2]=[1]
				matrix[j][n - i - 1] = temp;// [2]=temp
			}
		}
	}

	public static void main(String[] args) {
		L048_RotateImage solution = new L048_RotateImage();
		int[][] mat4 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] mat3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] mat2 = { { 1, 2 }, { 3, 4 } };
		int[][] mat1 = { { 1 } };
		int[][] target = mat4;
		solution.rotate(target);
		for(int i = 0; i < target.length;i++){
			for(int j  =0; j < target[i].length;j++){
				System.out.print(target[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
