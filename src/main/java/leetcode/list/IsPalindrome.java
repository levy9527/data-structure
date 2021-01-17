package leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindrome {
  /**
   * 通过反转右半部分链表，来比较，注意最后要把链表复原
   * T: O(n) 遍历了 2 次，S: O(1)
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    boolean result = true;
    ListNode slow = head, fast = slow;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 此时 slow 在左半的末端
    fast = slow;
    ListNode p = slow.next;
    // 反转
    while (p != null) {
      ListNode pNext = p.next;
      p.next = fast;
      fast = p;
      p = pNext;
    }

    // 此时 fast 是右边
    p = head;
    while (p != slow) {
      if (p.val != fast.val) {
        result = false;
        break;
      }
      p = p.next;
      fast = fast.next;
    }

    // 再复原链表
    fast = slow;
    p = slow.next;
    while (p != null) {
      ListNode pNext = p.next;
      p.next = fast;
      fast = p;
      p = pNext;
    }
    return result;
  }

  /**
   * 使用数组
   * T: O(n) 遍历 1.5次 S: O(n)
   */
  public boolean isPalindrome1(ListNode head) {
    boolean result = true;
    List<Integer> list = new ArrayList<>();
    ListNode p = head;

    while(!Objects.isNull(p)) {
      list.add(p.val);
      p = p.next;
    }

    int len = list.size() / 2;
    int max = list.size() - 1;

    for (int i = 0; i < len; i++) {
      if (!list.get(i).equals(list.get(max - i))) {
        result = false;
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(-129);
    head.next = new ListNode(-129);

    System.out.println(new IsPalindrome().isPalindrome1(head));
  }
}
