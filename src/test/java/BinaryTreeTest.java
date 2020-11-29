import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
  @DisplayName("addNode/traversal/depth")
  void traversal() {
    LinkedList<Integer> emptyList = new LinkedList<>();
    tree.preOrder(node -> {
      emptyList.add(node.getData());
    });

    assertEquals("[]", Arrays.toString(emptyList.toArray()));

    tree.addNode(1);
    tree.addNode(2);
    tree.addNode(3);
    tree.addNode(4);
    tree.addNode(5);
    tree.addNode(6);

    LinkedList<Integer> preOrder = new LinkedList<>();
    tree.preOrder(node -> preOrder.add(node.getData()));
    assertEquals("[1, 2, 4, 5, 3, 6]", Arrays.toString(preOrder.toArray()));

    LinkedList<Integer> inOrder = new LinkedList<>();
    tree.inOrder(node -> inOrder.add(node.getData()));
    assertEquals("[4, 2, 5, 1, 6, 3]", Arrays.toString(inOrder.toArray()));

    LinkedList<Integer> postOrder = new LinkedList<>();
    tree.postOrder(node -> postOrder.add(node.getData()));
    assertEquals("[4, 5, 2, 6, 3, 1]", Arrays.toString(postOrder.toArray()));

    LinkedList<Integer> levelOrder = new LinkedList<>();
    tree.levelOrder(node -> {
      if (!Objects.isNull(node.getData())) levelOrder.add(node.getData());
      return true;
    });
    assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(levelOrder.toArray()));

    assertEquals(3, tree.depth());
  }

  @Test
  void threading() {
    tree.addNode(1);
    tree.addNode(2);
    tree.addNode(3);
    tree.addNode(4);
    tree.addNode(5);
    tree.addNode(6);

    tree.threadingInOrder();
    assertEquals("[4, 2, 5, 1, 6, 3]", Arrays.toString(tree.toArray()));
    assertEquals(5, tree.findPrev(tree).getData());
    assertEquals(6, tree.findNext(tree).getData());
  }

}
