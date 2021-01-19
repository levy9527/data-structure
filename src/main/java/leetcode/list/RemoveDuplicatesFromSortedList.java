package leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode prev = dummy, checkpoint = prev.next, p;
    boolean removeCheckpoint = false;

    while (checkpoint != null) {
      p = checkpoint.next;

      if (p == null || p.val != checkpoint.val) {
        if (!removeCheckpoint) {
          prev = checkpoint;
          checkpoint = checkpoint.next;
        }
        else {
          prev.next = checkpoint.next;
          checkpoint = prev.next;
          removeCheckpoint = false;
        }
      }
      else {
        removeCheckpoint = true;
        checkpoint.next = p.next;
      }
    }

    return dummy.next;
  }
}
