package leetcode.deque;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElement {

  /**
   * T: (M+N), S: (M)
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // 先遍历 nums2, 使用单调栈，得到 hashMap
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> resultMap = new HashMap<>();

    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
        resultMap.put(stack.pollFirst(), nums2[i]);
      }
      stack.offerFirst(nums2[i]);
    }

    while (!stack.isEmpty()) {
      resultMap.put(stack.pollFirst(), -1);
    }

    // 再遍历 nums1，利用hashMap，得到结果
    int[] result = new int[nums1.length];

    for (int i = 0; i< nums1.length; i++) {
      result[i] = resultMap.get(nums1[i]);
    }

    return result;
  }

  /**
   * T: O(N) S: O(N)
   */
  public int[] nextGreaterElements(int[] nums) {
    // 使用 % 解决循环问题，遍历完数组
    // 仍然是使用单调栈

    Deque<Integer> stack = new ArrayDeque<>();
    int len = nums.length;
    int[] result = new int[len];
    // 只能一开始设置默认值
    Arrays.fill(result, -1);

    for (int i = 0; i < len * 2; i++) {
      while (!stack.isEmpty() && nums[i % len] > nums[stack.peekFirst()]) {
        // 此时已可以知道某个元素对应的下一个最大值了
        // 关键是，如何存储？即 result 的下标应该是什么？显然不能用 i % len，
        // 则只能利用栈里元素作文章：栈里存储的是原数组的元素下标
        result[stack.pollFirst()] = nums[i % len];
      }
      stack.offerFirst(i % len);
    }

    // 遍历完后 栈还剩下元素, 但却不能去设置 -1, 因为剩下的元素是混杂着已设值与未设置两种类型的
//    while (!stack.isEmpty())
//      result[stack.pollFirst()] = -1;

    return result;
  }

  public static void main(String[] args) {

    new NextGreaterElement().nextGreaterElements(
      new int[]{100,1,11,1,120,111,123,1,-1,-100}
    );
  }
}
