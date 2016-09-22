package leetcode;

/* Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *        1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
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
}
