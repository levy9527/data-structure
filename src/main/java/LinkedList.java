public class LinkedList<T> implements List<T>{
  private Node head = new Node(null);

  private class Node {
    private T data;
    private Node next = null;

    Node(T data) {
      Node.this.data = data;
    }
  }

  @Override
  public boolean add(T element) {
    Node node = new Node(element);
    if(head.next == null) head.next = node;
    else {
      Node p = head.next;
      while(p.next != null) {
        p = p.next;
      }
      p.next = node;
    }

    return true;
  }

  @Override
  public boolean insert(int index, T element) {
    Node e = new Node(element);

    // 负数也行，默认是在头插入
    if (index <= 0) {
      e.next = head.next;
      head.next = e;
      return true;
    }

    Node p = head;
    int i = 0;

    while (p.next != null) {
      if (i == index) {
        e.next = p.next;
        p.next = e;
        break;
      }
      p = p.next;
      i++;
    }

    // tail
    if (index >= i) {
      p.next = new Node(element);
    }

    // 链表没有容量限制，insert 肯定默认是成功的
    return true;
  }

  @Override
  public T remove(int index) {
    if (index < 0) return null;
    //  节省一次遍历，具体原因看下一个注释
//    if (index >= this.size()) return false;

    T result = null;
    Node p = head;
    int i = 0;

    while (p.next != null) {
      // 如果入参 index > this.size()，则 i 永远不会等于 index
      if (i == index) {
        result = p.next.data;
        p.next = p.next.next;
        break;
      }
      p = p.next;
      i++;
    }

    return result;
  }

  public T remove(T element) {
    T result = null;
    Node p = head;

    while (p.next != null) {
      if (p.next.data.equals(element)) {
        p.next = p.next.next;

        result = element;
        break;
      }
      p = p.next;
    }
    return result;
  }

  @Override
  public boolean set(int index, T element) {
    if (index < 0) return false;
    boolean result = false;
    Node p = head;
    int i = 0;

    while (p.next != null) {
      if (i == index) {
        p.next.data = element;
        result = true;
        break;
      }
      p = p.next;
    }


    return result;
  }

  @Override
  public T get(int index) {
    if (index < 0) return null;

    T result = null;
    Node p = head;
    int i = 0;

    while (p.next != null) {
      if (i == index) {
        result = p.next.data;
        break;
      }
      p = p.next;
    }

    return result;
  }

  @Override
  public int size() {
    int result = 0;
    Node p = head;
    while (p.next != null) {
      p = p.next;
      result++;
    }
    return result;
  }

  @Override
  public boolean contains(T element) {
    boolean result = false;

    Node p = head;
    while (p.next != null) {
      if(p.next.data.equals(element)) {
        result = true;
        break;
      }
      p = p.next;
    }
    return result;
  }

  @Override
  public T[] toArray() {
    int size = this.size();
    T[] result = (T[])new Object[size];

    Node p = head;
    for (int i = 0; i < size; i++) {
      result[i] = p.next.data;
      p = p.next;
    }

    return result;
  }
}
