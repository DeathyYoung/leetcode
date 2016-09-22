package com.leetcode.algorithms.stack;

import java.util.Stack;

public class L020_ValidParentheses {

	/**
	 * <p>
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.size() == 0) {
				stack.push(c);
			} else if (check(stack.peek(), c)) {
				stack.pop();
			} else {
				if (c == ')' || c == ']' || c == '}')
					return false;
				stack.push(c);
			}
		}
		return stack.size() == 0;
	}

	public boolean check(char a, char b) {
		if (a == '(' && b == ')') {
			return true;
		}
		if (a == '[' && b == ']') {
			return true;
		}
		if (a == '{' && b == '}') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		L020_ValidParentheses solution = new L020_ValidParentheses();
		Object rst = solution.isValid("[][][]{}{}{([])()}");
		System.out.println(rst);
	}
}
