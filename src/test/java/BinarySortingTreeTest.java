import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySortingTreeTest {
  private BinarySortingTree<Integer> tree;
  @BeforeEach
  void init() {

  }

  @Test
  @DisplayName("addNode/findNode/toArray")
  void addNode() {
    tree = new BinarySortingTree<>(1);
    tree.addNode(6);
    tree.addNode(5);
    tree.addNode(4);
    tree.addNode(3);
    tree.addNode(2);

    assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(tree.toArray()));
    assertEquals(1, tree.findNode(1).getData());
    assertNull(tree.findNode(66));
  }

}
