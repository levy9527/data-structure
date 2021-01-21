package leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用一个栈实现对另一个栈排序
 */
public class StackSort {
  Deque<Integer> data;
  Deque<Integer> help;

  StackSort(Deque<Integer> stack) {
    data = stack;
    help = new ArrayDeque<>();
  }

  public void sort() {
    int size = data.size();

    for (int i = 0; i < size - 1; i++) {
      Integer min = data.pollFirst();

      while (data.size() > i) {
        // 等于是为了排序的稳定性
        if (min >= data.peekFirst()) {
          help.offerFirst(min);
          min = data.pollFirst();
        }
        else help.offerFirst(data.pollFirst());
      }

      data.offerFirst(min);

      while (!help.isEmpty()) data.offerFirst(help.pollFirst());
    }
  }

  public void print() {
    // print, just for debug
    while (data.size() > 0) {
      System.out.print(data.pollFirst());
    }
  }


  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i : new int[]{1, 2, 3, 4, 5}) {
      stack.offerLast(i);
    }

    StackSort stackSort = new StackSort(stack);
    stackSort.sort();
    stackSort.print();
  }
}
