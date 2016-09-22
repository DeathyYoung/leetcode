package com.leetcode.algorithms.string;

public class L043_MultiplyStrings_X {
	/**
	 * 43. Multiply Strings
	 * <p>
	 * Total Accepted: 71015 Total Submissions: 288496 Difficulty: Medium
	 * <p>
	 * Given two numbers represented as strings, return multiplication of the
	 * numbers as a string.
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 * Converting the input string to integer is NOT allowed. You should NOT use
	 * internal library such as BigInteger.
	 * 
	 * 
	 * Tags: Math String
	 * 
	 * 
	 */
	public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

	public static void main(String[] args) {
		L043_MultiplyStrings_X solution = new L043_MultiplyStrings_X();
		System.out.println(Math.sqrt(Long.MAX_VALUE));
		long a = 3037000499L;
		System.out.println(Long.MAX_VALUE);
		System.out.println(a * a);
		System.out.println(solution.multiply("5423396", "5424012638"));
		System.out.println(solution.multiply("0", "0"));
	}

}
