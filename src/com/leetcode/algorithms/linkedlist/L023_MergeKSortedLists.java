package com.leetcode.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.leetcode.algorithms.ListNode;

public class L023_MergeKSortedLists {
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
	 * 使用小顶堆来实现，先将K个链表的头结点入堆，取堆顶元素，这个结点就是最小的，接着让取出的这个结点的下一个结点入堆，再取堆顶元素，其为第二小的结点，
	 * 一直这样子操作，直到所有的结点都处理完，这样就完成了链表的合并，更多细节请见代码和注释。假设K个链表一共有N个结点，时间复杂度是O(N*log(K
	 * ))，空间复杂度是O(K)
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		// 为空或者没有元素
		if (lists == null || lists.length < 1) {
			return null;
		}

		// 只有一个元素
		if (lists.length == 1) {
			return lists[0];
		}

		// 创建一个小顶堆，并且使用一个匿名内部类作为比较器
		MinHeap<ListNode> minHeap = new MinHeap<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1 == null) {
					return -1;
				}

				if (o2 == null) {
					return 1;
				}

				return o1.val - o2.val;
			}
		});

		// 将数组中链表的第一个结点入堆
		for (ListNode node : lists) {
			if (node != null) {
				minHeap.add(node);
			}
		}

		// 头结点，作辅助使用
		ListNode head = new ListNode(0);
		// 当前处理的结点
		ListNode curr = head;

		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.deleteTop();

			// 结点的下一个结点不为空就将下一个结点入堆
			if (node.next != null) {
				minHeap.add(node.next);
			}

			curr.next = node;
			curr = node;
		}

		return head.next;
	}

	/**
	 * 小顶堆
	 *
	 * @param <T>
	 */
	private static class MinHeap<T> {
		// 堆中元素存放的集合
		private List<T> items;

		private Comparator<T> comp;

		/**
		 * 构造一个椎，始大小是32
		 */
		public MinHeap(Comparator<T> comp) {
			this(32, comp);
		}

		/**
		 * 造诣一个指定初始大小的堆
		 *
		 * @param size
		 *            初始大小
		 */
		public MinHeap(int size, Comparator<T> comp) {
			items = new ArrayList<>(size);
			this.comp = comp;
		}

		/**
		 * 向上调整堆
		 *
		 * @param index
		 *            被上移元素的起始位置
		 */
		public void siftUp(int index) {
			T intent = items.get(index); // 获取开始调整的元素对象

			while (index > 0) { // 如果不是根元素
				int parentIndex = (index - 1) / 2; // 找父元素对象的位置
				T parent = items.get(parentIndex); // 获取父元素对象
				if (comp.compare(intent, parent) < 0) { // 上移的条件，子节点比父节点小
					items.set(index, parent); // 将父节点向下放
					index = parentIndex; // 记录父节点下放的位置
				} else { // 子节点不比父节点小，说明父子路径已经按从小到大排好顺序了，不需要调整了
					break;
				}
			}

			// index此时记录是的最后一个被下放的父节点的位置（也可能是自身），
			// 所以将最开始的调整的元素值放入index位置即可
			items.set(index, intent);
		}

		/**
		 * 向下调整堆
		 *
		 * @param index
		 *            被下移的元素的起始位置
		 */
		public void siftDown(int index) {
			T intent = items.get(index); // 获取开始调整的元素对象
			int leftIndex = 2 * index + 1; // // 获取开始调整的元素对象的左子结点的元素位置

			while (leftIndex < items.size()) { // 如果有左子结点
				T minChild = items.get(leftIndex); // 取左子结点的元素对象，并且假定其为两个子结点中最小的
				int minIndex = leftIndex; // 两个子节点中最小节点元素的位置，假定开始时为左子结点的位置

				int rightIndex = leftIndex + 1; // 获取右子结点的位置
				if (rightIndex < items.size()) { // 如果有右子结点
					T rightChild = items.get(rightIndex); // 获取右子结点的元素对象
					if (comp.compare(rightChild, minChild) < 0) { // 找出两个子节点中的最小子结点
						minChild = rightChild;
						minIndex = rightIndex;
					}
				}

				// 如果最小子节点比父节点小，则需要向下调整
				if (comp.compare(minChild, intent) < 0) {
					items.set(index, minChild); // 将子节点向上移
					index = minIndex; // 记录上移节点的位置
					leftIndex = index * 2 + 1; // 找到上移节点的左子节点的位置
				} else { // 最小子节点不比父节点小，说明父子路径已经按从小到大排好顺序了，不需要调整了
					break;
				}
			}

			// index此时记录是的最后一个被上移的子节点的位置（也可能是自身），
			// 所以将最开始的调整的元素值放入index位置即可
			items.set(index, intent);
		}

		/**
		 * 向堆中添加一个元素
		 *
		 * @param item
		 *            等待添加的元素
		 */
		public void add(T item) {
			items.add(item); // 将元素添加到最后
			siftUp(items.size() - 1); // 循环上移，以完成重构
		}

		/**
		 * 删除堆顶元素
		 *
		 * @return 堆顶部的元素
		 */
		public T deleteTop() {
			if (items.isEmpty()) { // 如果堆已经为空，就报出异常
				throw new RuntimeException("The heap is empty.");
			}

			T maxItem = items.get(0); // 获取堆顶元素
			T lastItem = items.remove(items.size() - 1); // 删除最后一个元素
			if (items.isEmpty()) { // 删除元素后，如果堆为空的情况，说明删除的元素也是堆顶元素
				return lastItem;
			}

			items.set(0, lastItem); // 将删除的元素放入堆顶
			siftDown(0); // 自上向下调整堆
			return maxItem; // 返回堆顶元素
		}

		/**
		 * 判断堆是否为空
		 *
		 * @return true是空，false否
		 */
		public boolean isEmpty() {
			return items.isEmpty();
		}
	}

	public static void main(String[] args) {
		L023_MergeKSortedLists solution = new L023_MergeKSortedLists();
		ListNode[] lns = new ListNode[4];
		// lns[0] = ListNode.getSortedListNode1();
		lns[1] = ListNode.getSortedListNode2();
		lns[2] = ListNode.getSortedListNode3();
		// System.out.println(lns[0]);
		System.out.println(lns[1]);
		System.out.println(lns[2]);
		ListNode ln = solution.mergeKLists(lns);
		System.out.println(ln);
	}

}
