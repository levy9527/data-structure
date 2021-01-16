package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class TheKthPermutation {
  public String getPermutation(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>(n);

    backTrack(n, k, 0, track, result);

    StringBuilder builder = new StringBuilder();
    for (int in : result.get(0)) {
      builder.append(in);
    }

    return builder.toString();
  }

  private void backTrack(int n, int k, int index, List<Integer> track, List<List<Integer>> result) {
    if (index == n) {
      result.add(new ArrayList<>(track));
      return;
    }

    for (int i = 0; i < n; i++) {
      int num = i + 1;
      if (track.contains(num)) continue;

      int nodeNum = factorial(n - 1 - track.size());
      // 对大数常量数字，可以通过迭代的形式不断做减法，而不是做加法，从而减少变量
      if (nodeNum < k) {
        k -= nodeNum;
        continue;
      }

      track.add(num);
      backTrack(n, k, index + 1, track, result);
      return;
    }
  }

  private int factorial(int n) {
    if (n <= 2) return n;
    return n * factorial(n - 1);
  }
}
