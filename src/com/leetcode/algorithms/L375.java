package com.leetcode.algorithms;

public class L375 {

	/**
	 * We are playing the Guess Game. The game is as follows:
	 * 
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * 
	 * Every time you guess wrong, I'll tell you whether the number I picked is
	 * higher or lower.
	 * 
	 * However, when you guess a particular number x, and you guess wrong, you
	 * pay $x. You win the game when you guess the number I picked.
	 * 
	 * Example:
	 * 
	 * n = 10, I pick 8.
	 * 
	 * First round: You guess 5, I tell you that it's higher. You pay $5. Second
	 * round: You guess 7, I tell you that it's higher. You pay $7. Third round:
	 * You guess 9, I tell you that it's lower. You pay $9.
	 * 
	 * Game over. 8 is the number I picked.
	 * 
	 * You end up paying $5 + $7 + $9 = $21. Given a particular n ≥ 1, find out
	 * how much money you need to have to guarantee a win.
	 */
	public int getMoneyAmount(int n) {

		int[][] money = new int[n + 2][n + 2];// [2][7] 2-7范围内最少多少花费。

		for (int i = 0; i < money.length; i++) {
			for (int j = 0; j < money.length; j++) {
				money[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int minMoney = Integer.MAX_VALUE;
				for (int k = j; k <= i; k++) {
					int m = k + Math.max(money[j][k - 1], money[k + 1][i]);
					if (m < minMoney) {
						minMoney = m;
					}
				}
				money[j][i] = minMoney;
			}
		}

		return money[1][n];
	}

	public static void main(String[] args) {
		L375 solution = new L375();
		int m = solution.getMoneyAmount(9);
		System.out.println(m);
	}
}
