package com.leetcode.algorithms.array;

public class L079_WordSearch {
	/**
	 * 79. Word Search
	 * <p>
	 * Total Accepted: 86072
	 * <p>
	 * Total Submissions: 357998
	 * <p>
	 * Difficulty: Medium
	 * <p>
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * 
	 * For example, Given board =
	 * 
	 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word =
	 * "ABCCED", -> returns true, word = "SEE", -> returns true, word = "ABCB",
	 * -> returns false. 
	 * 
	 * Tags: Array Backtracking 
	 * 
	 * 
	 * 
	 */
	public boolean exist(char[][] board, String word) {
		if (word == null || board == null)
			return false;
		if (word.trim().length() == 0)
			return true;
		if (board.length == 0 || board[0].length == 0)
			return false;

		char[] cs = word.toCharArray();
		boolean[][] check = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (cs[0] == board[i][j]) {
					check[i][j] = true;
					if (deepSearch(board, check, i, j, cs, 1))
						return true;
					check[i][j] = false;
				}
			}
		}
		return false;
	}

	private boolean deepSearch(char[][] board, boolean[][] check, int i, int j, char[] cs, int csStart) {

		if (cs.length < csStart + 1) {
			return true;
		}

		if (i < board.length - 1 && board[i + 1][j] == cs[csStart] && !check[i + 1][j]) {
			check[i + 1][j] = true;
			if (deepSearch(board, check, i + 1, j, cs, csStart + 1)) {
				return true;
			}
			check[i + 1][j] = false;
		}

		if (i > 0 && board[i - 1][j] == cs[csStart] && !check[i - 1][j]) {
			check[i - 1][j] = true;
			if (deepSearch(board, check, i - 1, j, cs, csStart + 1)) {
				return true;
			}
			check[i - 1][j] = false;
		}

		if (j < board[0].length - 1 && board[i][j + 1] == cs[csStart] && !check[i][j + 1]) {
			check[i][j + 1] = true;
			if (deepSearch(board, check, i, j + 1, cs, csStart + 1)) {
				return true;
			}
			check[i][j + 1] = false;
		}

		if (j > 0 && board[i][j - 1] == cs[csStart] && !check[i][j - 1]) {
			check[i][j - 1] = true;
			if (deepSearch(board, check, i, j - 1, cs, csStart + 1)) {
				return true;
			}
			check[i][j - 1] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		L079_WordSearch solution = new L079_WordSearch();
		System.out.println(solution.exist(new char[][] { { 'a', 'a' } }, "aaa"));
	}

}
