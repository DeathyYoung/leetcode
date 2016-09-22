package com.leetcode.algorithms.stack;

public class L042_TrappingRainWater {
	/**
	 * <p>
	 * trapping-rain-water
	 * <p>
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 */
	public int trap(int[] height) {
		int rst = 0;
		int barH = 0;
		int l = 0;
		int r = height.length - 1;

		while (l < r) {
			if (height[l] < height[r]) {
				barH = height[l];
				while (l < r && height[l] <= barH) {
					rst += barH - height[l];
					l++;
				}
			} else {
				barH = height[r];
				while (l < r && height[r] <= barH) {
					rst += barH - height[r];
					r--;
				}
			}
		}

		return rst;
	}

	public static void main(String[] args) {
		L042_TrappingRainWater solution = new L042_TrappingRainWater();
		int[] nums1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int rst = solution.trap(nums1);
		System.out.println(rst);
	}
}
