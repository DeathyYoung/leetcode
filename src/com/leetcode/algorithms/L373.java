package com.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

public class L373 {

	/**
	 * You are given two integer arrays nums1 and nums2 sorted in ascending
	 * order and an integer k.
	 * 
	 * Define a pair (u,v) which consists of one element from the first array
	 * and one element from the second array.
	 * 
	 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
	 * 
	 * Example 1:
	 * 
	 * Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3
	 * 
	 * Return: [1,2],[1,4],[1,6]
	 * 
	 * The first 3 pairs are returned from the sequence:
	 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	 * 
	 * Example 2:
	 * 
	 * Given nums1 = [1,1,2], nums2 = [1,2,3], k = 2
	 * 
	 * Return: [1,1],[1,1]
	 * 
	 * The first 2 pairs are returned from the sequence:
	 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	 * 
	 * Example 3:
	 * 
	 * Given nums1 = [1,2], nums2 = [3], k = 3
	 * 
	 * Return: [1,3],[2,3]
	 * 
	 * All possible pairs are returned from the sequence: [1,3],[2,3]
	 */
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> list = new LinkedList<int[]>();

		int[] indexes = new int[nums1.length];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = 0;
		}

		int bound = nums1.length * nums2.length;
		bound = bound > k ? k : bound;
		for (int i = 0; i < bound; i++) {
			long min = Long.MAX_VALUE;
			int x = -1;
			for (int j = 0; j < indexes.length; j++) {
				if (indexes[j] < nums2.length
						&& (long) nums1[j] + (long) nums2[indexes[j]] < min) {
					min = (long) nums1[j] + (long) nums2[indexes[j]];
					x = j;
				}
			}
			list.add(new int[] { nums1[x], nums2[indexes[x]] });
			indexes[x]++;
		}

		return list;
	}

	public static void main(String[] args) {
		L373 solution = new L373();
		int[] nums1 = { 0, 1, 0, 3, 12 };
		int[] nums2 = { 0, 3, 12 };

	}
}
