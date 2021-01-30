package leetcode.tree;

public class MaxDepth {

  /**
   *
   * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
   * 关键在于 遍历的同时，求 depth
   * T: O(n) S: O(logn)
   */
  public boolean isBalanced(TreeNode root) {
    return traverse(root) != -1;
  }

  private int traverse(TreeNode root) {
    if (root == null) return 0;

    int left = traverse(root.left);
    if (left == -1) return -1;

    int right = traverse(root.right);
    if (right == -1) return -1;

    return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
  }


  /**
   * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
   * T: O(n) S: O(logn)
   */
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    new MaxDepth().maxDepth(new TreeNode(1));
  }
}
