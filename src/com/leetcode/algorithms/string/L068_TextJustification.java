package com.leetcode.algorithms.string;

import java.util.LinkedList;
import java.util.List;

public class L068_TextJustification {
	/**
	 * 68. Text Justification
	 * <p>
	 * Total Accepted: 38231 Total Submissions: 226170 Difficulty: Hard
	 * <p>
	 * Given an array of words and a length L, format the text such that each
	 * line has exactly L characters and is fully (left and right) justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly L characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * For example,
	 * 
	 * <pre>
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	 * </pre>
	 * 
	 * Note: Each word is guaranteed not to exceed L in length.
	 * 
	 * Tags: String
	 * 
	 */
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new LinkedList<String>();
		if (words == null || words.length == 0 || maxWidth < 1){
			list.add("");
			return list;
		}
		int lineLen = 0;
		List<String> line = new LinkedList<String>();
		StringBuffer sb = new StringBuffer();
		int left;
		int[] spaces;
		int per, moreOne;
		int i, j;
		for (int wi = 0; wi < words.length; wi++) {
			String word = words[wi];
			if (lineLen + word.length() + 1 <= maxWidth + 1) {
				lineLen += word.length() + 1;
				line.add(word);
			} else {// full
				sb.setLength(0);
				if (line.size() == 0) {
					break;
				} else if (line.size() == 1) {
					sb.append(line.get(0));
					for (i = line.get(0).length(); i < maxWidth; i++) {
						sb.append(' ');
					}
				} else {
					left = maxWidth - lineLen + 1;
					spaces = new int[line.size() - 1];
					per = left / spaces.length;
					moreOne = left % spaces.length;
					for (i = 0; i < moreOne; i++) {
						spaces[i] = per + 2;
					}
					for (; i < spaces.length; i++) {
						spaces[i] = per + 1;
					}
					sb.append(line.get(0));
					for (i = 1; i < line.size(); i++) {
						for (j = 0; j < spaces[i - 1]; j++) {
							sb.append(' ');
						}
						sb.append(line.get(i));
					}
				}
				list.add(sb.toString());
				line.clear();

				lineLen = word.length() + 1;
				line.add(word);
			}
		}
		if (line.size() > 0) {
			sb.setLength(0);
			sb.append(line.get(0));
			for (i = 1; i < line.size(); i++) {
				sb.append(' ');
				sb.append(line.get(i));
			}
			while (sb.length() < maxWidth) {
				sb.append(' ');
			}
			list.add(sb.toString());
		}
		return list;
	}

	public static void main(String[] args) {
		L068_TextJustification solution = new L068_TextJustification();
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> list = solution.fullJustify(words, 16);
		for (String str : list) {
			System.out.println(str);
		}
	}

}
