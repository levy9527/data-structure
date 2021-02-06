package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
public class IsCompleteTree {

  /**
   * 层次遍历: 从上到下，则特点是：
   * 一旦遇到空，则后面的都为空。
   * 则如果出现一次空节点后，后续仍出现数字，则不是完全二叉树
   */
  public boolean isCompleteTree(TreeNode root) {
    if (root == null) return true;
    boolean hasEmpty = false;

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerLast(root);

    while (!deque.isEmpty()) {
      TreeNode node = deque.pollFirst();
      if (hasEmpty) {
        if (node.left != null || node.right != null) return false;
      }
      else {
        if (node.left != null && node.right != null) {
          deque.offerLast(node.left);
          deque.offerLast(node.right);
          continue;
        }
        hasEmpty = true;
        if (node.left != null) {
          deque.offerLast(node.left);
        }
        else if (node.right != null) return false;
      }
    }

    return true;
  }

  /**
   * 从正常的形态来看，有两种情况：
   * 1. 就是一棵满二叉树，则所有子树都满足：左右叶节点同时为空
   * 2. 当出现一个左叶子节点不为空、右叶子节点为空时，后续的叶子节点都满足情况1
   *
   * 但怎么判断是否在倒数第二层？
   */
  boolean hasEmptyRight = false;
  public boolean isCompleteTree_recursively(TreeNode root) {
    if (root == null || root.left == null && root.right == null) return true;

    if (root.left != null && root.right != null)
      return isCompleteTree(root.left) && isCompleteTree(root.right);

    if (root.left != null && !hasEmptyRight) {
      hasEmptyRight = true;
      return root.left.left == null && root.left.right == null;
    }

    return false;
  }
}
