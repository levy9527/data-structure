package leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromList {
  /**
   * 未排序列表也适用
   * T: O(n^2) S: O(1)
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode pivot = head, p = null;
    // 移动p，到末尾后；再移动pivot,重新移动p
    while (pivot != null) {
      p = pivot.next;
      ListNode prev = pivot;
      while (p != null) {
        if (p.val == pivot.val) {
          prev.next = p.next;
        }
        else {
          prev = p;
        }
        p = p.next;
      }
      pivot = pivot.next;
    }

    return head;
  }
}
