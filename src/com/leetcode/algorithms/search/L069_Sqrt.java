package com.leetcode.algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class L069_Sqrt {
	/**
	 * 
	 * 69. Sqrt(x)
	 * <p>
	 * Total Accepted: 106180 Total Submissions: 407967 Difficulty: Medium
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 * 
	 * Binary Search, Math
	 */
	public int mySqrt(int x) {
		if (x < 0)
			return -1;
		if (x == 0 || x == 1)
			return x;
		int root = 0;

		// root = (int)Math.sqrt(x);
		return mySqrt(x, 0, 46340);
	}

	private int mySqrt(int x, int min, int max) {
		int mid = (min + max) / 2;
		int midS = mid * mid;
		int midS2 = (mid + 1) * (mid + 1);
		if ((midS2 > x || midS2 < 0) && midS <= x && midS >= 0) {
			return mid;
		}
		if (midS > x || midS < 0) {
			return mySqrt(x, min, mid - 1);
		} else {
			return mySqrt(x, mid + 1, max);
		}
	}

	public static void main(String[] args) {
		L069_Sqrt solution = new L069_Sqrt();
		System.out.println(solution.mySqrt(Integer.MAX_VALUE));
		 int a = 0xb504;
		 System.out.println(a);
		 System.out.println(49151*49151);
		 System.out.println(Integer.MAX_VALUE);

		// for (int i = 0; i < 100; i++)
		// System.out.println("sqrt(" + i + "):" + solution.mySqrt(i));
	}
}
