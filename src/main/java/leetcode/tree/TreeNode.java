package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }

  TreeNode(Integer[] array) {
    if (array.length < 1 || array[0] == null) return;

    val = array[0];
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offerLast(this);

    for (int i = 1; i < array.length; i++) {
      TreeNode node = queue.pollFirst();

      if (array[i] != null) {
        node.left = new TreeNode(array[i]);
        queue.offerLast(node.left);
      }

      i++;
      if (i == array.length) break;

      if (array[i] != null) {
        node.right = new TreeNode(array[i]);
        queue.offerLast(node.right);
      }

    }

  }

  @Override
  public String toString() {
    return val + "";
  }
}
