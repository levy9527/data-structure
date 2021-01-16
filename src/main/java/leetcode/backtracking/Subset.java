package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class Subset {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used = new boolean[nums.length];

    Arrays.sort(nums);
    backTrack(nums, 0, used, track, result);
    return result;
  }

  private void backTrack(int[] nums, int begin, boolean[] used,
                         List<Integer> track, List<List<Integer>> result) {

    result.add(new ArrayList<>(track));
    if (begin == nums.length) return;

    for (int i = begin; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

      used[i] = true;
      track.add(nums[i]);
      backTrack(nums, i + 1, used, track, result);
      track.remove(track.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    System.out.println(new Subset().subsets(nums));

  }
}
