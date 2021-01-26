package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/submissions/detail/140828245/
 */
public class ThreeSum {

  /**
   * 双指针
   * T: O(n^2) S:
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    // 先排序，为去重为准备
    Arrays.sort(nums);

    for (int first = 0; first < nums.length - 2; first++) {
      // 去重
      if (first > 0 && nums[first] == nums[first - 1]) continue;
      int target = -nums[first];
      int second = first + 1;
      int third = nums.length - 1;

      for (; second < nums.length - 1; second++) {
        // 去重
        if (second > first + 1 && nums[second] == nums[second - 1]) continue;

        // 移动右指针
        while (second < third && nums[second] + nums[third] > target) third--;
        if (second == third) break;

        // 找到了
        if (target == nums[second] + nums[third]) {
          List<Integer> list = new ArrayList<>(3);
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          result.add(list);
        }
      }
    }

    return result;
  }

  /**
   * 超时
   */
  public List<List<Integer>> threeSum_slow(int[] nums) {

    boolean[] used = new boolean[nums.length];
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    Arrays.sort(nums);
    backTracking(nums, 0, used, track, result);
    return result;
  }

  void backTracking(int[] nums, int begin, boolean[] used, List<Integer> track, List<List<Integer>> result) {
    if (track.size() == 3) {
      int sum = 0;
      for (int n : track) sum += n;
      if (sum == 0) {
        result.add(new ArrayList<>(track));
      }
      return;
    }

    for (int i = begin; i < nums.length; i++) {
      // 判断不重复
      if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;

      used[i] = true;
      track.add(nums[i]);
      backTracking(nums, i + 1, used, track, result);
      track.remove(track.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    new ThreeSum().threeSum_slow(new int[]{-1,0,1,2,-1,-4});
  }
}
