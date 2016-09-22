package com.leetcode.algorithms;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	/*
	 * (non-Javadoc) <p>Title: toString <p>TODO
	 *
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @since 2016年8月18日
	 */
	@Override
	public String toString() {
		if (next == null)
			return val + "";
		else
			return val + "==>" + next.toString();
	}

	public static ListNode getSortedListNode1() {
		int[] nums = { 1, 1, 2, 3, 3, 3, 5, 5, 7, 8, 8, 8, 9 };
		ListNode head = new ListNode(nums[0]);
		ListNode ln = head;
		for (int i = 1; i < nums.length; i++) {
			ln.next = new ListNode(nums[i]);
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}

	public static ListNode getSortedListNode2() {
		int[] nums = { 1, 1, 2, 3, 7, 8, 8, 8, 9, 9, 9 };
		ListNode head = new ListNode(nums[0]);
		ListNode ln = head;
		for (int i = 1; i < nums.length; i++) {
			ln.next = new ListNode(nums[i]);
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}

	public static ListNode getSortedListNode3() {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		ListNode head = new ListNode(nums[0]);
		ListNode ln = head;
		for (int i = 1; i < nums.length; i++) {
			ln.next = new ListNode(nums[i]);
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}

	public static ListNode getListNode() {
		int[] nums = { 1, 2, 5, 6, 3, 3, 4, };
		ListNode head = new ListNode(nums[0]);
		ListNode ln = head;
		for (int i = 1; i < nums.length; i++) {
			ln.next = new ListNode(nums[i]);
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}
	
	public static ListNode getListNode(int[] nums){
		ListNode head = new ListNode(nums[0]);
		ListNode ln = head;
		for (int i = 1; i < nums.length; i++) {
			ln.next = new ListNode(nums[i]);
			ln = ln.next;
		}
		ln.next = null;
		return head;
	}
}
