package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/submissions/
 * 栈是先进后出，也即逆序；再来一个栈，就正序了，可以先进先出。
 * 注意只能一个栈进，另一个栈出。
 */
public class StackQueue {
  Deque<Integer> in;
  Deque<Integer> out;
  public StackQueue() {
    in = new ArrayDeque<>();
    out = new ArrayDeque<>();
  }

  public void appendTail(int value) {
    in.offerLast(value);
  }

  public int deleteHead() {
    if (out.isEmpty()) {
      if (in.isEmpty()) return -1;

      while (in.size() > 0) {
        out.offerLast(in.pollLast());
      }
    }
    return out.pollLast();
  }
}
