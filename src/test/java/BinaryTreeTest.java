import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    assertEquals("123456", tree.levelOrder());

    assertEquals(3, tree.depth());
  }

}
