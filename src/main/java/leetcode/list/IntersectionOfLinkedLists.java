package leetcode.list;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfLinkedLists {
  /**
   * T: O(n)
   * S: O(1)
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode result = null,
      pA = headA,
      pB = headB;

    int counterA = 0,
      counterB = 0;

    while (pA != null) {
      pA = pA.next;
      counterA++;
    }

    while (pB != null) {
      pB = pB.next;
      counterB++;
    }

    pA = headA;
    pB = headB;

    int steps = Math.abs(counterA - counterB);

    for (int i = 0; i < steps; i++) {
      if (counterA > counterB) {
        pA = pA.next;
      }
      else {
        pB = pB.next;
      }
    }

    while (pA != null) {
      if (pA == pB) {
        result = pA;
        break;
      }
      else {
        pA = pA.next;
        pB = pB.next;
      }
    }

    return result;
  }
}
