package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L141_LinkedListCycle {
	/**
	 * 141. Linked List Cycle
	 * <p>
	 * Total Accepted: 124140 Total Submissions: 341346 Difficulty: Easy
	 * <p>
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 * 
	 * Tags: Linked List Two Pointers 检测是否有环
	 */
	public boolean hasCycle(ListNode head) {
		ListNode ln1 = head;
		ListNode ln2 = head;
		while (ln1 != null && ln2 != null && ln2.next != null) {
			ln1 = ln1.next;
			ln2 = ln2.next.next;
			if (ln1 == ln2) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		L141_LinkedListCycle solution = new L141_LinkedListCycle();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
