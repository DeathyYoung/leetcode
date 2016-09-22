package com.leetcode.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leetcode.algorithms.ListNode;

public class L148_LinkedListSort_TLE {
	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * 
	 * Tags: Linked List Sort
	 * 
	 * L148_30、L148_17、L148_10三种方法其实思路一样
	 * 
	 */
	public ListNode sortList(ListNode head) {
		ListNode soldier = new ListNode(Integer.MIN_VALUE);
		soldier.next = head;

		sort(soldier);
		// insertionSort(soldier);
		// sortByCollection(soldier);

		return soldier.next;
	}

	private void sort(ListNode soldier) {
		if (soldier.next == null || soldier.next.next == null) {
			return;
		}
		ListNode pivot = soldier.next;
		ListNode[] rst = randomQuickSort(pivot, 0, 0);
		soldier.next = rst[0];
	}

	/**
	 * <p>
	 * TODO
	 *
	 * @param l
	 * @param lenL
	 */
	private ListNode[] randomQuickSort(ListNode head, int len, int pivotIndex) {
		ListNode[] headAndTail = new ListNode[2];

		ListNode pivot = head;
		for (int i = 0; i < pivotIndex; i++) {
			pivot = pivot.next;
		}

		int lenL = 0;
		int lenR = 0;
		int nowIndex = -1;
		ListNode L = null;
		ListNode R = null;
		ListNode lnL = null;
		ListNode lnR = null;

		ListNode ln = head;

		while (ln != null) {
			nowIndex++;
			if (nowIndex == pivotIndex) {
				ln = ln.next;
				continue;
			}
			if (ln.val < pivot.val) {
				lenL++;
				if (L == null) {
					L = ln;
					lnL = ln;
				} else {
					lnL.next = ln;
					lnL = lnL.next;
				}
			} else {
				lenR++;
				if (R == null) {
					R = ln;
					lnR = ln;
				} else {
					lnR.next = ln;
					lnR = lnR.next;
				}
			}
			ln = ln.next;
		}
		if (lnL != null)
			lnL.next = null;
		if (lnR != null)
			lnR.next = null;

		pivot.next = null;
		headAndTail[0] = pivot;
		headAndTail[1] = pivot;

		if (lenL > 0) {
			ListNode[] lefts = randomQuickSort(L, lenL, (int) (lenL * Math.random()));
			headAndTail[0] = lefts[0];
			lefts[1].next = pivot;
		}
		if (lenR > 0) {
			ListNode[] rights = randomQuickSort(R, lenR, (int) (lenR * Math.random()));
			pivot.next = rights[0];
			headAndTail[1] = rights[1];
		}

		return headAndTail;
	}

	private void sortByCollection(ListNode soldier) {
		List<ListNode> list = new ArrayList<ListNode>();
		while (soldier.next != null) {
			list.add(soldier.next);
			soldier = soldier.next;
		}

		Collections.sort(list, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode node = soldier;
		for (ListNode ln : list) {
			node.next = ln;
			node = node.next;
		}
		node.next = null;
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
		L148_LinkedListSort_TLE solution = new L148_LinkedListSort_TLE();
		ListNode head = new ListNode(1);
		ListNode node = head;
		for (int i = 0; i < 15; i++) {
			ListNode ln = new ListNode((int) (Math.random() * 10));
			node.next = ln;
			node = ln;
		}
		System.out.println(head);
		head = solution.sortList(head);
		System.out.println(head);
	}

}
