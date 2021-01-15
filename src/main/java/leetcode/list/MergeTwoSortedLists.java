package leetcode.list;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
  /**
   * T: O(left + right)
   * S: O(left + right)
   */
  public ListNode mergeTwoLists(ListNode left, ListNode right) {
    // 左右比较，if (x < y) add to new List, 还是倾向使用no side effect 的方式
    // 会有一个先到底，则单独遍历剩下的
    ListNode pL = left,
      pR = right,
      head = new ListNode(),
      p = head;


    while (!Objects.isNull(pL) && !Objects.isNull(pR)) {
      if (pL.val <= pR.val) {
        p.next = new ListNode(pL.val);
        pL = pL.next;
      }
      else {
        p.next = new ListNode(pR.val);
        pR = pR.next;
      }
      p = p.next;
    }

    while (!Objects.isNull(pL)) {
      p.next = new ListNode(pL.val);
      p = p.next;
      pL = pL.next;
    }

    while (!Objects.isNull(pR)) {
      p.next = new ListNode(pR.val);
      p = p.next;
      pR = pR.next;
    }

    return head.next;
  }
}
