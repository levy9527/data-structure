package leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

  /**
   * 空间换时间
   * T: O(n) S: O(1)
   */
  public ListNode copyRandomList(ListNode head) {
    if (head == null) return head;

    ListNode p = head,
      copy;

    // copy value and weaves list
    while (p != null) {
      copy = new ListNode(p.val);
      copy.next = p.next;
      p.next = copy;
      p = copy.next;
    }

    // random pointer
    p = head;
    while (p != null) {
      copy = p.next;
      ListNode random = p.random;

      if (random == null) copy.random = null;
      else {
        copy.random = random.next;
      }

      p = copy.next;
    }

    // next pointer/split list
    p = head;
    ListNode copyHead = p.next;
    while (p != null) {
      copy = p.next;
      p.next = copy.next;

      if (p.next != null)
        copy.next = p.next.next;

      p = p.next;
    }
    return copyHead;
  }



  /**
   * 利用 hashMap 建立 origin 与 copy 一一对应的关系。
   * 关键点是，origin 作为key，因为它是不会变的
   * T: O(n), S: O(n)
   */
  public ListNode copyRandomListWithMap(ListNode head) {
    if (head == null) return null;
    Map<ListNode, ListNode> map = new HashMap<>();
    ListNode p = head;

    // 生成节点
    while (p != null) {
      ListNode node = new ListNode(p.val);
      map.put(p, node);
      p = p.next;
    }

    // 建立指针
    p = head;
    while (p != null) {
      ListNode copy = map.get(p);
      copy.next = map.get(p.next);
      copy.random = map.get(p.random);
      p = p.next;
    }

    return map.get(head);
  }
}
