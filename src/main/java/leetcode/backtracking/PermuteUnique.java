package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUnique {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used = new boolean[nums.length];

    Arrays.sort(nums);
    backTracking(nums, used, track, result);

    return result;
  }

  void backTracking(int[] nums, boolean[] used, List<Integer> track, List<List<Integer>> result) {
    if (track.size() == nums.length) {
//      if (!result.contains(track))
      result.add(new ArrayList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i-1])) continue;

      track.add(nums[i]);
      used[i] = true;
      backTracking(nums, used, track, result);
      used[i] = false;
      track.remove(track.size() - 1);
    }
  }

  /**
   * 兄弟节点已撤回，无法利用 used 进行比较
   */
  boolean isDuplicate(boolean[] used, int[] nums, int num) {
    boolean result = false;
    for (int i = 0; i < used.length; i++) {
      if (used[i] && nums[i] == num) {
        result = true;
        break;
      }
    }
    return result;
  }
}
