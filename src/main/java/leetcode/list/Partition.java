package leetcode.list;

public class Partition {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode p = dummy, prev = dummy;

    while (p.next != null) {
      prev = p;
      p = p.next;
      if (p.val >= x) break;
    }

    ListNode pivot = p, q = pivot;

    // 把大的从左边移走
//    while (p.next != pivot) {
//      ListNode pNext = p.next;
//
//      if (pNext.val >= pivot.val) {
//        p.next = pNext.next;
//        pNext.next = q.next;
//        q.next = pNext;
//        q = q.next;
//      }
//      else
//        p = pNext;
//    }

    // 把小的从右边移走
    while (q.next != null) {
      ListNode qNext = q.next;

      if (qNext.val < x) {
        q.next = qNext.next;
        qNext.next = pivot;
        prev.next = qNext;
        prev = prev.next;
      }
      else
        q = qNext;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode p = head;
    int[] nodes = {4,3,2,5,2};

    for (int node : nodes) {
      p.next = new ListNode(node);
      p = p.next;
    }

    System.out.println(new Partition().partition(head, 3));
  }
}
