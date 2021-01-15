package leetcode.list;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  /**
   * 快慢指针，如果有环，一定会相遇
   * T: O(n) S: O(1)
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
