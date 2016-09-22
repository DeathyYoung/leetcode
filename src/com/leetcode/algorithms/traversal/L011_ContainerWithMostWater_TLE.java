package com.leetcode.algorithms.traversal;

public class L011_ContainerWithMostWater_TLE {
	/**
	 * 11. Container With Most Water
	 * 
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 * 
	 * Tags: Array Two Pointers
	 */
	public int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int area = 0;
		for (int i = 1; i < height.length; i++) {
			int tempHeight = 0;
			for (int j = 0; j < i; j++) {
				if (height[j] > tempHeight) {
					int tempC = (i - j) * Math.min(height[i], height[j]);
					area = area < tempC ? tempC : area;
					tempHeight = height[j];
				}
				if (tempHeight >= height[i])
					break;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		L011_ContainerWithMostWater_TLE solution = new L011_ContainerWithMostWater_TLE();
		int[] nums1 = { 2, 5, 6, 7, 8, 2, 1 };
		int[] nums2 = { 1, 3, 4 };
		System.out.println(solution.maxArea(nums1));
	}

}
