package leetcode.tree;

import java.util.*;

public class Traversal {
  /**
   * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
   * 递归方法更快，更节省内存
   * T: O(n) S: O(logn)
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
//    preOrder(root, result);

    Deque<TreeNode> stack = new LinkedList<>();
    if (root != null) stack.offerFirst(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      result.add(node.val);

      if (node.right != null) stack.offerFirst(node.right);
      if (node.left != null) stack.offerFirst(node.left);
    }

    return result;
  }

  private void preOrder(TreeNode root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);

    if (root.left != null) preOrder(root.left, result);
    if (root.right != null) preOrder(root.right, result);
  }

  /**
   * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
   * 递归方法更快，更节省内存
   * T: O(n) S: O(logn)
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
//    inOrder(root, result);

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.offerFirst(node);
        node = node.left;
      }

      node = stack.pollFirst();
      result.add(node.val);
      node = node.right;
    }

    return result;
  }

  private void inOrder(TreeNode root, List<Integer> result) {
    if (root == null) return;

    if (root.left != null) inOrder(root.left, result);
    result.add(root.val);
    if (root.right != null) inOrder(root.right, result);
  }


  /**
   * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
   * 递归方法更快，更节省内存
   * T: O(n) S: O(logn)
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
//    postOrder(root, result);

    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root, prev = null;
    while (node != null || !stack.isEmpty()) {
      // 遍历至左节点为空
      while (node != null) {
        stack.offerFirst(node);
        node = node.left;
      }

      node = stack.peekFirst();
      if (node.right == null || node.right == prev) {
        result.add(node.val);
        prev = node;
        stack.pollFirst();
        // 避免再次进入遍历左节点的循环
        node = null;
      }
      else {
        node = node.right;
      }
    }

    return result;
  }

  private void postOrder(TreeNode root, List<Integer> result) {
    if (root == null) return;

    if (root.left != null) postOrder(root.left, result);
    if (root.right != null) postOrder(root.right, result);
    result.add(root.val);
  }

  /**
   * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
   * T: O(n) S: O(n)
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();

    if (root != null) queue.offerLast(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        list.add(node.val);

        if (node.left != null) queue.offerLast(node.left);
        if (node.right != null) queue.offerLast(node.right);
      }

      result.add(list);
    }

    return result;
  }

  /**
   * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
   */
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    new Traversal().postorderTraversal(root);
  }
}
