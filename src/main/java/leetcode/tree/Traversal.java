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
   * T: O(n) S: O(logn)
   * 但不知为何，leetcode 上消耗内存更大，可能数据缺少准确性
   */
  public List<List<Integer>> levelOrderRecursively(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderDfs(root, 0, result);
    return result;
  }

  private void levelOrderDfs(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return;
    if (result.size() == level) result.add(new ArrayList<>());

    if (root.left != null) levelOrderDfs(root.left, level + 1, result);

    // 前序/中序遍历都行
    result.get(level).add(root.val);

    if (root.right != null) levelOrderDfs(root.right, level + 1, result);
  }


  /**
   * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
   * T: O(nlogn) S: O(logn)
   */
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    List<Location> locations = new ArrayList<>();
    verticalDfs(root, 0, 0, locations);

    Collections.sort(locations);

    int prevX = Integer.MIN_VALUE;
    for (Location location : locations) {
      if (prevX != location.getX()) result.add(new ArrayList<>());

      prevX = location.getX();
      result.get(result.size() - 1).add(location.getVal());
    }

    return result;
  }

  private void verticalDfs(TreeNode root, int x, int y, List<Location> locations) {
    if (root == null) return;

    if (root.left != null) verticalDfs(root.left, x - 1, y - 1, locations);
    locations.add(new Location(root.val, x, y));

    if (root.right != null) verticalDfs(root.right, x + 1, y - 1, locations);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

//    new Traversal().postorderTraversal(root);
//    new Traversal().levelOrderRecursively(root);

    Integer[] nodes = new Integer[]{0,10,1,null,null,2,4,3,5,null,null,6,null,7,9,8,null,null,null,null,11,null,null,12};
    new Traversal().verticalTraversal(new TreeNode(nodes));
  }
}

class Location implements Comparable<Location>{
  private int val;
  private int x;
  private int y;

  Location(int val, int x, int y) {
    this.val = val;
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Location location) {
    if (this.getX() != location.getX())
      return this.getX() - location.getX();
    else if (this.getY() != location.getY())
      return -this.getY() + location.getY();
    return this.getVal() - location.getVal();
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
