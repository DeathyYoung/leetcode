package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L019_RemoveNthNodeFromEndOfList {

	/**
	 * 19. Remove Nth Node From End of List
	 * <p>
	 * Total Accepted: 125326 Total Submissions: 407278 Difficulty: Easy
	 * <p>
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one
	 * pass.
	 * <p>
	 * Tags: Linked List Two Pointers
	 * 
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode soldier = new ListNode(0);
		soldier.next = head;

		ListNode now = soldier;
		ListNode target = null;

		int count = 1;
		while (now.next != null) {
			if (count < n)
				count++;
			else if (target == null)
				target = soldier;
			else
				target = target.next;
			now = now.next;
		}
		if (target == null || target.next == null) {
			return null;
		}
		target.next = target.next.next;

		return soldier.next;
	}

	public static void main(String[] args) {
		L019_RemoveNthNodeFromEndOfList solution = new L019_RemoveNthNodeFromEndOfList();
		ListNode aa = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		aa.next = b;
		b.next = c;
		ListNode rst = solution.removeNthFromEnd(aa, 2);
		while (rst != null) {
			System.out.println(rst.val);
			rst = rst.next;
		}
	}
}
