package com.leetcode.algorithms.math;

/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L009_PalindromeNumber {

	/**
	 * <p>
	 * 9. Palindrome Number
	 * 
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 * 
	 * Some hints: Could negative integers be palindromes? (ie, -1)
	 * 
	 * If you are thinking of converting the integer to string, note the
	 * restriction of using extra space.
	 * 
	 * You could also try reversing an integer. However, if you have solved the
	 * problem "Reverse Integer", you know that the reversed integer might
	 * overflow. How would you handle such case?
	 * 
	 * There is a more generic way of solving this problem.
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int y = 0;
		int z = x;
		while (z != 0) {
			y = y * 10 + z % 10;
			z /= 10;
		}
		return x == y;
	}

	public static void main(String[] args) {
		L009_PalindromeNumber solution = new L009_PalindromeNumber();
		Object rst = solution.isPalindrome(1234321);
		System.out.println(rst);
	}
}
