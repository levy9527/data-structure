package leetcode.list;

public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) return head;

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode prev = dummy, p = dummy.next;

    while (p != null) {

    }

    return dummy.next;
  }
}
