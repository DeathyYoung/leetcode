package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L024_SwapNodesInPairs {

	/**
	 * 24. Swap Nodes in Pairs
	 * <p>
	 * Total Accepted: 114916 Total Submissions: 317299 Difficulty: Easy
	 * <p>
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 * 
	 * Tags: Linked List
	 * 
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode soldier = new ListNode(0);
		soldier.next = head;
		ListNode now = soldier;
		ListNode t;

		while (now.next != null && now.next.next != null) {
			t = now.next;
			now.next = now.next.next;
			t.next = now.next.next;
			now.next.next = t;
			now = t;
		}

		return soldier.next;
	}

	public static void main(String[] args) {
		L024_SwapNodesInPairs solution = new L024_SwapNodesInPairs();

		ListNode aa = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		aa.next = b;
		b.next = c;

		ListNode rst = solution.swapPairs(aa);
		while (rst != null) {
			System.out.println(rst.val);
			rst = rst.next;
		}
	}
}
