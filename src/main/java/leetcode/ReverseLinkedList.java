package leetcode;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

  /**
   * 不修改原对象
   * T: O(n), S: O(n)
   */
  public ListNode reverseNoSideEffect(ListNode head) {
    if (Objects.isNull(head)) return null;

    ListNode p = head;
    ListNode result = null;

    while (!Objects.isNull(p)) {
      ListNode node = new ListNode(p.val);
      node.next = result;
      result = node;
      p = p.next;
    }

    return result;
  }

  /**
   * 原地反转，修改了原对象
   * T: O(n), S: O(1)
   */
  public ListNode reverseWithSideEffect(ListNode head) {
    ListNode result = null,
      p = head;

    while (!Objects.isNull(p)) {
      ListNode pNext = p.next;
      p.next = result;
      result = p;
      p = pNext;
    }

    return result;
  }

  /**
   * 递归调用
   * T: O(n), S: O(n)
   */
  public ListNode reverseRecursively(ListNode head) {
    if (Objects.isNull(head) || Objects.isNull(head.next)) return head;

    ListNode node = reverseRecursively(head.next);
    // 关键在于，要指向下一个节点，前一个节点必须是能拿到的
    head.next.next = head;
    head.next = null;
    return node;
  }
}
