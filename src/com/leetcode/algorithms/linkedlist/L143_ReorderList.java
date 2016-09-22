package com.leetcode.algorithms.linkedlist;

import java.util.ArrayList;

import com.deathyyoung.common.util.MathUtil;
import com.leetcode.algorithms.ListNode;

public class L143_ReorderList {
	/**
	 * 143. Reorder List
	 * <p>
	 * Total Accepted: 71963 Total Submissions: 303738 Difficulty: Medium
	 * <p>
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
	 * L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * 
	 * Tags: Linked List
	 * 
	 * 
	 */
	public void reorderList(ListNode head) {
		ArrayList<ListNode> array = new ArrayList<ListNode>();
		ListNode ln = head;
		while (ln != null) {
			array.add(ln);
			ln = ln.next;
		}

		int l = 0;
		int r = array.size() - 1;
		
		while (l < r) {
			if (l < r) {
				array.get(l).next = array.get(r);
				l++;
			}
			if (l < r) {
				array.get(r).next = array.get(l);
				r--;
			}
		}
		array.get(l).next = null;
	}

	public static void main(String[] args) {
		L143_ReorderList solution = new L143_ReorderList();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		
		Integer a = 4;
		Integer b = 6;
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println(a);
		System.out.println(b);
	}

}
