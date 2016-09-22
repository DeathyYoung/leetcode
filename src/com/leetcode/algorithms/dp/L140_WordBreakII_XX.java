package com.leetcode.algorithms.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class L140_WordBreakII_XX {
	/**
	 * 140. Word Break II
	 * <p>
	 * Total Accepted: 63613 Total Submissions: 305751 Difficulty: Hard
	 * <p>
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given s = "catsanddog", dict = ["cat", "cats", "and",
	 * "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 * 
	 * Tags: Dynamic Programming, Backtracking
	 * 
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		/*
		 * 3ms 99.91% Backtracking. Use a boolean array to prune branches.
		 * invalid[i]: s[i:end] can be breakable
		 * 
		 * Also record max length of all words to prune branches.
		 */
		List<String> res = new ArrayList<String>();
		for (String str : wordDict)
			maxLen = maxLen > str.length() ? maxLen : str.length();
		wordBreak(s, wordDict, new StringBuilder(), 0, new boolean[s.length()], res);
		return res;
	}

	private int maxLen = 0;

	private boolean wordBreak(String s, Set<String> wordDict, StringBuilder sb, int start, boolean[] invalid,
			List<String> res) {
		if (start == s.length()) { // reach the end
			res.add(sb.toString().trim());
			return true;
		}
		boolean breakable = false;
		int sbLen = sb.length(); // record current size
		int rightBound = Math.min(s.length(), start + maxLen);
		for (int end = start + 1; end <= rightBound; end++) { // exclusive
			if (end != s.length() && invalid[end])
				continue; // check if s[right:end] is breakable
			String word = s.substring(start, end);
			if (wordDict.contains(word)) {
				sb.append(" ");
				sb.append(word);
				breakable |= wordBreak(s, wordDict, sb, end, invalid, res);
				sb.setLength(sbLen);
			}
		}
		invalid[start] = !breakable;
		return breakable;
	}

	public static void main(String[] args) {
		L140_WordBreakII_XX solution = new L140_WordBreakII_XX();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
