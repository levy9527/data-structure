package leetcode.tree;

public class IsSymmetric {
  /**
   * 一定要使用套路：root/root.left/root.right 三个节点去想，再多的，就是用递归。
   * 这里我的误区是 root/root.left/root.left/left 想多了一层
   */
  public boolean isSymmetric(TreeNode root) {
    return root == null || traverse(root.left, root.right);
  }

  private boolean traverse(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left != null && right != null && left.val == right.val) return traverse(left.left, right.right) && traverse(left.right, right.left);
    return false;

  }

  private boolean traverse(TreeNode root) {
    if (root == null || root.left == null && root.right == null ) return true;
    if (root.left != null && root.right != null) {
      if (root.left.left == root.right.right && root.left.right == root.right.left ||
        root.left.left != null && root.left.left.val == root.right.right.val &&
          root.left.right != null && root.left.right.val == root.right.left.val) return true;
    }
    return false;
  }


  public static void main(String[] args) {
    new IsSymmetric().isSymmetric(new TreeNode(new Integer[]{1,2,2,3,4,4,3}));
  }
}
