package com.leetcode.algorithms.graph;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class L127_WordLadder_XX {
	/**
	 * 127. Word Ladder
	 * <p>
	 * Total Accepted: 86310 Total Submissions: 438582 Difficulty: Medium
	 * <p>
	 * Given two words (beginWord and endWord), and a dictionary's word list,
	 * find the length of shortest transformation sequence from beginWord to
	 * endWord, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the word list For example,
	 * 
	 * Given:
	 * 
	 * <pre>
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	 * </pre>
	 * 
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
	 * "cog", return its length 5.
	 * 
	 * Note:
	 * <p>
	 * Return 0 if there is no such transformation sequence.
	 * <p>
	 * All words have the same length.
	 * <p>
	 * All words contain only lowercase alphabetic characters.
	 * 
	 */
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> start = new HashSet<String>();
		Set<String> end = new HashSet<String>();

		start.add(beginWord);
		end.add(endWord);
		return solve(start, end, wordList, 1);
	}

	public int solve(Set<String> start, Set<String> end, Set<String> wordList, int step) {
		if (start.isEmpty()) {
			return 0;
		}

		// 确保三重循环是循环的较小的那个集合，可以带来一定的优化
		if (start.size() > end.size()) {
			return solve(end, start, wordList, step);
		}

		// 将查询过的字符串从字符表中删除，这一步确保算法不做重复的工作，极大得改进了算法性能
		wordList.removeAll(start);

		Set<String> next = new HashSet<String>();
		for (String s : start) {
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				for (int j = 'a'; j <= 'z'; j++) {
					char t = chs[i];
					chs[i] = (char) j;
					String temp = new String(chs);
					if (end.contains(temp)) {
						return step + 1;
					}
					if (wordList.contains(temp)) {
						next.add(temp);
					}
					chs[i] = t;
				}
			}
		}
		return solve(next, end, wordList, step + 1);
	}

	public static void main(String[] args) {
		L127_WordLadder_XX solution = new L127_WordLadder_XX();
		String[] words = { "hot", "dot", "dog", "lot", "log" };
		Set<String> set = new LinkedHashSet<String>();
		for (String word : words) {
			set.add(word);
		}
		System.out.println(solution.ladderLength("hit", "cog", set));
	}

}
