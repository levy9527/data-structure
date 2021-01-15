package leetcode.list;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEnd {
  /**
   * 有多种解法，分别在于：是否求链表长度，是否使用辅助空间
   * 单以此题来看，代码思路最“一针见血”、消耗资源最少的是快慢指针。T: (L)，S: O(1)
   * 但如果在使用场景中，使用的链表类已经有在存储长度的，如 LinkedList，则直接遍历会更高效
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = new ListNode(),
      slow = fast, newHead = fast;

    fast.next = head;

    // 先走 n 步
    int i = 0;
    for (; i < n && !Objects.isNull(fast.next); i++)
      fast = fast.next;

    if (i < n) return head;

    while (!Objects.isNull(fast.next)) {
      // 查找节点
      fast = fast.next;
      slow = slow.next;
    }

    // 删除
    ListNode node = slow.next;
    slow.next = node.next;
    node.next = null;

    return newHead.next;
  }
}
