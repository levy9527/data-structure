package leetcode.list;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(val);
    ListNode p = this;
    while (p.next != null) {
      p = p.next;
      builder.append(p.val);
    }
    return builder.toString();
  }
}
