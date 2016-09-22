package com.leetcode.algorithms.stack;

import java.util.LinkedList;

public class L032_LongestValidParentheses_X {
	/**
	 * Longest Valid Parentheses
	 * <p>
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
	public int longestValidParentheses(String s) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int result = 0;
		stack.push(-1);// 哨兵
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
				stack.pop();
				result = Math.max(result, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		L032_LongestValidParentheses_X solution = new L032_LongestValidParentheses_X();
		String s = "(((((((((()(((((((((()((((())))";
		int rst = solution.longestValidParentheses(s);
		System.out.println(rst);
	}
}
