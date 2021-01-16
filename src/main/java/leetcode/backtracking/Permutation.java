package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutation {
  /**
   * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
   */
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> permutes = new ArrayList<>(3);
    List<List<Integer>> result = new ArrayList<>();
    backTrack(nums, permutes, result);
    return result;
  }

  private void backTrack(int[] nums, List<Integer> permutes, List<List<Integer>> result) {
    if (permutes.size() == nums.length) {
      result.add(new ArrayList<>(permutes));
      return;
    }

    for (int index = 0; index < nums.length; index++) {
      if (permutes.contains(nums[index])) continue;
      permutes.add(nums[index]);
      backTrack(nums, permutes, result);
      permutes.remove(permutes.size() - 1);
    }
  }

}
