package leetcode;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
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
}
