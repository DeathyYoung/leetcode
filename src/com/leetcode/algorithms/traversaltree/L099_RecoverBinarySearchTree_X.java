package com.leetcode.algorithms.traversaltree;

import com.leetcode.algorithms.TreeNode;

public class L099_RecoverBinarySearchTree_X {
	/**
	 * 99. Recover Binary Search Tree
	 * <p>
	 * Total Accepted: 57990 Total Submissions: 210143 Difficulty: Hard
	 * <p>
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * 
	 * Recover the tree without changing its structure.
	 * 
	 * Note: A solution using O(n) space is pretty straight forward. Could you
	 * devise a constant space solution?
	 * 
	 * 
	 * Tags: Tree Depth-first Search 遍历变种
	 */
	TreeNode first = null, second = null, pre = null;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		dfs(root);
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}

	}

	public void dfs(TreeNode root) {
		if (root.left != null)
			dfs(root.left);
		if (pre != null && pre.val > root.val) {
			if (first == null)
				first = pre;
			if (first != null)
				second = root;
		}
		pre = root;
		if (root.right != null)
			dfs(root.right);
	}
	
	/**
	* <p> Morris traversal Java solution constance space, no stack, no recursion
	*/ 
	public void recoverTree2(TreeNode root) {
        TreeNode crt = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        while (crt != null) {
            if (crt.left == null) {
                if (prev != null && prev.val > crt.val) {
                    if (first == null) {
                        first = prev;
                        second = crt;
                    } else {
                        second = crt; 
                    }
                }
                prev = crt;
                crt = crt.right;
            } else {
                TreeNode temp = crt.left;
                while (temp.right != null && temp.right != crt) {
                    temp = temp.right;
                }
                
                if (temp.right == null) {
                    temp.right = crt;
                    crt = crt.left;
                } else { 
                    if (prev.val > crt.val) {
                        if (first == null) {
                            first = prev;
                            second = crt;
                        } else {
                            second = crt; 
                        }
                    }
                    prev = crt;
                    temp.right = null;
                    crt = crt.right;
                }
            }
        }
        if (first != null) {
            swap(first, second);
        }
    }
    
    private void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

	public static void main(String[] args) {
		L099_RecoverBinarySearchTree_X solution = new L099_RecoverBinarySearchTree_X();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
