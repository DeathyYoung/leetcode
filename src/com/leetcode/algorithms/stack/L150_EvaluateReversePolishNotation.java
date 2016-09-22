package com.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * <p>
 * 
 * Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class L150_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		int rst = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (String t : tokens) {
			if (t.matches("[+\\-]?[0-9]+")) {
				stack.push(Integer.parseInt(t));
			} else {
				int second = stack.pop();
				int first = stack.pop();
				switch (t) {
				case "+":
					stack.push(first+second);
					break;
				case "-":
					stack.push(first-second);
					break;
				case "*":
					stack.push(first*second);
					break;
				case "/":
					stack.push(first/second);
					break;
				default:
					return 0;
				}
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		L150_EvaluateReversePolishNotation solution = new L150_EvaluateReversePolishNotation();
		String[] nums1 = { "2", "1", "+", "3", "*" };
		String[] nums2 = { "4", "13", "5", "/", "+" };
		int rst = solution.evalRPN(nums2);
		System.out.println(rst);
	}
}
