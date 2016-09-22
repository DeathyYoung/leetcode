package com.leetcode.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.leetcode.algorithms.ListNode;
import com.leetcode.algorithms.RandomListNode;

public class L138_CopyListWithRandomPointer_E {
	/**
	 * 138. Copy List with Random Pointer
	 * <p>
	 * Total Accepted: 72751 Total Submissions: 277802 Difficulty: Hard
	 * <p>
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * Tags: Hash Table Linked List 带有随机指针的链表
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode rln = new RandomListNode(head.label);
		RandomListNode temp = head;
		RandomListNode rlnTemp = rln;

		LinkedHashMap<Integer, RandomListNode> hashMap = new LinkedHashMap<Integer, RandomListNode>();
		hashMap.put(head.hashCode(), head);

		while (temp.next != null) {
			temp = temp.next;
			RandomListNode t = new RandomListNode(temp.label);
			rlnTemp.next = t;
			rlnTemp = rlnTemp.next;
			/////////////////////////
			if (temp.random != null) {
				hashMap.put(temp.hashCode(), t);
			}
		}

		temp = head;
		rlnTemp = rln;
		while (temp != null) {
			if (temp.random != null)
				rlnTemp.random = hashMap.get(temp.random.hashCode());
			temp = temp.next;
		}

		return rln;
	}

	public static void main(String[] args) {
		L138_CopyListWithRandomPointer_E solution = new L138_CopyListWithRandomPointer_E();
		RandomListNode n1 = new RandomListNode(-1);
		RandomListNode n2 = new RandomListNode(-1);
		}

}
