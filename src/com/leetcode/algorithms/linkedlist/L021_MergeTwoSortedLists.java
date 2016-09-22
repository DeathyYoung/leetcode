package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L021_MergeTwoSortedLists {

	/**
	 * 21. Merge Two Sorted Lists
	 * <p>
	 * Total Accepted: 147571 Total Submissions: 403099 Difficulty: Easy
	 * <p>
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * <p>
	 * Tags: Linked List
	 * 
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode soldier = new ListNode(0);
		ListNode now = soldier;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				now.next = l1;
				l1 = l1.next;
			} else {
				now.next = l2;
				l2 = l2.next;
			}
			now = now.next;
		}

		while (l1 != null) {
			now.next = l1;
			l1 = l1.next;
			now = now.next;
		}

		while (l2 != null) {
			now.next = l2;
			l2 = l2.next;
			now = now.next;
		}

		return soldier.next;
	}

	public static void main(String[] args) {
		L021_MergeTwoSortedLists solution = new L021_MergeTwoSortedLists();

		ListNode aa = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		aa.next = b;
		b.next = c;

		ListNode aa2 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode c2 = new ListNode(6);
		aa2.next = b2;
		b2.next = c2;

		ListNode rst = solution.mergeTwoLists(aa, aa2);
		while (rst != null) {
			System.out.println(rst.val);
			rst = rst.next;
		}
	}
}
