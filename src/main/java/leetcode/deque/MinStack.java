package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 压栈时，重复压入最小值即可, 保证 data 与 min 两个栈的高度一致
 */
public class MinStack {
  Deque<Integer> data;
  Deque<Integer> min;
  /** initialize your data structure here. */
  public MinStack() {
    data = new ArrayDeque<>();
    min = new ArrayDeque<>();
  }

  public void push(int x) {
    data.offerLast(x);

    Integer last = min.peekLast();
    if (last == null || last > x) min.offerLast(x);
    else min.offerLast(last);
  }

  public void pop() {
    data.pollLast();
    min.pollLast();
  }

  public int top() {
    return data.peekLast();
  }

  public int getMin() {
    return min.peekLast();
  }
}
