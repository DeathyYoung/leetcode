package com.leetcode.algorithms.datastructure;

/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L008_ATOI_X {

	/**
	 * <p>
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 * 
	 * Update (2015-02-10): The signature of the C++ function had been updated.
	 * If you still see your function signature accepts a const char * argument,
	 * please click the reload button to reset your code definition.
	 */
	public int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		long result = 0;
		int fuhao = 1;
		int state = 0;
		for (int i = 0; i < str.length(); i++) {
			if (state == 9) {
				break;
			}
			switch (str.charAt(i)) {
			case ' ':
				if ((state & 1) == 1) {
					return 0;
				}
				if ((state & 2) == 2) {
					return (int) result;
				}
				break;
			case '-':
				if (state != 0) {
					return 0;
				}
				fuhao = -1;
				state = 1;
				break;
			case '+':
				if (state != 0) {
					return 0;
				}
				state = 1;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				result = result * 10 + (str.charAt(i) - '0');
				if (fuhao > 0) {
					if (result > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				} else {
					if (result * fuhao < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}
				state |= 2;
				break;
			default:
				state = 9;
			}
		}
		result *= fuhao;
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		L008_ATOI_X solution = new L008_ATOI_X();
		Object rst = solution.myAtoi("-2147483649");
		System.out.println(rst);
	}
}
