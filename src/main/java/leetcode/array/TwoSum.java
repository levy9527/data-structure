package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.get(target - nums[i]) != null) return new int[]{i, map.get(target - nums[i])};
      map.put(nums[i], i);
    }

    return new int[0];
  }

  /**
   * 想复杂了，不用理会重复的key问题。
   * 因为：如果两个相同的 key 可以求出 target，则第二个 key 还未 put 进去就得出结果了
   */
  public int[] twoSum_(int[] nums, int target) {

    Map<Integer, String> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.merge(nums[i], i + "", (old, val) -> old + "," + val);
    }

    for (int i = 0; i < nums.length; i++) {
      String indexs = map.get(target - nums[i]);
      if (indexs == null) continue;

      if (indexs.contains(",")) {
        String[] arr = indexs.split(",");
        return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
      }
      else if (nums[i] != target - nums[i]){
        return new int[]{i, Integer.parseInt(indexs)};
      }
    }

    return new int[0];
  }

  public static void main(String[] args) {
    new TwoSum().twoSum(new int[]{3,2,4}, 6);
  }
}
