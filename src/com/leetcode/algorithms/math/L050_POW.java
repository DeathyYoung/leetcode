package com.leetcode.algorithms.math;

public class L050_POW {
	/**
	 * 50. Pow(x, n)
	 * 
	 * Implement pow(x, n).
	 * 
	 * 
	 * Tags: Binary Search Math
	 * 
	 */
	public double myPow2(double x, int n) {
		return Math.pow(x, n);
	}
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 0)
			return 0;
		if(n==Integer.MIN_VALUE){
			double d = myPowPos(x, Integer.MAX_VALUE);
			return 1 / x / d;
		}
		if (n > 0)
			return myPowPos(x, n);
		else
			return 1 / myPowPos(x, -n);
	}

	private double myPowPos(double x, int n) {
		double rst = 1;

		double t = x;
		while (n > 0) {
			if ((n & 1) == 1) {
				rst *= t;
			}
			t *= t;
			n >>= 1;
		}

		return rst;
	}

	public static void main(String[] args) {
		L050_POW solution = new L050_POW();
		double x = -1;
		int n = -2147483648;
		System.out.println(Math.pow(x, n));
		System.out.println(solution.myPow(x, n));
	}

}
