import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
  private List<Integer> linkedList;

  @BeforeEach
  void init() {
    linkedList = new LinkedList<>();
  }

  @Test
  @DisplayName("add/size/toArray/contains")
  void test() {
    assertFalse(linkedList.contains(1));
    assertNull(linkedList.get(0));
    assertNull(linkedList.get(1));

    // side effect
    linkedList.add(1);

    assertTrue(linkedList.contains(1));
    assertEquals("[1]", Arrays.toString(linkedList.toArray()));
    assertEquals(1, linkedList.size());

  }

  @Test
  @DisplayName("set/get")
  void test2() {
    linkedList.add(1);

    assertEquals(1, linkedList.get(0));

    // side effect
    assertFalse(linkedList.set(-1, 2));
    assertTrue(linkedList.set(0, 0));
    assertFalse(linkedList.set(1, 1));

    assertEquals(1, linkedList.size());
    assertEquals(0, linkedList.get(0));
  }

  @Test
  void remove() {
    linkedList.add(0);
    linkedList.add(1);

    assertNull(linkedList.remove(-1));
    assertNull(linkedList.remove(2));
    assertEquals(1, linkedList.remove(1));
    assertEquals(1, linkedList.size());
    assertEquals(0,linkedList.get(0));

    assertEquals(0, linkedList.remove(0));
    assertEquals(0, linkedList.size());
    assertNull(linkedList.get(0));
    assertNull(linkedList.get(1));

  }

  @Test
  void insert() {
    linkedList.insert(0, 1);
    linkedList.insert(-1, 0);
    linkedList.insert(3, 2);

    assertEquals(3, linkedList.size());
    assertEquals("[0, 1, 2]", Arrays.toString(linkedList.toArray()));
  }
}
