package com.leetcode.algorithms.datastructure;

import java.util.List;

public class L030_SubstringWithConcatenationOfAllWords {

	/**
	 * 30. Substring with Concatenation of All Words
	 * 
	 * 
	 * You are given a string, s, and a list of words, words, that are all of
	 * the same length. Find all starting indices of substring(s) in s that is a
	 * concatenation of each word in words exactly once and without any
	 * intervening characters.
	 * 
	 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 * <p>
	 * Tags:
	 * <p>
	 * Hash Table Two Pointers String
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		double rst = 0;

		return null;
	}

	public static void main(String[] args) {
		L030_SubstringWithConcatenationOfAllWords solution = new L030_SubstringWithConcatenationOfAllWords();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		Object rst = solution.findSubstring("", null);
		System.out.println(rst);
	}
}
