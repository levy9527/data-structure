package leetcode.list;

class ListNode {
  int val;
  ListNode next;
  ListNode random;

  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  ListNode(int[] values) {
    if (values.length < 1) return;

    ListNode p = this;
    val = values[0];

    for (int i = 1; i < values.length; i++) {
      p.next = new ListNode(values[i]);
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
