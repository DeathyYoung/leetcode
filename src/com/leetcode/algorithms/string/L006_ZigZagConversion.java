package com.leetcode.algorithms.string;

/**
 * <p>
 * TODO
 * 
 * @author <a href="http://clog.deathyyoung.com" target="_blank">Deathy
 *         Young</a> (<a href="mailto:mapleyeh@qq.com" >mapleyeh@qq.com</a>)
 */
public class L006_ZigZagConversion {

	/**
	 * 6. ZigZag Conversion
	 * <p>
	 * Total Accepted: 103236 Total Submissions: 412444 Difficulty: Easy
	 * <p>
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 * 
	 * <pre>
	P   A   H   N
	A P L S I I G
	Y   I   R
	 * </pre>
	 * 
	 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will
	 * take a string and make this conversion given a number of rows:
	 * 
	 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
	 * should return "PAHNAPLSIIGYIR". Subscribe to see which companies asked
	 * this question
	 * 
	 * Tags: String
	 */
	public String convert(String s, int numRows) {
		StringBuffer sb = new StringBuffer();
		if (numRows == 1)
			return s;
		// = 1
		int index = 0;
		{
			while (index < s.length()) {
				sb.append(s.charAt(index));
				index += 2 * numRows - 2;
			}
		}
		// middle
		{
			for (int i = 1; i < numRows - 1; i++) {
				index = i;
				int mid = 2 * numRows - 2;
				while (index < s.length()) {
					sb.append(s.charAt(index));
					index = mid - index;
					mid += 2 * numRows - 2;
				}
			}
		}
		// = last
		index = numRows - 1;
		{
			while (index < s.length()) {
				sb.append(s.charAt(index));
				index += 2 * numRows - 2;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		L006_ZigZagConversion solution = new L006_ZigZagConversion();
		Object rst = solution.convert("PAYPALISHIRING", 3);
		System.out.println(rst);
	}
}
