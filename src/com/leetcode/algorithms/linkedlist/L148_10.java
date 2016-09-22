package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L148_10 {
	/**
	 * 要想时间复杂度达到O(n log n) ，
	 * <p>
	 * 那么有两种，一种是合并排序，另一种是快速排序
	 * <p>
	 * 而要想空间复杂度为常数，那么只能使用递归
	 */
	public class Solution {
		private ListNode merge(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			ListNode head = new ListNode(-1);
			ListNode pNode = head;
			while (l1 != null || l2 != null) {
				if (l1 == null) {
					pNode.next = l2;
					return head.next;
				}
				if (l2 == null) {
					pNode.next = l1;
					return head.next;
				}
				if (l1.val > l2.val) {
					pNode.next = l2;
					l2 = l2.next;
				} else {
					pNode.next = l1;
					l1 = l1.next;
				}
				pNode = pNode.next;
			}
			return head.next;
		}

		private ListNode mergeSort(ListNode head) {
			if (head == null || head.next == null) // just one element
				return head;
			ListNode p = head, q = head, pre = null;
			while (q != null && q.next != null) {
				q = q.next.next;
				pre = p;
				p = p.next; // divide into two parts
			}
			pre.next = null;
			ListNode lhalf = mergeSort(head);
			ListNode rhalf = mergeSort(p); // recursive
			return merge(lhalf, rhalf); // merge
		}

		public ListNode sortList(ListNode head) {
			return mergeSort(head);
		}
	}

	public static void main(String[] args) {
		L148_10 solution = new L148_10();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
