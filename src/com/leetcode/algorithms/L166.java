package com.leetcode.algorithms;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class L166 {

	/**
	 * Given two integers representing the numerator and denominator of a
	 * fraction, return the fraction in string format.
	 * 
	 * If the fractional part is repeating, enclose the repeating part in
	 * parentheses.
	 * 
	 * For example,
	 * 
	 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
	 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
	 * "0.(6)".
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		long numeratorLong = numerator;
		long denominatorLong = denominator;
		if (numeratorLong == 0)
			return "0";

		StringBuffer sb = new StringBuffer();

		boolean neg = false;

		if (numeratorLong < 0) {
			neg = !neg;
			numeratorLong = -numeratorLong;
		}
		if (denominatorLong < 0) {
			neg = !neg;
			denominatorLong = -denominatorLong;
		}

		if (neg)
			sb.append("-");

		LinkedHashSet<Long> set = new LinkedHashSet<Long>();
		LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();

		sb.append(numeratorLong / denominatorLong);
		int index = -1;
		numeratorLong %= denominatorLong;
		int i = 0;

		StringBuffer sb2 = new StringBuffer();
		while (numeratorLong != 0) {
			if (set.contains(numeratorLong)) {
				index = map.get(numeratorLong);
				break;
			} else {
				map.put(numeratorLong, i);
				set.add(numeratorLong);
				numeratorLong *= 10;
				sb2.append(numeratorLong / denominatorLong);
				numeratorLong %= denominatorLong;
			}
			i++;
		}
		if (sb2.length() > 0) {
			sb.append('.');
			if (index >= 0) {
				sb.append(sb2.substring(0, index));
				sb.append('(');
				sb.append(sb2.substring(index));
				sb.append(')');
			} else {
				sb.append(sb2);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		L166 solution = new L166();
		System.out.println(1.0/2147483647);
		System.out.println(-1.0/-2147483648);
		Object obj = solution.fractionToDecimal(-1, -2147483648);
		System.out.println(obj);
	}
}
