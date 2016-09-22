package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L142_LinkedListCycleII {
	/**
	 * 142. Linked List Cycle II
	 * <p>
	 * Accepted: 84988 Total Submissions: 271546 Difficulty: Medium
	 * <p>
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Note: Do not modify the linked list.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 * 
	 * Tags: Linked List Two Pointers 确定链表环的起点
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode ln1 = head;
		ListNode ln2 = head;
		while (ln1 != null && ln2 != null && ln2.next != null) {
			ln1 = ln1.next;
			ln2 = ln2.next.next;
			if (ln1 == ln2) {
				ln2 = head;
				while (ln2 != ln1) {
					ln1 = ln1.next;
					ln2 = ln2.next;
				}
				return ln1;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		L142_LinkedListCycleII solution = new L142_LinkedListCycleII();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
