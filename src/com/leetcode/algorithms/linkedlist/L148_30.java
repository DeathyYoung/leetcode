package com.leetcode.algorithms.linkedlist;

import com.leetcode.algorithms.ListNode;

public class L148_30 {
	/**
	 * (对于discuss中第二个最优解的解释） 根据时间复杂度的要求，很容易想到应该用merge
	 * sort的方法来做，那么就有两个步骤，分和法。先把整个list分成两部分，这里可以用找中间值的方法，在找中间值的同时，
	 * 标记一下中间值的前一个node，也就是第一个list的最后一个node，然后找到中间值之前，将最后一个node的下一位标记为null，
	 * 就成功地将这个list分成了两部分；接下来是merge,
	 * 那就建一个新的list，将两个sort好的list按最小数的大小依次放进新list中，最后返回merge的list。 *
	 * ，那么有两种，一种是合并排序，另一种是快速排序，而要想空间复杂度为常数，那么只能使用递归，本人使用的是递归的合并排序
	 */
	public class Solution {
	    public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        //seperate the list into two parts
	        //Track the last node of first list and point the end to null
	        ListNode prev = null;
	        ListNode slow = head, fast = head;
	        while (fast != null && fast.next != null) {
	            prev = slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        prev.next = null;
	        ListNode l1 = sortList(head);
	        ListNode l2 = sortList(slow);
	        
	        return merge(l1, l2);
	    }
	    
	    public ListNode merge(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(0);
	        ListNode l = dummy;
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                l.next = l1;
	                l1 = l1.next;
	            } else {
	                l.next = l2;
	                l2 = l2.next;
	            }
	            l = l.next;
	        }
	        
	        while (l1 != null) {
	            l.next = l1;
	            l1 = l1.next;
	            l = l.next;
	        }
	        while (l2 != null) {
	            l.next = l2;
	            l2 = l2.next;
	            l = l.next;
	        }
	        
	        return dummy.next;
	    }
	}

	public static void main(String[] args) {
		L148_30 solution = new L148_30();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
