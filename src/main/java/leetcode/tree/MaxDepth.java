package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * T: O(n) S: O(n)
 */
public class MaxDepth {
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
