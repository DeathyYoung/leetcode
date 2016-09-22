package com.leetcode.algorithms.dp;

public class L087_ScrambleString_XX {
	/**
	 * 87. Scramble String
	 * <p>
	 * Total Accepted: 51311 Total Submissions: 187102 Difficulty: Hard
	 * <p>
	 * Given a string s1, we may represent it as a binary tree by partitioning
	 * it to two non-empty substrings recursively.
	 * 
	 * Below is one possible representation of s1 = "great":
	 * 
	 * <pre>
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	 * </pre>
	 * 
	 * To scramble the string, we may choose any non-leaf node and swap its two
	 * children.
	 * 
	 * For example, if we choose the node "gr" and swap its two children, it
	 * produces a scrambled string "rgeat".
	 * 
	 * <pre>
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	 * </pre>
	 * 
	 * We say that "rgeat" is a scrambled string of "great".
	 * 
	 * Similarly, if we continue to swap the children of nodes "eat" and "at",
	 * it produces a scrambled string "rgtae".
	 * 
	 * <pre>
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	 * </pre>
	 * 
	 * We say that "rgtae" is a scrambled string of "great".
	 * 
	 * Given two strings s1 and s2 of the same length, determine if s2 is a
	 * scrambled string of s1.
	 * 
	 * Tags: Dynamic Programming String
	 * 
	 */
	public boolean isScramble(String s1, String s2) {
		char[] v1 = s1.toCharArray();
		char[] v2 = s2.toCharArray();
		return isScramble(v1, 0, v1.length - 1, v2, 0, v2.length - 1);
	}

	private boolean isScramble(char[] v1, int start1, int end1, char[] v2, int start2, int end2) {
		int[] letters = new int[26];
		boolean isSame = true;
		for (int i = start1, j = start2; i <= end1; i++, j++) {
			letters[v1[i] - 'a']++;
			letters[v2[j] - 'a']--;
			isSame = isSame && v1[i] == v2[j];
		}
		if (isSame)
			return true;// 完全一致
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;// 字母数量不匹配
		for (int i = start1, j = start2; i < end1; i++, j++) {
			if (isScramble(v1, start1, i, v2, start2, j) && isScramble(v1, i + 1, end1, v2, j + 1, end2))
				return true;
			if (isScramble(v1, start1, i, v2, end2 - j + start2, end2)
					&& isScramble(v1, i + 1, end1, v2, start2, end2 - j + start2 - 1))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		L087_ScrambleString_XX solution = new L087_ScrambleString_XX();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
