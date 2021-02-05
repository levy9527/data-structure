package leetcode.tree;

class MaxBSTDo {
  TreeNode node = null;
  int size = 0;
  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;

  public MaxBSTDo() {
  }

  public MaxBSTDo(TreeNode node, int size, int min, int max) {
    this.node = node;
    this.size = size;
    this.min = min;
    this.max = max;
  }
}

public class MaxBST {

  /**
   * 找到二叉树中最大搜索二叉子树
   * 关键是：
   * 1.使用树形dp套路，递归处理；
   * 2.注意叶子节点的处理逻辑: min 与 max 都是自己的值
   * T: O(n)
   * S: O(logn)
   */
  public TreeNode getMaxBST(TreeNode root) {
    // 使用后序遍历，自底向上
    // left < root < right
    // 需要的信息: 节点，子树大小，最大值，最小值
    return traverse(root).node;
  }

  MaxBSTDo traverse(TreeNode root) {
    if (root == null) return new MaxBSTDo();

    MaxBSTDo leftDo = traverse(root.left);
    MaxBSTDo rightDo = traverse(root.right);

    // 叶子节点，min 及 max 返回的是自己的值，故下面的语句不对
//    if (leftDo.node == null && rightDo.node == null) return new MaxBSTDo();
    int size = Math.max(leftDo.size, rightDo.size);

    // 这个写法是兼容处理 叶子节点的情况
    int min = Math.min(root.val, Math.min(leftDo.min, rightDo.min));
    int max = Math.max(root.val, Math.max(leftDo.max, rightDo.max));
    TreeNode node = leftDo.size > rightDo.size ? leftDo.node : rightDo.node;

    // 有一个为空，都不为空，都不为空且符合搜索树
//    if (leftDo.node != null && rightDo.node != null) {
//    }
    if (leftDo.node == root.left &&
      rightDo.node == root.right &&
      leftDo.max < root.val &&
      root.val > rightDo.min)
      return new MaxBSTDo(root, size + 1, min, max);

    return new MaxBSTDo(node, size, min, max);

  }
}
