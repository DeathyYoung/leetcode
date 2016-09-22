package com.leetcode.algorithms.string;

public class L028_ImplementIndexOf_X {
	/**
	 * 28. Implement strStr()
	 * <p>
	 * Total Accepted: 122875 Total Submissions: 475590 Difficulty: Easy
	 * 
	 * Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * 
	 * 
	 * Tags: Two Pointers String
	 * 
	 * 
	 */
	public int strStr(String haystack, String needle) {
		return indexOf(haystack.toCharArray(), needle.toCharArray());
	}

	private int indexOf(char[] source, char[] target) {
		int fromIndex = 0;

		int sourceOffset = 0;
		int sourceCount = source.length;
		int targetOffset = 0;
		int targetCount = target.length;

		if (fromIndex >= sourceCount) {
			return (targetCount == 0 ? sourceCount : -1);
		}

		if (targetCount == 0) {
			return fromIndex;
		}

		char first = target[targetOffset];
		int max = sourceOffset + (sourceCount - targetCount);

		for (int i = sourceOffset + fromIndex; i <= max; i++) {
			/* Look for first character. */
			if (source[i] != first) {
				while (++i <= max && source[i] != first)
					;
			}

			/* Found first character, now look at the rest of v2 */
			if (i <= max) {
				int j = i + 1;
				int end = j + targetCount - 1;
				for (int k = targetOffset + 1; j < end && source[j] == target[k]; j++, k++)
					;

				if (j == end) {
					/* Found whole string. */
					return i - sourceOffset;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		L028_ImplementIndexOf_X solution = new L028_ImplementIndexOf_X();
		String str1 = "solution";
		String str2 = "lut";
		System.out.println(solution.strStr(str1, str2));
		System.out.println(str1.indexOf(str2));
	}

}
