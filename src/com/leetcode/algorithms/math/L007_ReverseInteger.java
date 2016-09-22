package com.leetcode.algorithms.math;

/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L007_ReverseInteger {

	/**
	 * 7. Reverse Integer
	 * 
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * click to show spoilers.
	 * 
	 * Have you thought about this? Here are some good questions to ask before
	 * coding. Bonus points for you if you have already thought through this!
	 * 
	 * If the integer's last digit is 0, what should the output be? ie, cases
	 * such as 10, 100.
	 * 
	 * Did you notice that the reversed integer might overflow? Assume the input
	 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
	 * you handle such cases?
	 * 
	 * For the purpose of this problem, assume that your function returns 0 when
	 * the reversed integer overflows.
	 */

	public int reverse(int x) {
		int rst = 0;
		while (x != 0) {
			int last = x % 10;
			if (rst > Integer.MAX_VALUE / 10 || rst == Integer.MAX_VALUE && (last > Integer.MAX_VALUE % 10)) {
				return 0;
			}
			if (rst < Integer.MIN_VALUE / 10 || rst == Integer.MIN_VALUE && (last < Integer.MIN_VALUE % 10)) {
				return 0;
			}
			rst *= 10;
			rst += last;
			x /= 10;
		}
		return rst;
	}

	public static void main(String[] args) {
		L007_ReverseInteger solution = new L007_ReverseInteger();
		Object rst = solution.reverse(1534236469);
		System.out.println(rst);
	}
}
