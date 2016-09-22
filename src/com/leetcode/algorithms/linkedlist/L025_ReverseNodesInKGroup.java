package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L025_ReverseNodesInKGroup {
	/**
	 * 25. Reverse Nodes in k-Group
	 * <p>
	 * Total Accepted: 66965 Total Submissions: 234666 Difficulty: Hard
	 * <p>
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 * 
	 * Tags: Linked List
	 * 
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null)
			return head;
		int len = 0;
		ListNode h = head;
		while (h != null) {
			len++;
			h = h.next;
		}

		for (int i = 1; i + k - 1 <= len; i += k) {
			head = reverseBetween(head, i, i + k - 1);
		}
		return head;
	}

	private ListNode reverseBetween(ListNode head, int m, int n) {

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
		L025_ReverseNodesInKGroup solution = new L025_ReverseNodesInKGroup();
		ListNode ln = ListNode.getListNode();
		System.out.println(ln);
		ln = solution.reverseKGroup(ln, 7);
		System.out.println(ln);
	}

}
