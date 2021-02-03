package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    traverse(root, targetSum, track, result);
    return result;
  }

  private void traverse(TreeNode root, int targetSum, List<Integer> track, List<List<Integer>> result) {
    // 不能剪枝, 一定要到叶子节点
    if (root == null) return;

    // 前序遍历
    targetSum -= root.val;
    // 中止条件 在最底层叶子节点 + 满足值
    if (root.left == null && root.right == null && targetSum == 0) {
      track.add(root.val);
      result.add(new ArrayList<>(track));
      track.remove(track.size() - 1);
      return;
    }

    track.add(root.val);
    traverse(root.left, targetSum, track, result);
    traverse(root.right, targetSum, track, result);
    track.remove(track.size() - 1);
  }
}
