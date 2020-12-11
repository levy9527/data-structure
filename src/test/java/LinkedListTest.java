import collection.LinkedList;
import collection.LinkedStack;
import collection.List;
import collection.Stack;
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

  /**
   * convert decimal system to other numeral systems
   */
  static int baseConversion(int decimal, int base) {
    if (decimal < 0) throw new RuntimeException("decimal must >= 0");
    if (base < 2) throw new RuntimeException("base must >= 2");
    if (decimal == 0) return 0;

    Stack<Integer> stack = new LinkedStack<>();
    int quotient = decimal;

    while (quotient != 0) {
      stack.push(quotient % base);
      quotient = (int) Math.floor(quotient / base);
    }

    // TODO 这里不能使用 Integer ?
    Object[] array = stack.toArray();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      builder.append(array[i]);
    }

    return Integer.parseInt(builder.toString());
  }

  @Test
  void testBaseConversion() {
    assertEquals(0, LinkedListTest.baseConversion(0, 16));
    assertEquals(151520, LinkedListTest.baseConversion(65312, 16));
  }
}
