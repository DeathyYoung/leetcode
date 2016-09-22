package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L061_RotateList {
	/**
	 * 61. Rotate List
	 * <p>
	 * Total Accepted: 78653 Total Submissions: 335061 Difficulty: Medium
	 * <p>
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 * 
	 * Tags: Linked List Two Pointers
	 * 
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null)
			return head;
		ListNode left = head;
		ListNode right = head;

		int len = 0;
		while (right != null) {
			len++;
			right = right.next;
		}
		k %= len;
		if (k == 0)
			return head;
		right = head;
		///////////////////////////////////////////////////////////
		while (k > 0 && right != null && right.next != null) {
			k--;
			right = right.next;
		}

		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		right.next = head;
		head = left.next;
		left.next = null;
		return head;
	}

	public static void main(String[] args) {
		L061_RotateList solution = new L061_RotateList();
		ListNode ln = ListNode.getListNode(new int[] { 1, 2 });
		System.out.println(ln);
		ln = solution.rotateRight(ln, 3);
		System.out.println(ln);
		// [1, 2], 3
	}

}
