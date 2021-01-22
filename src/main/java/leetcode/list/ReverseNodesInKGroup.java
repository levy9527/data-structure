package leetcode.list;

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1 || head == null) return head;
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode p = dummy, prev = dummy;
    int counter = 0;

    while (p.next != null) {
      p = p.next;
      counter++;

      if (counter == k) {
        counter--; // 需要进行 k-1 次反转
        ListNode curr = prev.next;

        while (counter != 0) {
          ListNode next = curr.next;
          curr.next = next.next;
          next.next = prev.next;
          prev.next = next;

          counter--;
        }
        prev = curr;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(new int[]{1,2,3,4,5});

    System.out.println(new ReverseNodesInKGroup().reverseKGroup(head, 3).print());
  }
}

