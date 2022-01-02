package algorithm;

import java.util.*;

public class Sort {
  // 其实可以用 set...
  public int findRepeatNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    int result = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        result = entry.getKey();
        break;
      }
    }

    return result;
  }

  /**
   * @deprecated
   */
  public boolean containsNearbyDuplicateSlow(int[] nums, int k) {
    // 这个是不能用排序的
    // 使用 hashMap<num, i>, T: O(N), A:O(N)
    // 利用滑动窗口思想，使用 set 更高效！
//    Set<Integer> set = new HashSet<>();

    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean result = false;
    for (int i = 0; i < nums.length; i++) {
      List<Integer> list = map.get(nums[i]);
      if (list == null) {
        list = new ArrayList<>();
        list.add(i);
        map.put(nums[i], list);
        continue;
      }
      else {
        for (int j : list) {
          if (i - j <= k) {
            result = true;
            break;
          }
        }
      }
      list.add(i);
    }

    return result;
  }

  /**
   * https://leetcode-cn.com/problems/contains-duplicate-ii/
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    // 这个是不能用排序的
    // 使用 HashSet<num>, T: O(N), A:O(k)
    Set<Integer> set = new HashSet<>();
    boolean result = false;

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        // 直接短路返回
        return true;
      }
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
}

  public static void main(String[] args) {
    new Sort().findRepeatNumber(new int[]{2, 3, 2, 0, 2, 5, 3});
  }
}
