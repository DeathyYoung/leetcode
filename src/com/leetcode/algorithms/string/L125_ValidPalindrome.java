package com.leetcode.algorithms.string;

public class L125_ValidPalindrome {
	/**
	 * 125. Valid Palindrome
	 * <p>
	 * Total Accepted: 115137 Total Submissions: 468675 Difficulty: Easy
	 * <p>
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * <pre>
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	 * </pre>
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 * 
	 * Tags: Two Pointers String
	 * 
	 * 
	 * 题目大意
	 * 
	 * 给定一个字符串，判断它是否是回文字符串，仅考虑字母，并且忽略大小写。
	 */
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && i < j) {
				i++;
			}
			while (!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j)) && i < j) {
				j--;
			}
			if ((s.charAt(i) & 0b11011111) != (s.charAt(j) & 0b11011111)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		L125_ValidPalindrome solution = new L125_ValidPalindrome();
		System.out.println(solution.isPalindrome("0P"));
	}

}
