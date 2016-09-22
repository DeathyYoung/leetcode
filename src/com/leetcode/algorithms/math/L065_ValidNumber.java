package com.leetcode.algorithms.math;

public class L065_ValidNumber {
	/**
	 * 65. Valid Number
	 * <p>
	 * Total Accepted: 51257 Total Submissions: 415080 Difficulty: Hard
	 * <p>
	 * Validate if a given string is numeric.
	 * 
	 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
	 * "2e10" => true Note: It is intended for the problem statement to be
	 * ambiguous. You should gather all requirements up front before
	 * implementing one.
	 * <p>
	 * Tag: Math String
	 * 
	 */
	public boolean isNumber(String s) {
		String reg = " *[-+]?((\\d+(\\.\\d*)?)|(\\.\\d+))(e[-+]?\\d+)? *";
		return s.matches(reg);
	}

	public static void main(String[] args) {
		L065_ValidNumber solution = new L065_ValidNumber();
		String[] strs = { "0", "0.1", "+0.1", "abc", "1 a", "2e10", ".111", ".", "1.", "1.2e-0", "1.e-0", ".1e-0" };
		for (String str : strs) {
			try {
				Double.parseDouble(str);
				System.out.println(solution.isNumber(str) + ":true" + ":" + str);
			} catch (Exception e) {
				System.out.println(solution.isNumber(str) + ":false" + ":" + str);
			}
		}
	}

}
