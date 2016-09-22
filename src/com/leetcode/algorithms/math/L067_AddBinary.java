package com.leetcode.algorithms.math;

public class L067_AddBinary {
	/**
	 * 
	 * 67. Add Binary
	 * 
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 * 
	 * 
	 * 
	 * Tags: Math String
	 * 
	 */
	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int a1 = a.length() - 1;
		int b1 = b.length() - 1;
		int more = 0;
		for (; a1 >= 0 && b1 >= 0; a1--, b1--) {
			int bit = a.charAt(a1) + b.charAt(b1) - '0' - '0' + more;
			if (bit > 1) {
				bit -= 2;
				more = 1;
			} else {
				more = 0;
			}
			sb.insert(0, bit);
		}
		if (a1 < 0) {
			a = b;
			a1 = b1;
		}

		if (a1 < 0) {
			if (more == 1) {
				sb.insert(0, 1);
			}
		} else {
			for (; a1 >= 0; a1--) {
				int bit = a.charAt(a1) - '0' + more;
				if (bit > 1) {
					bit -= 2;
					more = 1;
				} else {
					more = 0;
				}
				sb.insert(0, bit);
			}
			if (more == 1) {
				sb.insert(0, 1);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		L067_AddBinary solution = new L067_AddBinary();
		System.out.println(solution.addBinary("1101", "01111111110"));
	}

}
