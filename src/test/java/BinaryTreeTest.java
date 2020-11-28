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

    tree.setData(1);
    tree.addNode(2);
    tree.addNode(3);

    assertEquals("123", tree.preOrder());
    assertEquals("213", tree.inOrder());
    assertEquals("231", tree.postOrder());
    assertEquals("123", tree.levelOrder());

    assertEquals(2, tree.depth());
  }

}
