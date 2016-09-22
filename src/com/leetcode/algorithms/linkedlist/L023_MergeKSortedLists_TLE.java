package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L023_MergeKSortedLists_TLE {
	/**
	 * 23. Merge k Sorted Lists
	 * <p>
	 * Total Accepted: 98925 Total Submissions: 403562 Difficulty: Hard
	 * <p>
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 * 
	 * Tags: Divide and Conquer, Linked List, Heap
	 * 
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = heapMin(lists);
		if(head==null)
		    return null;
		ListNode t;
		ListNode ln = head;
		while ((t = heapMin(lists)) != null) {
			ln.next = t;
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}

	private ListNode heapMin(ListNode[] lists) {
		int index = -1;
		ListNode ln = new ListNode(Integer.MAX_VALUE);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null && ln.val >= lists[i].val) {
				index = i;
				ln = lists[i];
			}
		}
		if (index == -1)
			return null;

		lists[index] = lists[index].next;
		return ln;
	}

	public static void main(String[] args) {
		L023_MergeKSortedLists_TLE solution = new L023_MergeKSortedLists_TLE();
		ListNode[] lns = new ListNode[4];
//		lns[0] = ListNode.getSortedListNode1();
		lns[1] = ListNode.getSortedListNode2();
		lns[2] = ListNode.getSortedListNode3();
//		System.out.println(lns[0]);
		System.out.println(lns[1]);
		System.out.println(lns[2]);
		ListNode ln = solution.mergeKLists(lns);
		System.out.println(ln);
	}

}
