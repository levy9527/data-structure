package leetcode.list;

class ListNode {
  int val;
  ListNode next;
  ListNode random;

  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  ListNode(int[] values) {
    ListNode p = this;
    for (int val : values) {
      p.next = new ListNode(val);
      p = p.next;
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(val);
    return builder.toString();
  }

  public String print() {
    StringBuilder builder = new StringBuilder();

    builder.append(val);
    ListNode p = this;
    while (p.next != null) {
      p = p.next;
      builder.append("->");
      builder.append(p.val);
    }
    return builder.toString();
  }
}
