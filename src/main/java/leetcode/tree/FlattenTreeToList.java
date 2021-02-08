package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenTreeToList {
  public void flatten(TreeNode root) {
    if (root == null) return;

    // 前序遍历里，可以做很多事！不仅仅只是交换一下指针
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
