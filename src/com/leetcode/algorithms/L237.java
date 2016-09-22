package com.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class L237 {

	/**
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 * 
	 * 没有给我们链表的起点，只给我们了一个要删的节点
	 */
	public void deleteNode(ListNode node) {
		if (node == null || node.next == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		L237 solution = new L237();
		ListNode ln = new ListNode(0);
		ln.next = new ListNode(1);
		solution.deleteNode(ln);
		while (ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
}
