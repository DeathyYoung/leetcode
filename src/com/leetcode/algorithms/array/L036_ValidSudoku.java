package com.leetcode.algorithms.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class L036_ValidSudoku {
	/**
	 * 36. Valid Sudoku
	 * <p>
	 * Total Accepted: 85758 Total Submissions: 266942 Difficulty: Easy
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * L036.png
	 * 
	 * A partially filled sudoku which is valid.
	 * 
	 * Note: A valid Sudoku board (partially filled) is not necessarily
	 * solvable. Only the filled cells need to be validated.
	 * 
	 * Tags: Hash Table
	 * 
	 * 
	 */
	public boolean isValidSudoku(char[][] board) {
		ArrayList<Set<Character>> cols = new ArrayList<Set<Character>>();
		for (int i = 0; i < 9; i++) {
			cols.add(new HashSet<Character>());
		}

		ArrayList<Set<Character>> square = new ArrayList<Set<Character>>();
		for (int i = 0; i < 3; i++) {
			square.add(new HashSet<Character>());
		}

		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<Character>();
			if (i % 3 == 0) {
				square.get(0).clear();
				square.get(1).clear();
				square.get(2).clear();
			}
			for (int j = 0; j < 9; j++) {
				if (addAndCheck(row, board[i][j])) {
					return false;
				}
				if (addAndCheck(square.get(j / 3), board[i][j])) {
					return false;
				}
				if (addAndCheck(cols.get(j), board[i][j])) {
					return false;
				}
			}
		}

		// Set<Character> diagonal1 = new HashSet<Character>();
		// Set<Character> diagonal2 = new HashSet<Character>();
		// for (int i = 0; i < 9; i++) {
		// if (addAndCheck(diagonal1, board[i][i])) {
		// return false;
		// }
		// if (addAndCheck(diagonal2, board[i][9 - i - 1])) {
		// return false;
		// }
		// }

		return true;
	}

	private boolean addAndCheck(Set<Character> set, char c) {
		if (c != '.' && set.contains(c)) {
			return true;
		}
		set.add(c);
		return false;
	}

	public static void main(String[] args) {
		L036_ValidSudoku solution = new L036_ValidSudoku();
		String[] b = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
				"8........", "9........" };
		char[][] bd = new char[9][9];
		for(int i = 0; i < 9;i++){
			bd[i] = b[i].toCharArray();
		}
		boolean d  = solution.isValidSudoku(bd);
		System.out.println(d);
		for(String str : b){
			System.out.println(str);
		}
	}

}
