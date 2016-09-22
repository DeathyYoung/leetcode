package com.leetcode.algorithms.string;

public class L058_LengthOfLastWord {
	/**
	 * 58. Length of Last Word
	 * <p>
	 * Total Accepted: 106460 Total Submissions: 351954 Difficulty: Easy
	 * <p>
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 * 
	 * Tags: String
	 * 
	 */
	public int lengthOfLastWord(String s) {
		int len = 0;
		if (s == null)
			return len;
		int i = s.length() - 1;
		for (; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				break;
			}
		}
		for (; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			len++;
		}
		return len;
	}

	public static void main(String[] args) {
		L058_LengthOfLastWord solution = new L058_LengthOfLastWord();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
