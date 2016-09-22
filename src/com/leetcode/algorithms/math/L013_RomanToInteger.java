package com.leetcode.algorithms.math;


/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L013_RomanToInteger {

	/**
	 * 

	 * <p>
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * Ｉ、Ｖ、Ｘ、Ｌ、Ｃ、Ｄ和Ｍ，分别表示１、５、１０、５０、１００、５００和１０００，逆序查询
	 */
	public int romanToInt(String s) {
		int[] map = new int['X' + 1];
		map['I'] = 1;
		map['V'] = 5;
		map['X'] = 10;
		map['L'] = 50;
		map['C'] = 100;
		map['D'] = 500;
		map['M'] = 1000;
		int pre = 0;
		int now = 0;
		int sum = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			now = map[s.charAt(i)];
			if (pre > now) {
				sum = sum - now;
			} else {
				sum += now;
			}
			pre = now;
		}
		return sum;
	}

	public static void main(String[] args) {
		L013_RomanToInteger solution = new L013_RomanToInteger();
		Object rst = solution.romanToInt("MCMXCVI");
		System.out.println(rst);
	}
}
