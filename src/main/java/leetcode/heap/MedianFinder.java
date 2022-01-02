package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/submissions/
 */
public class MedianFinder {
  private PriorityQueue<Integer> max;
  private PriorityQueue<Integer> min;

  public MedianFinder() {
    max = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
    min = new PriorityQueue<>(Comparator.comparingInt(x -> x));
  }

  public void addNum(int num) {
    if (min.size() == max.size()) {
      max.add(num);
      min.add(max.poll());
    }
    else {
      min.add(num);
      max.add(min.poll());
    }
  }

  public double findMedian() {
    if (max.size() == min.size()) return (double) (max.peek() + min.peek()) / 2;
    return max.size() > min.size() ? max.peek() : min.peek();
  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(-1);
    medianFinder.addNum(-2);
    System.out.println(medianFinder.findMedian());

    medianFinder.addNum(-3);
    System.out.println(medianFinder.findMedian());

    medianFinder.addNum(-4);
    System.out.println(medianFinder.findMedian());

    medianFinder.addNum(-5);
    System.out.println(medianFinder.findMedian());
  }
}

