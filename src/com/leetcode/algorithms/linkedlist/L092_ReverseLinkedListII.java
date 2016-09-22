package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L092_ReverseLinkedListII {
	/**
	 * 92. Reverse Linked List II
	 * <p>
	 * Total Accepted: 80957 Total Submissions: 280208 Difficulty: Medium
	 * <p>
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of
	 * list.
	 * 
	 * Tags: Linked List
	 * 
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (n - m < 1) {
			return head;
		}

		ListNode soldier = new ListNode(-1);
		soldier.next = head;

		ListNode leftBound = soldier;
		while (m > 1) {
			leftBound = leftBound.next;
			m--;
			n--;
		}
		ListNode leftIn = leftBound.next;

		ListNode ln1 = leftBound.next;
		ListNode ln2 = leftBound.next.next;
		ListNode ln3 = leftBound.next.next.next;
		while (n > 1) {
			n--;
			ln2.next = ln1;
			ln1 = ln2;
			ln2 = ln3;
			if (ln3 != null)
				ln3 = ln3.next;
		}
		leftBound.next = ln1;
		leftIn.next = ln2;

		return soldier.next;
	}

	public static void main(String[] args) {
		L092_ReverseLinkedListII solution = new L092_ReverseLinkedListII();
		ListNode ln = ListNode.getListNode(new int[]{3, 5, 7});
		System.out.println(ln);
		ln = solution.reverseBetween(ln, 1,2);
		System.out.println(ln);
		//[3, 5] 1, 2
	}

}
