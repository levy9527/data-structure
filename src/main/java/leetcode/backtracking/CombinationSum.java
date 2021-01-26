package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used = new boolean[candidates.length];

    Arrays.sort(candidates); // ascending order
    backTracking(candidates, 0, target, used, track, result);

    return result;
  }

  void backTracking(int[] candidates, int beginIndex, int target, boolean[] used, List<Integer> track, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(track));
      return;
    }

    for (int i = beginIndex; i < candidates.length; i++) {
      int candidate = candidates[i];

      if (used[i] || (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])) continue;
      if (target - candidate < 0) break;

      used[i] = true;
      track.add(candidate);
      // 对常量数字，可以通过迭代的形式不断做减法，而不是做加法，从而减少变量
      backTracking(candidates, i, target - candidate, used, track, result);
      track.remove(track.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    int[] candidates = new int[]{2,3,6,7};
    int target = 7;

    System.out.println(new CombinationSum().combinationSum(candidates, target));
  }
}
