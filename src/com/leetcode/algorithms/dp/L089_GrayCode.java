package com.leetcode.algorithms.dp;

import java.util.LinkedList;
import java.util.List;

public class L089_GrayCode {
	/**
	 * 89. Gray Code
	 * <p>
	 * Total Accepted: 68405 Total Submissions: 180627 Difficulty: Medium
	 * <p>
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * <pre>
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	
	
	000 - 0
	001 - 1
	011 - 3
	010 - 2
	110 - 0
	111 - 1
	101 - 3
	100 - 2
	 * </pre>
	 * 
	 * Note: For a given n, a gray code sequence is not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 * 
	 * Tags: Backtracking
	 * 
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> list = new LinkedList<Integer>();
		if (n == 0)
			return list;
		long max = 1 << n;
		for (int i = 0; i < max; i++) {
			int num = 0;
			long range = 1 << n;
			range <<= 1;
			range--;
			for (int j = n - 1; j >= 0; j--) {
				long index = i & range;
				long part = index >> j;
				if (part == 1 || part == 2) {
					num |= 1 << j;
				}
				range >>= 1;

			}
			list.add(num);
		}
		return list;

	}

	public static void main(String[] args) {
		L089_GrayCode solution = new L089_GrayCode();
		int size = 0;
		List<Integer> list = solution.grayCode(size);
		for (int i : list) {
			StringBuffer sb = new StringBuffer(Integer.toBinaryString(i));
			while (sb.length() < size) {
				sb.insert(0, 0);
			}
			System.out.println(sb);
		}
	}

}
