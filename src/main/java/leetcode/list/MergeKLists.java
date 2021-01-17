package leetcode.list;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 2) {
      return mergeList(lists[0], lists[1]);
    }

    ListNode head = null;
    for (int i = 0; i < lists.length; i++) {
      head = mergeList(head, lists[i]);
    }

    return head;
  }

  private ListNode mergeList(ListNode left, ListNode right) {
    ListNode head = new ListNode();
    ListNode p = head,
      pLeft = left,
      pRight = right;

    while (pLeft != null && pRight != null) {
      if (pLeft.val < pRight.val) {
        p.next = new ListNode(pLeft.val);
        pLeft = pLeft.next;
      }
      else {
        p.next = new ListNode(pRight.val);
        pRight = pRight.next;
      }
      p = p.next;
    }

    while (pLeft != null) {
      p.next = new ListNode(pLeft.val);
      pLeft = pLeft.next;
      p = p.next;
    }

    while (pRight != null) {
      p.next = new ListNode(pRight.val);
      pRight = pRight.next;
      p = p.next;
    }

    return head.next;
  }

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[3];

    ListNode left1 = new ListNode(1);
    ListNode left2 = new ListNode(4);
    ListNode left3 = new ListNode(5);
    left1.next = left2;
    left2.next = left3;
    lists[0] = left1;

    ListNode right1 = new ListNode(1);
    ListNode right2 = new ListNode(3);
    ListNode right3 = new ListNode(4);
    right1.next = right2;
    right2.next = right3;
    lists[1] = right1;

    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(6);
    l1.next = l2;
    lists[2] = l1;

    ListNode output = new MergeKLists().mergeKLists(lists);
    System.out.println(output);
  }
}
