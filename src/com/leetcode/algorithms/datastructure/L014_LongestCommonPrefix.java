 package com.leetcode.algorithms.datastructure;

public class L014_LongestCommonPrefix {

	/**
	 * Longest Common Prefix
	 * 
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		StringBuilder sb = new StringBuilder();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (min > strs[i].length())
				min = strs[i].length();
		}
		for (int i = 0; i < min; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[0].charAt(i) != strs[j].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(strs[0].charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		L014_LongestCommonPrefix solution = new L014_LongestCommonPrefix();
		String[] strs = {"abc", "ab"};
		Object rst = solution.longestCommonPrefix(strs);
		System.out.println(rst);
	}
}
