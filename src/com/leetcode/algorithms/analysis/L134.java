package com.leetcode.algorithms.analysis;

public class L134 {
	/**
	 * 134. Gas Station
	 * <p>
	 * Total Accepted: 67614 Total Submissions: 241856 Difficulty: Medium
	 * <p>
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 * 
	 * Tags: Greedy
	 * 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			gas[i] -= cost[i];
		}
		
	}

	public static void main(String[] args) {
		L134 solution = new L134();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
