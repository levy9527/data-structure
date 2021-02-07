package leetcode.tree;

public class FindKInBST {
  /**
   * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
   */
  public int kthSmallest(TreeNode root, int k) {
    int[] result = new int[1];
    int[] counter = new int[1];
    counter[0] = k;

    findSmall(root, counter, result);
    return result[0];
  }

  private void findSmall(TreeNode root, int[] counter, int[] result) {
    if (root == null) return;
    // 中序遍历，是升序

    findSmall(root.left, counter, result);
    if (counter[0]-- == 1) {
      result[0] = root.val;
      return ;
    }

    findSmall(root.right, counter, result);
  }

  /**
   *
   * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
   * BST 中序遍历：是升序。如果要找最大的，则应该是降序。怎么降序呢？右根左！
   */
  public int kthLargest(TreeNode root, int k) {
    int[] counter = new int[]{k};

    return findLarge(root, counter);
  }

  public int findLarge(TreeNode root, int[] counter) {
    if (root == null) return -1;

    int right = findLarge(root.right, counter);
    if (counter[0] == 0) return right;
    if (counter[0]-- == 1) return root.val;

    return findLarge(root.left, counter);
  }

  public static void main(String[] args) {
    new FindKInBST().kthSmallest(new TreeNode(new Integer[]{3,1,4,null,2}), 1);
  }

}
