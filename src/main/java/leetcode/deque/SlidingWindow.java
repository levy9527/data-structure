package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindow {

  /**
   // in: last >= val, 否则，pollLast 直到满足条件或为空，因为如果 val > last，则 last 也没有存储的必要了
   // out: peek 过期，则 pop
   * T: O(n), S: O(k)
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> max = new ArrayDeque<>();

    int i = 0;
    for (; i < nums.length; i++) {
      // 先处理输出
      if (i >= k) {
        Integer peek = max.peekFirst();
        if (peek <= i - k) max.pollFirst();
      }

      Integer last = max.peekLast();

      if (last == null || nums[last] >= nums[i])
        max.offerLast(i);
      else {
        while (last != null && nums[last] < nums[i]) {
          last = max.pollLast();
        }
        if (last != null) max.offerLast(last);
        max.offerLast(i);
      }

      if (i >= k - 1)
        result[i - k + 1] = nums[max.peekFirst()];
    }

    return result;
  }

  /**
   * still too slow...
   */
  public int[] maxSlidingWindow_sortedStack(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    SortedStack max = new SortedStack();
    max.push(Integer.MIN_VALUE);

    // init stack
    int i = 0;
    for (; i < k; i++) {
      max.push(nums[i]);
    }
    result[0] = max.last();

    // maintain stack
    for (int j = 1; i < nums.length; i++, j++) {
      max.remove(nums[j - 1]);
      max.push(nums[i]);
      result[j] = max.last();
    }

    return result;
  }

  /**
   * slow
   * (nums.length - k + 1) * k
   */
  public int[] maxSlidingWindow_twoIteration(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];

    for (int start = 0; start + k <= nums.length; start++) {
      int max = Integer.MIN_VALUE;

      for (int i = start; i < start + k; i++) {
        if (nums[i] > max) max = nums[i];
      }

      result[start] = max;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
    new SlidingWindow().maxSlidingWindow(nums, 3);
    new SlidingWindow().maxSlidingWindow_sortedStack(nums, 3);
  }
}
