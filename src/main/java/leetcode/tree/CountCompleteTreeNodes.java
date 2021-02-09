package leetcode.tree;

public class CountCompleteTreeNodes {
  /**
   * 利用左子树是满二叉树的性质，根据高度直接求节点，剩下的则一个个求
   * T: O(logn * logn)
   * S: O(logn)
   */
  public int countNodes(TreeNode root) {
    int heightLeft = 0, heightRight = 0;
    TreeNode p = root;

    while (p != null) {
      heightLeft++;
      p = p.left;
    }

    p = root;
    while (p != null) {
      heightRight++;
      p = p.right;
    }

    if (heightLeft == heightRight) return (int)Math.pow(2, heightLeft) - 1;

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  /**
   * 使用成员变量，更节省内存空间
   * 把变量放到函数里，会增加系统函数栈的内存开销
   */
  int count = 0;
  /**
   * 普通做法：T: O(N) S: O(logN)
   */
  public int countNodes_(TreeNode root) {
    //  int[] counter = new int[1];
    //  traverse(root, counter);
    //  return counter[0];
    traverse(root);
    return count;
  }

  void traverse(TreeNode root) {
    if (root == null) return ;
    traverse(root.left);
    traverse(root.right);
    count++;
  }

  void traverse(TreeNode root, int[] counter) {
    if (root == null) return ;
    traverse(root.left, counter);
    traverse(root.right, counter);
    counter[0]++;
  }
}
