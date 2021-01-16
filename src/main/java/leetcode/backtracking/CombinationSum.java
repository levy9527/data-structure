package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    Arrays.sort(candidates); // ascending order
    backTracking(candidates, 0, target, track, result);

    return result;
  }

  void backTracking(int[] candidates, int beginIndex, int target, List<Integer> track, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(track));
      return;
    }

    for (int i = beginIndex; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (target - candidate < 0) break;

      track.add(candidate);
      backTracking(candidates, i, target - candidate, track, result);
      track.remove(track.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = new int[]{2,3,6,7};
    int target = 7;

    System.out.println(new CombinationSum().combinationSum(candidates, target));
  }
}
