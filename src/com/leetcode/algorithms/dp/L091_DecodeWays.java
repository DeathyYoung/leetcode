package com.leetcode.algorithms.dp;

/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L091_DecodeWays {

	/**
	 * 91. Decode Ways
	 * <p>
	 * Total Accepted: 80382 Total Submissions: 444264 Difficulty: Medium
	 * <p>
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 * 
	 * Tags: Dynamic Programming String
	 * 
	 */
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;

		int[] rst = new int[s.length()];

		rst[0] = 1;
		if (s.length() > 1) {
			if (s.charAt(1) != '0' && (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) < '7'))) {
				rst[1] = 2;
			} else if (s.charAt(0) > '2' && s.charAt(1) == '0') {
				return 0;
			} else {
				rst[1] = 1;
			}
		}

		for (int i = 2; i < rst.length; i++) {
			int t = 0;
			char a = s.charAt(i - 1);
			char b = s.charAt(i);
			if (b == '0' && (a == '0' || a > '2')) {
				return 0;
			}
			if (b > '0' && b <= '9') {
				t += rst[i - 1];
			}
			if (a == '1' || (a == '2' && b < '7')) {
				t += rst[i - 2];
			}
			rst[i] = t;
		}

		return rst[rst.length - 1];
	}

	public static void main(String[] args) {
		L091_DecodeWays solution = new L091_DecodeWays();
		Object rst = solution.numDecodings("301");
		System.out.println(rst);
	}
}
