package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 栈是后进先出，则模拟栈时，队列的最后一个元素，应该先出。
 * 注意两个队列的变量要不断交换
 */
public class QueueStack {
  Deque<Integer> in;
  Deque<Integer> out;
  public QueueStack() {
    in = new ArrayDeque<>();
    out = new ArrayDeque<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if (out.size() > 0) {
      in.offerLast(out.pollFirst());
    }
    in.offerLast(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    int result = this.top();

    out.removeFirst();
    return result;
  }

  /** Get the top element. */
  public int top() {
    int limit = 1;
    if (out.size() < limit) {
      while (in.size() > limit) {
        out.offerLast(in.pollFirst());
      }
      // swap
      Deque<Integer> temp = in;
      in = out;
      out = temp;
    }

    // may produce exception
    return out.peekFirst();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }
}
