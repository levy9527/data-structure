package leetcode.list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii
 */
public class ReverseBetween {
  /**
   * 所以说，头节点存储值，是个很不好的习惯，别人操作时，又得专门创建一个头节点
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode p = dummy, prev = p;
    int counter = 0;

    while (counter != m && p != null) {
      prev = p;
      p = p.next;
      counter++;
    }

    while (counter != n && p != null) {
      ListNode pNext = p.next;
      p.next = pNext.next;
      pNext.next = prev.next;
      prev.next = pNext;
      counter++;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(5);

    System.out.println(new ReverseBetween().reverseBetween(head, 1, 2));
  }
}
