package com.leetcode.algorithms.string;

public class L044_X {
	/**
	 * 44. Wildcard Matching
	 * <p>
	 * Total Accepted: 65666 Total Submissions: 361572 Difficulty: Hard
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*")
	 * → true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
	 * 
	 * 
	 * Tags: Dynamic Programming Backtracking Greedy String
	 * 
	 * 
	 */
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*')
				count++;
		}
		if (count == 0 && m != n)
			return false;
		else if (n - count > m)
			return false;

		boolean[] match = new boolean[m + 1];
		match[0] = true;
		for (int i = 0; i < m; i++) {
			match[i + 1] = false;
		}
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*') {
				for (int j = 0; j < m; j++) {
					match[j + 1] = match[j] || match[j + 1];
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
				}
				match[0] = false;
			}
		}
		return match[m];
	}

	public static void main(String[] args) {
		L044_X solution = new L044_X();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
