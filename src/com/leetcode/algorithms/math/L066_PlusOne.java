package com.leetcode.algorithms.math;

public class L066_PlusOne {
	/**
	 * 
	 * 66. Plus One
	 * 
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 * 
	 * 
	 * 
	 * Tags: Array Math
	 * 
	 */
	public int[] plusOne(int[] digits) {
		boolean flag = false;
		digits[digits.length - 1]++;
		if (digits[digits.length - 1] == 10)
			flag = true;
		for (int i = digits.length - 1; i > 0; i--) {
			if (flag) {
				digits[i] = 0;
				digits[i - 1]++;
				flag = digits[i - 1] == 10;
			} else {
				break;
			}
		}
		if (flag) {
			int[] newDigits = new int[digits.length + 1];
			digits[0] = 0;
			newDigits[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				newDigits[i + 1] = digits[i];
			}
			return newDigits;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		L066_PlusOne solution = new L066_PlusOne();
		int[] nums1 = { 9,9 };
		int[] nums2 = solution.plusOne(nums1);
		for(int i : nums2){
			System.out.println(i);
		}
	}

}
