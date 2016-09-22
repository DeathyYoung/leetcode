package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L147_InsertionSortList {
	/**
	 * 147. Insertion Sort List
	 * <p>
	 * Total Accepted: 79171 Total Submissions: 259047 Difficulty: Medium
	 * <p>
	 * Sort a linked list using insertion sort.
	 * 
	 * Tags: Linked List Sort
	 * 
	 */
	public ListNode insertionSortList(ListNode head) {
		ListNode soldier = new ListNode(Integer.MIN_VALUE);
		soldier.next = head;

		insertionSort(soldier);

		return soldier.next;
	}

	private void insertionSort(ListNode soldier) {
		if (soldier.next == null || soldier.next.next == null)
			return;
		ListNode ln = soldier.next;
		ListNode temp;
		ListNode lnFollow;
		while (ln.next != null) {
			int val = ln.next.val;
			temp = soldier;
			while (temp != ln) {
				if (val >= temp.val && (val <= temp.next.val)) {
					lnFollow = ln.next.next;
					ln.next.next = temp.next;
					temp.next = ln.next;
					ln.next = lnFollow;
					break;
				}
				temp = temp.next;
			}

			if (temp == ln) {
				ln = ln.next;
			}
		}
	}

	public static void main(String[] args) {
		L147_InsertionSortList solution = new L147_InsertionSortList();
		ListNode head = new ListNode(1);
		ListNode node = head;
		for (int i = 0; i < 15; i++) {
			ListNode ln = new ListNode((int) (Math.random() * 10));
			node.next = ln;
			node = ln;
		}
		System.out.println(head);
		head = solution.insertionSortList(head);
		System.out.println(head);
	}

}
