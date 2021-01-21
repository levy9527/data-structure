package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
public class SortedStack {
  private Deque<Integer> data;
  private Deque<Integer> help;
  public SortedStack() {
    data = new ArrayDeque<>();
    help = new ArrayDeque<>();
  }

  public void push(int val) {
    if (data.isEmpty() || data.peekFirst() >= val) data.offerFirst(val);
    else {
      while (!data.isEmpty() && data.peekFirst() < val) help.offerFirst(data.pollFirst());
      data.offerFirst(val);
      while (!help.isEmpty()) data.offerFirst(help.pollFirst());
    }
  }

  public void pop() {
    data.pollFirst();
  }

  public int peek() {
    return data.peekFirst() == null ? -1 : data.peekFirst();
  }

  public boolean isEmpty() {
    return data.isEmpty();
  }
}
