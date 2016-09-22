package com.leetcode.algorithms.backtracking;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L017_LetterCombinationsOfAPhoneNumber {
	/**
	 * 17. Letter Combinations of a Phone Number
	 * <p>
	 * Total Accepted: 93812 Total Submissions: 310015 Difficulty: Medium Given
	 * a digit string, return all possible letter combinations that the number
	 * could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"]. Note: Although the above answer is in lexicographical
	 * order, your answer could be in any order you want.
	 * 
	 * 
	 * Tags: Backtracking String
	 * 
	 */
	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		return letterCombinations(digits, 0);
	}

	public List<String> letterCombinations(String digits, int index) {
		List<String> list = new LinkedList<String>();
		if (index >= digits.length()) {
			list.add("");
			return list;
		}
		char[] chars = map.get(digits.charAt(index));
		List<String> subList = letterCombinations(digits, index + 1);
		StringBuffer sb = new StringBuffer();
		for (char c : chars) {
			for (String str : subList) {
				sb.setLength(0);
				sb.append(c);
				sb.append(str);
				list.add(sb.toString());
			}
		}
		sb = null;
		return list;
	}

	static Map<Character, char[]> map = new LinkedHashMap<Character, char[]>();

	static {
		map.put('1', new char[] {});
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
		map.put('*', new char[] { '+' });
		map.put('0', new char[] { ' ' });
		map.put('#', new char[] {});
	}

	public static void main(String[] args) {
		L017_LetterCombinationsOfAPhoneNumber solution = new L017_LetterCombinationsOfAPhoneNumber();
		List<String> list = solution.letterCombinations("23");
		for(String s : list){
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
