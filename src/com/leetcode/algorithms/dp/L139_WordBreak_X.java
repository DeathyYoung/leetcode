package com.leetcode.algorithms.dp;

import java.util.Set;

public class L139_WordBreak_X {
	/**
	 * 139. Word Break
	 * <p>
	 * Total Accepted: 98830 Total Submissions: 373414 Difficulty: Medium
	 * <p>
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		int maxLen = 0;// 记录字典中最长的单词长度
		for (String str : wordDict)
			maxLen = Math.max(maxLen, str.length());

		for (int end = 1; end < s.length() + 1; end++) {
			// looks back
			for (int i = end - maxLen > 0 ? end - maxLen : 0; i < end; i++) {
				if (dp[i] && wordDict.contains(s.substring(i, end))) {
					dp[end] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		L139_WordBreak_X solution = new L139_WordBreak_X();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
