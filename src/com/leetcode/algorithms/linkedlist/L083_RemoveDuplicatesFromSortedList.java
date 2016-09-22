package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L083_RemoveDuplicatesFromSortedList {
	/**
	 * 83. Remove Duplicates from Sorted List
	 * <p>
	 * Total Accepted: 133721 Total Submissions: 354278 Difficulty: Easy
	 * <p>
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 * 
	 * Tags: Linked List
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode ln = head;
		while (ln.next != null) {
			if (ln.val == ln.next.val) {
				ln.next = ln.next.next;
			} else {
				ln = ln.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		L083_RemoveDuplicatesFromSortedList solution = new L083_RemoveDuplicatesFromSortedList();
		ListNode ln = ListNode.getSortedListNode2();
		System.out.println(ln);
		ln = solution.deleteDuplicates(ln);
		System.out.println(ln);
	}

}
