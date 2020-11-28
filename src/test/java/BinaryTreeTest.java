import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
  BinaryTree<Integer> tree;

  @BeforeEach
  void init() {
    tree = new BinaryTree<>();
  }

  @Test
  void traversal() {
    assertEquals("", tree.preOrder());

    tree.addNode(1);
    tree.addNode(2);
    tree.addNode(3);
    tree.addNode(4);
    tree.addNode(5);
    tree.addNode(6);

    assertEquals("124536", tree.preOrder());
    assertEquals("425163", tree.inOrder());
    assertEquals("452631", tree.postOrder());

    LinkedList<Integer> levelOrder = new LinkedList<>();
    tree.levelOrder(node -> {
      if (!Objects.isNull(node.getData())) levelOrder.add((Integer) node.getData());
      return true;
    });
    assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(levelOrder.toArray()));

    assertEquals(3, tree.depth());
  }

}
