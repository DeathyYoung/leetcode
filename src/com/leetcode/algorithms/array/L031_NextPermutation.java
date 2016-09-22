package com.leetcode.algorithms.array;

public class L031_NextPermutation {
	/**
	 * 31. Next Permutation
	 * <p>
	 * Total Accepted: 75877 Total Submissions: 277629 Difficulty: Medium
	 * <p>
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
	 * 1,2,3 1,1,5 → 1,5,1
	 * 
	 * Tags: Array
	 * 
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int l = nums.length - 2;
		int r = nums.length - 1;

		while (l >= 0 && nums[l] >= nums[r]) {// 找到最后一个升序对(a, b)，可能找不到
			l--;
			r--;
		}

		if (l == -1) {// 没找到升序对，整个数组逆序
			int mid = nums.length / 2;
			for (int i = 0; i < mid; i++) {
				r = nums.length - i - 1;
				nums[i] ^= nums[r];
				nums[r] ^= nums[i];
				nums[i] ^= nums[r];
			}
			return;
		}

		while (r + 1 < nums.length && nums[l] < nums[r + 1]) {// 找到比a大的最后一个数，下标是r
			r++;
		}

		// 交换
		nums[l] ^= nums[r];
		nums[r] ^= nums[l];
		nums[l] ^= nums[r];

		// l 后面的逆序
		int mid = (l + nums.length + 1) / 2;
		for (int i = l + 1; i < mid; i++) {
			r = l + nums.length - i;
			nums[i] ^= nums[r];
			nums[r] ^= nums[i];
			nums[i] ^= nums[r];
		}
	}

	public static void main(String[] args) {
		L031_NextPermutation solution = new L031_NextPermutation();
		int[] nums1 = { 1, 2, 3, 4, 5 };

		for (int j = 0; j < 121; j++) {
			for (int i : nums1) {
				System.out.print(i + "\t");
			}
			System.out.println();
			solution.nextPermutation(nums1);
		}

	}

}
