package com.leetcode.algorithms.string;

public class L038_CountAndSay {
	/**
	 * 38. Count and Say
	 * <p>
	 * Total Accepted: 93876 Total Submissions: 306306 Difficulty: Easy
	 * <p>
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 * 
	 * Tags: String
	 * 
	 * 
	 */
	public String countAndSay(int n) {
		if (n <= 0)
			return "";
		String rst = "1";
		StringBuffer sb = new StringBuffer();
		while (n-- > 1) {
			sb.setLength(0);
			;
			int count = 0;
			char pre = '-';
			for (char c : rst.toCharArray()) {
				if (c == pre) {
					count++;
				} else {
					if (count > 0) {
						sb.append(count);
						sb.append(pre);
					}
					count = 1;
				}
				pre = c;
			}
			if (count > 0) {
				sb.append(count);
				sb.append(pre);
			}
			rst = sb.toString();
		}
		return rst;
	}

	public static void main(String[] args) {
		L038_CountAndSay solution = new L038_CountAndSay();
		for (int i = 0; i < 200; i++) {
			System.out.println(solution.countAndSay(i));
		}
	}
}
