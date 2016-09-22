package com.leetcode.algorithms.math;

public class L012_IntegerToRoman {
	/**
	 * 12. Integer to Roman
	 * <p>
	 * Total Accepted: 73270 Total Submissions: 179874 Difficulty: Medium
	 * <p>
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * <p>
	 * Tags Math String 
	 * 
	 */
	public String intToRoman(int num) {
		String[][] roman = {  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  
            {"", "M", "MM", "MMM"}  
        };

		StringBuffer sb = new StringBuffer();
		int digit = 0;
		while (num != 0) {
			int remain = num % 10;
			sb.insert(0, roman[digit][remain]);
			digit++;
			num /= 10;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		L012_IntegerToRoman solution = new L012_IntegerToRoman();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
