package leetcode.list;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {
  /**
   * T: O(n) S: O(1)
   */
  public ListNode reorderList(ListNode head) {
    if (head == null) return head;
    ListNode p = head, right = head;

    // 找到是中间节点
    while (right.next != null && right.next.next != null) {
      p = p.next;
      right = right.next.next;
    }

    // 分离链表
    right = p.next;
    p.next = null;

    // 反转右边
    p = null;
    while (right != null) {
      ListNode next = right.next;
      right.next = p;
      p = right;
      right = next;
    }

    // 合并链表
    right = p;
    p = head;
    while (p != null && right != null) {
      ListNode pNext = p.next;
      ListNode rNext = right.next;

      p.next = right;
      right.next = pNext;

      p = pNext;
      right = rNext;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
    System.out.println(new ReorderList().reorderList(head).print());
  }
}
