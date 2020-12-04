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
  @DisplayName("addNode/deleteNode/findNode/toArray")
  void addNode() {
    tree = new BinarySortingTree<>(54);
    tree.addNode(90);
    tree.addNode(6);
    tree.addNode(69);
    tree.addNode(12);
    tree.addNode(37);
    tree.addNode(92);
    tree.addNode(28);
    tree.addNode(65);
    tree.addNode(83);

    assertEquals("[6, 12, 28, 37, 54, 65, 69, 83, 90, 92]", Arrays.toString(tree.toArray()));
    assertEquals(6, tree.findNode(6).getData());
    assertNull(tree.findNode(66));

    tree.deleteNode(83);
    assertEquals("[6, 12, 28, 37, 54, 65, 69, 90, 92]", Arrays.toString(tree.toArray()));

    tree.deleteNode(37);
    assertEquals("[6, 12, 28, 54, 65, 69, 90, 92]", Arrays.toString(tree.toArray()));

    tree.deleteNode(12);
    assertEquals("[6, 28, 54, 65, 69, 90, 92]", Arrays.toString(tree.toArray()));

    tree.deleteNode(90);
    assertEquals("[6, 28, 54, 65, 69, 92]", Arrays.toString(tree.toArray()));

    tree.deleteNode(69);
    assertEquals("[6, 28, 54, 65, 92]", Arrays.toString(tree.toArray()));

    tree.deleteNode(54);
    assertEquals("[6, 28, 65, 92]", Arrays.toString(tree.toArray()));
  }

}
