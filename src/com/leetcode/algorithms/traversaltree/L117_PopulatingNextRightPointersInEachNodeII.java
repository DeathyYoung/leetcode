package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeLinkNode;

public class L117_PopulatingNextRightPointersInEachNodeII {
	/**
	 * 117. Populating Next Right Pointers in Each Node II
	 * <p>
	 * Total Accepted: 68658 Total Submissions: 207674 Difficulty: Hard
	 * <p>
	 * Follow up for problem "Populating Next Right Pointers in Each Node".
	 * 
	 * What if the given tree could be any binary tree? Would your previous
	 * solution still work?
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. For example, Given the following
	 * binary tree,
	 * 
	 * <pre>
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	 * </pre>
	 * 
	 * After calling your function, the tree should look like:
	 * 
	 * <pre>
	               1       -> NULL
	         /           \
	        2     ->      3   -> NULL
	     /    \        /     \
	    4  ->  5  ->  6  ->   7 -> NULL
	   /                     / \
	  8-> ->  ->  ->  ->  ->14->15 -> NULL
	 * </pre>
	 * 
	 * Tags: Tree Depth-first Search
	 * 
	 */
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		TreeLinkNode p = root.next;

		while (p != null) {// root的右侧兄弟节点，寻找其在下一层的最左节点p
			if (p.left != null) {
				p = p.left;
				break;
			}
			if (p.right != null) {
				p = p.right;
				break;
			}
			p = p.next;
		}

		if (root.right != null) {// 如果root的右子树不空，直接指向p
			root.right.next = p;
		}

		if (root.left != null) {// 如果root左子树不空，指向右边
			root.left.next = root.right == null ? p : root.right;
		}
		// 现在root.left和root.right的next指向都对了，开始递归处理
		connect(root.right);
		connect(root.left);
	}

	public static void main(String[] args) {
		L117_PopulatingNextRightPointersInEachNodeII solution = new L117_PopulatingNextRightPointersInEachNodeII();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
