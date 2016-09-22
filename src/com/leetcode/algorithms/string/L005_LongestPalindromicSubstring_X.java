package com.leetcode.algorithms.string;

public class L005_LongestPalindromicSubstring_X {
	/**
	 * 5. Longest Palindromic Substring
	 * <p>
	 * Total Accepted: 125677 Total Submissions: 528902 Difficulty: Medium
	 * <p>
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * Tags: String
	 * 
	 * <p>
	 * manacher O(n)复杂度，最长回文子串
	 */ 
	public String longestPalindrome(String s) {
		String preS = pre(s);

		int[] p = new int[preS.length()];
		int pi = 1;
		int mx = 1;
		int len = preS.length();
		p[0] = 1;

		for (int i = 1; i < len; i++) {
			if (mx > i) {
				int j = 2 * pi - i;
				p[i] = Math.min(mx - i, p[j]);
			} else {
				p[i] = 1;
			}
			while (i - p[i] >= 0 && i + p[i] < len
					&& preS.charAt(i - p[i]) == preS.charAt(i + p[i])) {// 找到当前位置i的最大回文半径
				p[i]++;
			}
			if (i + p[i] > mx) {
				mx = p[i] + i;
				pi = i;
			}
		}

		// 最大回文字符串长度
		int maxLen = 0;
		int maxIndex = 0;
		for (int i = 0; i < len; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				maxIndex = i;
			}
		}

		int start = (maxIndex - maxLen + 1) / 2;

		return s.substring(start, start + maxLen - 1);
	}

	public String pre(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			sb.append("】");
			sb.append(str.charAt(i));
		}
		sb.append("】");
		return sb.toString();
	}

	public static void main(String[] args) {
		L005_LongestPalindromicSubstring_X solution = new L005_LongestPalindromicSubstring_X();
		Object rst = solution.longestPalindrome("32121242121231231321");
		System.out.println(rst);
	}
}
