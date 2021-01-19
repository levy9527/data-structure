package leetcode.list;

import collection.BinarySortingTree;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class TreeToDoublyList {
  private BinarySortingTree dummy = new BinarySortingTree(-1);
  private BinarySortingTree prev = dummy;

  /**
   *
   * 注意题目要求 head.prev = tail; tail.next = head;
   * T: O(n), S: O(n)
   * 最差情况下，树退化为链表，递归深度达到 N，系统使用  O(N) 栈空间。
   */
  public BinarySortingTree treeToDoublyList(BinarySortingTree root) {
    if (root == null) return null;

    traverse(root);

    // 遍历完后，pre 就是最后一个节点
    prev.right = dummy.right;
    dummy.right.left = prev;

//    while (p != null) {
//      if (p.right != null) p = p.right;
//      else {
//        p.right = dummy.right;
//        dummy.right.left = p;
//        break;
//      }
//    }

    return dummy.right;
  }

  void traverse(BinarySortingTree root) {
    if (root.left != null) traverse(root.left);

    prev.right = root;
    root.left = prev;
    prev = prev.right;

    if (root.right != null) traverse(root.right);
  }

  public static void main(String[] args) {
    BinarySortingTree tree = new BinarySortingTree(4);
    tree.addNode(2);
    tree.addNode(5);
    tree.addNode(1);
    tree.addNode(3);

    System.out.println(new TreeToDoublyList().treeToDoublyList(tree));
  }
}
