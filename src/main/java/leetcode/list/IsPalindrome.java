package leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindrome {
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
