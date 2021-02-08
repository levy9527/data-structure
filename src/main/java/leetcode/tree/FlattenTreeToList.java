package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenTreeToList {
  public void flatten(TreeNode root) {
    if (root == null) return;

    if (root.left != null) {
      TreeNode node = root.right;
      root.right = root.left;
      root.left = null;

      TreeNode p = root.right;
      while (p.right != null) p = p.right;
      p.right = node;
    }

    flatten(root.left);
    flatten(root.right);
  }
}
