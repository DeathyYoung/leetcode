package com.leetcode.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.leetcode.algorithms.ListNode;
import com.leetcode.algorithms.RandomListNode;

public class L138_CopyListWithRandomPointer {
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
	 * 
	 * 第一步：复制结点，复制的结点放在待复制的结点后，依然组成一个单链表 
　　第二步：串接随机指针 
　　第三步：将原单链表与复制链表拆开 
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
    }

    /**
     * 复制结点，复制的结点放在待复制的结点后，依然组成一个单链表
     *
     * @param head 链表头
     */
    public void copyNode(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
            // 复制一个新的结点
            RandomListNode copyNode = new RandomListNode(node.label);
            // 将结点串接到被复制的结点后，并且依然组成单链表
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    /**
     * 串接随机指针
     *
     * @param head 链表头
     */
    public void linkRandomPointer(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
            // 随机指针有指向某个具体的结点
            if (node.random != null) {
                // 串接node被复制结点的随机指针
                node.next.random = node.random.next;
            }

            // 指向下一个被复制的结点
            node = node.next.next;
        }
    }

    /**
     * 将链表拆分，还原原来的链表，并且组装拷贝的链表
     *
     * @param head 链表头
     * @return 拷贝的新链表头
     */
    public RandomListNode splitList(RandomListNode head) {
        // 新链表头
        RandomListNode copyHead = head.next;
        // 当前处理的被复制的结点
        RandomListNode node = head;
        // 当前复制的结点
        RandomListNode copy;

        while (node != null){
            // 指向复制结点
            copy = node.next;

            // node.next指向下一个被复制的结点
            node.next = copy.next;

            // 下一个被复制的结点不为null
            if (node.next != null) {
                // copy.next指向下一个复制的结点
                copy.next = node.next.next;
            }

            // node指向下一个要被处理的被复制结点
            node = node.next;
        }
        return copyHead;
    }

	public static void main(String[] args) {
		L138_CopyListWithRandomPointer solution = new L138_CopyListWithRandomPointer();
		RandomListNode n1 = new RandomListNode(-1);
		RandomListNode n2 = new RandomListNode(-1);
		}

}
