package leetcode.tree;


import java.util.ArrayList;
import java.util.List;

class ReturnType {
  int min;
  int max;
  boolean isValidBST;

  public ReturnType(int min, int max, boolean isValidBST) {
    this.min = min;
    this.max = max;
    this.isValidBST = isValidBST;
  }
}

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class isBST {

  /**
   * 仍是中序遍历的思路：比较当前值是否大于前一个值即可
   * 优势在于：使用系统栈，并且只使用一个辅助变量
   * 注意：edge case 节点值是系统最小值，故不能依赖系统常量值（如果追求完美的话）
   */
  Integer prev = null;
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    // 左节点
    if (!isValidBST(root.left)) return false;

    // 必须从第二个值开始比
    if (prev != null && root.val <= prev) return false;

    prev = root.val;

    // 右节点
    return isValidBST(root.right);
  }

  /**
   * 必须先完整遍历一遍，且手动开辟了辅助空间
   * T: O(n)
   * S: O(n)
   */
  public boolean isValidBST_slow(TreeNode root) {
    if (root == null) return true;

    boolean result = true;
    List<Integer> array = new ArrayList<>();
    // 中序遍历
    traverse(root, array);

    for (int i = 1; i < array.size(); i++) {
      if (array.get(i) < array.get(i - 1)) {
        result = false;
        break;
      }
    }

    return result;
  }

  private void traverse(TreeNode root, List<Integer> array) {
    if (root == null) return;

    if (root.left != null) traverse(root.left, array);

    array.add(root.val);

    if (root.right != null) traverse(root.right, array);
  }

  /**
   * 后序遍历，默认设置边界值的做法，逻辑没有问题，但实践中会有 edge case
   * [-2147483648,null,2147483647] 无法通过
   * @deprecated
   */
  public boolean isValidBST_deprecated(TreeNode root) {
    if (root != null && root.left == null && root.right == null) return true;
    // 使用后序遍历
    // 判断是否满足 left.val < root.val && root.val < right.val
    // 终止条件 root == null return true
    return traverse(root).isValidBST;
  }

  private ReturnType traverse(TreeNode root) {
    if (root == null) return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);

    ReturnType leftVal = traverse(root.left);
    if (!leftVal.isValidBST) return leftVal;

    ReturnType rightVal = traverse(root.right);
    if (!rightVal.isValidBST) return rightVal;

    if (leftVal.max < root.val && rightVal.min > root.val) {
      return new ReturnType(Math.min(leftVal.min, root.val),
        Math.max(rightVal.max, root.val), true);
    }
    return new ReturnType(Integer.MAX_VALUE,  Integer.MIN_VALUE, false);
  }
}
