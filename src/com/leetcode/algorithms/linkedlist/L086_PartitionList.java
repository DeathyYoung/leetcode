package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L086_PartitionList {
	/**
	 * 86. Partition List
	 * <p>
	 * Total Accepted: 74611 Total Submissions: 244393 Difficulty: Medium
	 * <p>
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 * 
	 * Tags: Linked List Two Pointers
	 * 
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode lnl = left;
		ListNode lnr = right;

		while (head != null) {
			if (head.val < x) {
				lnl.next = head;
				lnl = lnl.next;
			} else {
				lnr.next = head;
				lnr = lnr.next;
			}
			head = head.next;
		}

		lnl.next = right.next;
		lnr.next = null;

		return left.next;
	}

	public static void main(String[] args) {
		L086_PartitionList solution = new L086_PartitionList();
		ListNode ln = ListNode.getListNode();
		System.out.println(ln);
		ln = solution.partition(ln, 7);
		System.out.println(ln);
	}

}
