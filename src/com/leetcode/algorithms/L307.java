package com.leetcode.algorithms;

class NumArray {

	private int[] tree;

	public NumArray(int[] nums) {
		this.tree = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			add(i + 1, nums[i]);
		}
	}

	void update(int i, int val) {
		int diff = val - read(i + 1);
		add(i + 1, diff);
	}

	public int sumRange(int i, int j) {
		return sumToK(j + 1) - sumToK(i);
	}

	void add(int k, int num) {// / 改
		while (k < tree.length) {
			tree[k] += num;
			k += k & -k;
		}
	}

	int read(int k) {
		return sumToK(k) - sumToK(k - 1);
	}

	int sumToK(int k)// 1~k的区间和
	{
		int sum = 0;
		while (k > 0) {
			sum += tree[k];
			k -= k & -k;
		}
		return sum;
	}
}

public class L307 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		int rst = 0;
		NumArray numArray = new NumArray(nums);
		rst = numArray.sumRange(0, 2);
		System.out.println(rst);
		numArray.update(1, 2);
		rst = numArray.sumRange(0, 2);
		System.out.println(rst);
		// for (int i : numArray.nums) {
		// System.out.println(i);
		// }
	}
}
