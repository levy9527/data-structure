package leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * S: O(n) T: O(n) (n/2 省去了常量)
 */
public class Print {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>(0);
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    int counter = 1;
    while (!queue.isEmpty()) {
//      if (result.size() == counter) result.add(new ArrayList<>());
      int size = queue.size();
      LinkedList<Integer> list = new LinkedList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        if (counter % 2 == 1)  list.addLast(node.val);
        else list.addFirst(node.val);

        if (node.left != null) queue.offerLast(node.left);
        if (node.right != null) queue.offerLast(node.right);
      }
      result.add(list);
      counter++;
    }


    return result;
//   return array.stream().mapToInt(Integer::intValue).toArray();
//    int[] result = new int[array.size()];
//    for (int i = 0; i < array.size(); i++) {
//      result[i] = array.get(i);
//    }
  }

  public static void main(String[] args) {

  }
}
