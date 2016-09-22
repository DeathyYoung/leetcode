package com.leetcode.algorithms.string;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L049_GroupAnagrams {
	/**
	 * 49. Group Anagrams
	 * <p>
	 * Total Accepted: 87641 Total Submissions: 298375 Difficulty: Medium
	 * <p>
	 * Given an array of strings, group anagrams together.
	 * 
	 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
	 * 
	 * <pre>
	  [
	   ["ate", "eat","tea"], 
	   ["nat","tan"], 
	   ["bat"] 
	  ]
	 * </pre>
	 * 
	 * Note: All inputs will be in lower-case.
	 * 
	 * 
	 * 
	 * Tags: Hash Table String
	 * 
	 * 
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new LinkedList<List<String>>();
		Map<String, List<String>> rst = new LinkedHashMap<String, List<String>>();
		if (strs == null)
			return list;
		for (String str : strs) {
			String hash = getHashCode(str);
			if (rst.get(hash) == null)
				rst.put(hash, new LinkedList<String>());
			rst.get(hash).add(str);
		}
		for (List<String> strList : rst.values()) {
			Collections.sort(strList);
			list.add(strList);
		}
		return list;

	}

	private String getHashCode(String str) {
		List<Character> list = new LinkedList<Character>();
		for (char c : str.toCharArray()) {
			list.add(c);
		}
		Collections.sort(list);
		StringBuffer sb = new StringBuffer();
		for (char c : list) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		L049_GroupAnagrams solution = new L049_GroupAnagrams();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
