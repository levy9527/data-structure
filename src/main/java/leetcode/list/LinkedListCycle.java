package leetcode.list;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  /**
   * 快慢指针，如果有环，一定会相遇
   * https://zh.wikipedia.org/wiki/Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95
   * 若设节点S到P距离为 m，环C的长度为 n，则时间复杂度为 O(m+n)}
   * 空间复杂度为 O(1)
   */
  public boolean hasCycle(ListNode head) {
    boolean result = false;

    ListNode fast = head,
      slow = head;

    while (!Objects.isNull(fast) && !Objects.isNull(fast.next)) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow) {
        result = true;
        break;
      }
    }

    return result;
  }
}
