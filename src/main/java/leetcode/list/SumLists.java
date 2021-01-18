package leetcode.list;

/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class SumLists {
  /**
   * 因为已经是逆序了，则不需要反转链表了
   */
  public ListNode addTwoNumbers(ListNode left, ListNode right) {
    ListNode pLeft = left,
      pRight = right,
      dummy = new ListNode(),
      p = dummy;


    // 遍历相加
    while (pLeft != null && pRight != null) {
      int sum = pLeft.val + pRight.val;
      // 10 进制
      if (p.next == null)
        p.next = new ListNode(sum % 10);
      else {
        sum += p.next.val;
        p.next.val = (sum % 10);
      }
      p = p.next;
      if (sum >= 10)
        p.next = new ListNode(sum / 10);

      pLeft = pLeft.next;
      pRight = pRight.next;
    }

    while (pLeft != null) {
      int sum = 0;
      if (p.next != null) {
        sum += p.next.val + pLeft.val;
        p.next.val = sum % 10;
        if (sum >= 10)
          p.next.next = new ListNode(sum / 10);
      }
      else {
        p.next = new ListNode(pLeft.val);
      }

      pLeft = pLeft.next;
      p = p.next;
    }

    while (pRight != null) {
      int sum = 0;
      if (p.next != null) {
        sum += p.next.val + pRight.val;
        p.next.val = sum % 10;
        if (sum >= 10)
          p.next.next = new ListNode(sum / 10);
      }
      else {
        p.next = new ListNode(pRight.val);
      }


      pRight = pRight.next;
      p = p.next;
    }

    return dummy.next;
  }
}
