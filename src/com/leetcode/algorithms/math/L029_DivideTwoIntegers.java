package com.leetcode.algorithms.math;

public class L029_DivideTwoIntegers {

	/**
	 * Divide Two Integers
	 * <p>
	 * Divide two integers without using multiplication, division and mod
	 * operator.
	 * 
	 * If it is overflow, return MAX_INT.
	 */
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == Integer.MIN_VALUE)
			return dividend == divisor ? 1 : 0;
		int rst = 0;
		boolean isNeg = false;
		if (divisor < 0) {
			divisor = -divisor;
			isNeg = !isNeg;
		}

		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 1 && isNeg) {
				return Integer.MAX_VALUE;
			}
			dividend += divisor;
			rst++;
		}
		if (dividend < 0) {
			dividend = -dividend;
			isNeg = !isNeg;
		}
		// /////////
		int tempDivisor = divisor;
		while (dividend >= tempDivisor) {
			int tempRst = 1;
			while (dividend >= tempDivisor && (tempDivisor & 0x40000000) == 0) {
				tempRst <<= 1;
				tempDivisor <<= 1;
			}
			if (dividend < tempDivisor) {
				tempRst >>= 1;
				tempDivisor >>= 1;
			}
			rst += tempRst;
			dividend -= tempDivisor;
			tempDivisor = divisor;
		}
		// /////////
		if (isNeg) {
			rst = -rst;
		}
		return rst;
	}

	public static void main(String[] args) {
		L029_DivideTwoIntegers solution = new L029_DivideTwoIntegers();
		System.out.println(solution.divide(2147483647, -1));
	}
}
