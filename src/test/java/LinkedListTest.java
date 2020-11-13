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
    assertFalse(linkedList.contains(new Integer(1)));
    assertNull(linkedList.get(0));
    assertNull(linkedList.get(1));

    // side effect
    linkedList.add(new Integer(1));

    assertTrue(linkedList.contains(new Integer(1)));
    assertEquals("[1]", Arrays.toString(linkedList.toArray()));
    assertEquals(1, linkedList.size());

  }

  @Test
  @DisplayName("set/get")
  void test2() {
    linkedList.add(new Integer(1));

    assertEquals(1, linkedList.get(0));

    // side effect
    assertFalse(linkedList.set(-1, new Integer(2)));
    assertTrue(linkedList.set(0, new Integer(0)));
    assertFalse(linkedList.set(1, new Integer(1)));

    assertEquals(1, linkedList.size());
    assertEquals(0, linkedList.get(0));
  }

  @Test
  void remove() {
    linkedList.add(new Integer(0));
    linkedList.add(new Integer(1));

    assertFalse(linkedList.remove(-1));
    assertFalse(linkedList.remove(2));
    assertTrue(linkedList.remove(1));
    assertEquals(1, linkedList.size());
    assertEquals(0,linkedList.get(0));

    assertTrue(linkedList.remove(new Integer(0)));
    assertEquals(0, linkedList.size());
    assertNull(linkedList.get(0));
    assertNull(linkedList.get(1));

  }

  @Test
  void insert() {
    linkedList.insert(0, new Integer(1));
    linkedList.insert(-1, new Integer(0));
    linkedList.insert(3, new Integer(2));

    assertEquals(3, linkedList.size());
    assertEquals("[0, 1, 2]", Arrays.toString(linkedList.toArray()));
  }
}
