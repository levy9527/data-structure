package leetcode.tree;

/**
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
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

  public static void main(String[] args) {
    new FindKInBST().kthSmallest(new TreeNode(new Integer[]{3,1,4,null,2}), 1);
  }

}
