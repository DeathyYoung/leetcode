package com.leetcode.algorithms.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L060_PermutationSequence_TLE {
	/**
	 * 60. Permutation Sequence
	 * 
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * <p>
	 * 1. "123"
	 * <p>
	 * 2. "132"
	 * <p>
	 * 3. "213"
	 * <p>
	 * 4. "231"
	 * <p>
	 * 5. "312"
	 * <p>
	 * 6. "321"
	 * <p>
	 * Given n and k, return the kth permutation sequence.
	 * 
	 * Note: Given n will be between 1 and 9 inclusive.
	 * 
	 * Tags: Backtracking Math
	 */
	public String getPermutation(int n, int k) {
		int[] rest = new int[n];
		for (int i = 0; i < rest.length; i++) {
			rest[i] = i + 1;
		}
		List<Integer> rst = getPermutationList(n, k - 1, rest);
		StringBuffer sb = new StringBuffer();
		for (int num : rst) {
			sb.insert(0, num);
		}
		return sb.toString();
	}

	private List<Integer> getPermutationList(int n, int k, int[] rest) {
		if (n == 0)
			return new LinkedList<Integer>();
		int team = k / factorials[n - 1];// 使用这个数组超时
		int thisNum = rest[team];
		for (int i = team; i < n - 1; i++) {
			rest[i] = rest[i + 1];
		}
		List<Integer> list = getPermutationList(n - 1, k % factorials[n - 1], rest);
		list.add(thisNum);
		return list;
	}

	public static final int[] factorials = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320 };
	
	public String getPermutationAC(int n, int k) {
		k--;// to transfer it as begin from 0 rather than 1
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			numList.add(i);

		int factorial = 1;
		for (int i = 2; i < n; i++)
			factorial *= i;

		StringBuilder res = new StringBuilder();
		int times = n - 1;
		while (times >= 0) {
			int indexInList = k / factorial;
			res.append(numList.get(indexInList));
			numList.remove(indexInList);

			k = k % factorial;// new k for next turn
			if (times != 0)
				factorial = factorial / times;// new (n-1)!

			times--;
		}

		return res.toString();
	}

	public static void main(String[] args) {
		L060_PermutationSequence_TLE solution = new L060_PermutationSequence_TLE();
		int x = 1;
		System.out.println(solution.getPermutation(8, 8590));
	}

}
