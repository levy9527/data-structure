package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combination {
  /**
   * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
   */
  public List<List<Integer>> combine(int n, int k) {
    if (k < 1 || k > n) return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used = new boolean[n];

    backTracking(n, k, 0, used, track, result);

    return result;
  }

  private void backTracking(int n, int k, int begin, boolean[] used,
                            List<Integer> track, List<List<Integer>> result) {
    if (track.size() == k) {
      result.add(new ArrayList<>(track));
      return;
    }

    // TODO 可以剪枝
    for (int i = begin; i < n; i++) {
      if (used[i]) continue;

      track.add(i + 1);
      used[i] = true;
      backTracking(n, k, i + 1, used, track, result);
      used[i] = false;
      track.remove(track.size() - 1);
    }
  }
}

