package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subset {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    backTrack(nums, 0, track, result);
    return result;
  }

  private void backTrack(int[] nums, int begin,
                         List<Integer> track, List<List<Integer>> result) {

    result.add(new ArrayList<>(track));
    if (begin == nums.length) return;

    for (int i = begin; i < nums.length; i++) {
      track.add(nums[i]);
      backTrack(nums, i + 1, track, result);
      track.remove(track.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    System.out.println(new Subset().subsets(nums));

  }
}
