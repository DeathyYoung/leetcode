package com.leetcode.algorithms;

public class L151 {

	/**
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 */
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int size = 0;
		boolean space = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				if(!space){
					space = true;
					sb.insert(0, c);
					size=0;
				}
			} else {
				space=false;
				sb.insert(size++, c);
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		L151 solution = new L151();
		Object obj = solution.reverseWords("b   a");
		System.out.println(obj);
	}
}
