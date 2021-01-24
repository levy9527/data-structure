package leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    // 先遍历，建立映射
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    // 再读取映射，构建小顶堆，注意输出顺序
    Integer[] keys = map.keySet().toArray(new Integer[0]);
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

    int i = 0;
    for (; i < k && i < keys.length; i++) {
      heap.offer(keys[i]);
    }

    for (; i < keys.length; i++) {
      if (map.get(heap.peek()) < map.get(keys[i])) {
        heap.poll();
        heap.offer(keys[i]);
      }
    }

    int[] result = new int[k];
    // 如果是现实情况，最好是顺序遍历，再 reverse，因为 k 可能 > keys.length
    for (i = k - 1; i >= 0 && heap.size() > 0; i--) {
      result[i] = heap.poll();
    }

    return result;
  }
}
