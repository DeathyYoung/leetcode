package com.leetcode.algorithms.string;

import java.util.Stack;

public class L071_SimplifyPath {
	/**
	 * 71. Simplify Path
	 * <p>
	 * Total Accepted: 59663 Total Submissions: 260290 Difficulty: Medium
	 * <p>
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * <pre>
	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	 * </pre>
	 * 
	 * Tags: Stack String
	 * 
	 */
	public String simplifyPath(String path) {
		String[] dirnames = path.split("/+");
		Stack<String> stack = new Stack<String>();
		for (int i = 1; i < dirnames.length; i++) {
			String name = dirnames[i];
			if (name.equals(".")) {
				continue;
			} else if (name.equals("..")) {
				if (!stack.empty()) {
					stack.pop();
				}
			} else {
				stack.push(name);
			}
		}
		if (stack.empty()) {
			return "/";
		}
		StringBuffer sb = new StringBuffer();
		while (!stack.empty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, '/');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		L071_SimplifyPath solution = new L071_SimplifyPath();
		System.out.println(solution.simplifyPath("/a/b/../c/../../d/../../e/f/g/h/../"));
	}

}
