package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
  private int position;
  private Node next;

  public Node() {
  }

  public Node(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}

public class Josephus {
  private int total;
  private int countTo;

  public Josephus(int total, int countTo) {
    if (countTo < 2) throw new RuntimeException("countTo less than 2 is meaningless");
    this.total = total;
    this.countTo = countTo;
  }

  void solvedByLinkedList() {
    // init data
    Node head = new Node(1);
    Node tail = head;

    for (int i = 2; i <= this.getTotal(); i++) {
      Node node = new Node(i);
      tail.setNext(node);
      tail = node;
    }
    // make list cycled
    tail.setNext(head);

    int counter = 1;
    int executed = 0;
    Node p = head;
    Node prev = null;

    while (executed < this.getTotal() - (this.getCountTo() - 1)) {
      if (counter == this.getCountTo()) {
        // execute and reset
        prev.setNext(p.getNext());
        p.setNext(null);
        p = prev.getNext();
        executed ++;
        counter = 1;
      } else {
        counter++;
        prev = p;
        p = p.getNext();
      }
    }

    List<Integer> survivors = new ArrayList<>();

    while (!survivors.contains(p.getPosition())) {
      survivors.add(p.getPosition());
      p = p.getNext();
    }

    System.out.println(Arrays.toString(survivors.toArray()));
  }

  void solvedByArray() {
    // index denotes position
    // value 1 denotes executed; value 0 denotes alive
    int[] people = new int[this.getTotal() + 1];

    int counter = 0;
    int executed = 0;
    for (int i = 0; executed < this.getTotal() - (this.getCountTo() - 1);) {
      if (i == this.getTotal()) i = 1;
      else i++;

      if (people[i] == 1) {
        continue;
      }

      counter++;

      if (counter == this.getCountTo() ) {
        people[i] = 1;
        executed++;
        counter = 0;
      }
    }

    List<Integer> survivors = new ArrayList<>();
    for(int i = 1; i < people.length; i++) {
      if (people[i] != 1) survivors.add(i);
    }

    System.out.println(Arrays.toString(survivors.toArray()));
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getCountTo() {
    return countTo;
  }

  public void setCountTo(int countTo) {
    this.countTo = countTo;
  }

  public static void main(String[] args) {
    Josephus josephus = new Josephus(41, 3);
    josephus.solvedByLinkedList();
    josephus.solvedByArray();
  }
}
