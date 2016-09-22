package com.leetcode.algorithms.math;

import com.leetcode.algorithms.ListNode;

public class L002_AddTwoNumbers {
	/**
	 * 2. Add Two Numbers
	 * <p>
	 * Total Accepted: 167890 Total Submissions: 684794 Difficulty: Medium
	 * <p>
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 * 
	 * Tags: Linked List Math
	 * 
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode rst = new ListNode(0);
		ListNode p = rst;
		p.next = new ListNode(0);
		int more = 0;
		while (l2 != null && l1 != null) {
			p = p.next;
			int temp = l2.val + l1.val + more;
			if (temp > 9) {
				p.val = temp - 10;
				more = 1;
			} else {
				p.val = temp;
				more = 0;
			}
			p.next = new ListNode(1);
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 == null) {
			l1 = l2;
		}

		if (l1 == null) {
			if (more == 0) {
				p.next = null;
				return rst.next;
			} else {
				return rst.next;
			}
		} else {
			while (l1 != null) {
				p = p.next;
				int temp = l1.val + more;
				if (temp > 9) {
					p.val = temp - 10;
					more = 1;
				} else {
					p.val = temp;
					more = 0;
				}
				p.next = new ListNode(1);
				l1 = l1.next;
			}
			if (more == 0) {
				p.next = null;
				return rst.next;
			} else {
				return rst.next;
			}
		}
	}

	public static void main(String[] args) {
		L002_AddTwoNumbers solution = new L002_AddTwoNumbers();
		// (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
		ListNode ln1 = new ListNode(2);
		ListNode ln12 = new ListNode(4);
		ListNode ln13 = new ListNode(5);
		ln1.next = ln12;
		ln12.next = ln13;
		ListNode ln2 = new ListNode(5);
		ListNode ln22 = new ListNode(6);
		ListNode ln23 = new ListNode(4);
		ln2.next = ln22;
		ln22.next = ln23;
		ListNode ln = solution.addTwoNumbers(ln1, ln2);
		System.out.println(ln);
	}

}
