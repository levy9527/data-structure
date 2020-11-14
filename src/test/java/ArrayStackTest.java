import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
  @Test
  @DisplayName("push/pop/size/toArray/peek")
  void push() {
    Stack<Integer> stack = new ArrayStack<>(3);

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertFalse(stack.push(4));
    assertEquals(3, stack.size());
    assertEquals("[3, 2, 1]", Arrays.toString(stack.toArray()));

    assertEquals(3, stack.pop());
    assertEquals(2, stack.size());
    assertEquals("[2, 1]", Arrays.toString(stack.toArray()));

    assertEquals(2, stack.peek());
    assertEquals(2, stack.size());
  }

}
