package com.leetcode.algorithms.dp;

public class L115_DistinctSubsequences {
	/**
	 * 115. Distinct Subsequences
	 * <p>
	 * Total Accepted: 56416 Total Submissions: 189759 Difficulty: Hard
	 * <p>
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit"
	 * 
	 * Return 3.
	 * 
	 * Tags: Dynamic Programming String
	 * 
	 * 从S中删去一些char得到T，求一共有几种删去方法
	 */
	public int numDistinct(String s, String t) {
		if (t.length() == 0 || s.length() == 0)
			return 0;
		int[][] rst = new int[t.length()][s.length()];
		int i = 0, j = 0;
		int c = 0;
		for (; j < s.length(); j++) {
			rst[i][j] = s.charAt(j) == t.charAt(i) ? ++c : c;
		}
		for (i++; i < t.length(); i++) {
			for (j = i; j < s.length(); j++) {
				rst[i][j] = s.charAt(j) == t.charAt(i) ? rst[i][j - 1] + rst[i - 1][j - 1] : rst[i][j - 1];
			}
		}
		return rst[t.length() - 1][s.length() - 1];
	}

	public static void main(String[] args) {
		L115_DistinctSubsequences solution = new L115_DistinctSubsequences();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
