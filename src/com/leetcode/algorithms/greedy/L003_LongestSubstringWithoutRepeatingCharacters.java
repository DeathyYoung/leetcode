package com.leetcode.algorithms.greedy;

import java.util.HashSet;
import java.util.Set;

public class L003_LongestSubstringWithoutRepeatingCharacters {
	/**
	 * 3. Longest Substring Without Repeating Characters
	 * <p>
	 * Total Accepted: 176336 Total Submissions: 768026 Difficulty: Medium Given
	 * a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * Examples:
	 * 
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * 
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
	 * answer must be a substring, "pwke" is a subsequence and not a substring.
	 * 
	 * 
	 * 
	 * Tags: Hash Table Two Pointers String
	 * 
	 * 
	 */
	public int lengthOfLongestSubstring(String s) {
		Set<Character> cset = new HashSet<Character>();
		int l = 0;
		int len = 0;
		int i = 0;
		for (; i < s.length(); i++) {
			if (cset.contains(s.charAt(i))) {// repeat
				//get length
				int t = i - l;
				len = t > len ? t : len;
				//remove unuse char
				for (; l < i; l++) {
					if (s.charAt(l) == s.charAt(i)){
						l++;
						break;
					}
					cset.remove(s.charAt(l));
				}
			} else {
				cset.add(s.charAt(i));
			}
		}
		int t = i - l;
		len = t > len ? t : len;
		return len;
	}

	public static void main(String[] args) {
		L003_LongestSubstringWithoutRepeatingCharacters solution = new L003_LongestSubstringWithoutRepeatingCharacters();
		System.out.println(solution.lengthOfLongestSubstring(""));
	}

}
