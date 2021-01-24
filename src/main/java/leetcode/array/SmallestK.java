package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 * FYI: https://github.com/sisterAn/JavaScript-Algorithms/issues/73
 */
public class SmallestK {
  /**
   * T: O(nlogk)
   * S: O(k)
   */
  public int[] smallestK(int[] arr, int k) {
    int[] result = new int[k];
    if (arr.length == 0 || k == 0) return result;
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(x -> -x));

    // init
    int i = 0;
    for (; i < k; i++) {
      heap.add(arr[i]);
    }

    // maintain
    for (; i < arr.length; i++) {
      if (heap.peek() > arr[i]) {
        heap.poll();
        heap.add(arr[i]);
      }
    }

    for (i = 0; i < k; i++) {
      result[i] = heap.poll();
    }

    return result;
  }

  /**
   * 使用快排：[]里表示的是不能修改入参 arr 的情况
   * T: O(nlogn + k [+n])
   * S: O(1 + [n])
   */
  public int[] smallestK_quickSort(int[] arr, int k) {
    int[] result = new int[k];

    Arrays.sort(arr);

    System.arraycopy(arr, 0, result, 0, k);

    return result;
  }
}
