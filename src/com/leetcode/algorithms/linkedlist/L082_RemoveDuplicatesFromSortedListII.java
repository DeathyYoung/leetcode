package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L082_RemoveDuplicatesFromSortedListII {
	/**
	 * 82. Remove Duplicates from Sorted List II
	 * <p>
	 * Total Accepted: 81741 Total Submissions: 294364 Difficulty: Medium
	 * <p>
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
	 * 1->1->1->2->3, return 2->3.
	 * 
	 * Tags: Linked List
	 * 
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode soldier = new ListNode(0);
		soldier.next = head;
		ListNode ln = soldier;
		while (ln.next != null && ln.next.next != null) {
			if (ln.next.next.val == ln.next.val) {
				while (ln.next.next != null && ln.next.val == ln.next.next.val) {
					ln.next.next = ln.next.next.next;
				}
				ln.next = ln.next.next;
			} else {
				ln = ln.next;
			}
		}
		return soldier.next;
	}

	public static void main(String[] args) {
		L082_RemoveDuplicatesFromSortedListII solution = new L082_RemoveDuplicatesFromSortedListII();
		ListNode ln = ListNode.getSortedListNode2();
		System.out.println(ln);
		ln = solution.deleteDuplicates(ln);
		System.out.println(ln);
	}

}
