package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class IsSubStructure {
  /**
   * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
   * 判断子结构
   * 使用递归，关键仍然是：递归时，做判断.
   * 关键想清楚：
   * 1. 根与子节点的要求（根不能为空，但子节点可以）
   * 2. 根与子节点的关系：所有的节点都可以看成 根+子节点，这便是递归的基础
   */
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A == null || B == null) return false;

    return traverse(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }

  private boolean traverse(TreeNode A, TreeNode B) {
    if (B == null) return true;
    if (A == null) return false;

    if (A.val == B.val)
      return traverse(A.left, B.left) && traverse(A.right, B.right);

    return false;
  }

  /**
   * https://leetcode-cn.com/problems/subtree-of-another-tree/
   * 判断子树
   * T: O(m * n)
   * S: max(logm, logn)
   */
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return t == null;
    // 判断根或左子树或右子树
    return subTreeTraverse(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean subTreeTraverse(TreeNode root, TreeNode node) {
    if (root == null && node == null) return true;
    if (root != null && node != null && root.val == node.val) return traverse(root.left, node.left) && traverse(root.right, node.right);
    return false;
  }

  /**
   * 使用迭代：费力且未做正确
   */
//  public boolean isSubStructure(TreeNode A, TreeNode B) {
//    // 先遍历两树
//    List<Integer> arrayA = new ArrayList<>();
//    List<Integer> arrayB = new ArrayList<>();
//    traverse(A, arrayA);
//    traverse(B, arrayB);
//
//    if (arrayA.size() < 1 || arrayB.size() < 1 || arrayA.size() < arrayB.size()) return false;
//
//    int firstB = arrayB.get(0);
//    for (int i = 0; i < arrayA.size(); i++) {
//      if (arrayA.get(i) != firstB) continue;
//
//      int j = 1;
//      for (; j < arrayB.size(); j++) {
//        if (i + 1 < arrayA.size() && arrayA.get(i + 1).equals(arrayB.get(j))) i++;
//        else break;
//      }
//
//      if (j == arrayB.size()) return true;
//    }
//
//    return false;
//  }

  private void traverse(TreeNode root, List<Integer> array) {
    if (root == null) return ;

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerLast(root);

    while (!deque.isEmpty()) {
      TreeNode node = deque.pollFirst();
      array.add(node.val);

      if (node.left != null) deque.offerLast(node.left);
      if (node.right != null) deque.offerLast(node.right);
    }

  }

  public static void main(String[] args) {
    TreeNode A = new TreeNode(new Integer[]{10,12,6,8,3,11});
    TreeNode B = new TreeNode(new Integer[]{10,12,6,8});

    new IsSubStructure().isSubStructure(A, B);
  }

}
