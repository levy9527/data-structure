package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] T) {
    // 使用单调栈，并且逆序遍历数组，假设当前是最高温度
    // 当然，因为此题特殊值是 0，与数组的默认值相同，则顺序遍历也行，时间复杂度是一样的。
    // 但一般而言，顺序遍历时间复杂度要比逆序遍历稍微逊色
    int len = T.length;
    int[] result = new int[len];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = len - 1; i >= 0; i--) {
      while (!stack.isEmpty() && T[stack.peekFirst()] <= T[i]){
        stack.pollFirst();
      }
      result[i] = stack.isEmpty() ? 0 : stack.peekFirst() - i;
      stack.offerFirst(i);
    }

    return result;
  }
}
