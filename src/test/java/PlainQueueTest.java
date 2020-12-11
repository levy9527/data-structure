import collection.PlainQueue;
import collection.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlainQueueTest {
  @Test
  @DisplayName("enqueue/dequeue/head/size/toString")
  void test(){
    Queue<Integer> queue = new PlainQueue<>(3);

    queue.enqueue(1);
    queue.enqueue(2);

    assertTrue(queue.enqueue(3));
    assertFalse(queue.enqueue(4));
    assertEquals(3, queue.size());

    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.head());
    assertEquals(2, queue.size());
    assertEquals("[2, 3]", queue.toString());
  }

}
