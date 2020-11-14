import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlainStackTest {
  @Test
  @DisplayName("push/pop/size/toArray")
  void test() {
    Stack<Integer> stack = new PlainStack<>(3);

    assertNull(stack.pop());

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertFalse(stack.push(4));
    assertEquals(3, stack.size());
    assertEquals("[3, 2, 1]", Arrays.toString(stack.toArray()));

    assertEquals(3, stack.pop());
    assertEquals(2, stack.size());
    assertEquals("[2, 1]", Arrays.toString(stack.toArray()));

  }

}
