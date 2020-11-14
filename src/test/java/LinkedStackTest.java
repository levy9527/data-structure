import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

  @Test
  @DisplayName("push/pop/size/toArray/peek")
  void push() {
    Stack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertTrue(stack.push(4));
    assertEquals(4, stack.size());
    assertEquals("[4, 3, 2, 1]", Arrays.toString(stack.toArray()));

    assertEquals(4, stack.pop());
    assertEquals(3, stack.size());
    assertEquals("[3, 2, 1]", Arrays.toString(stack.toArray()));

    assertEquals(3, stack.peek());
    assertEquals(3, stack.size());
  }

}
