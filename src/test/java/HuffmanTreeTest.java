import collection.HuffmanTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HuffmanTreeTest {

  @Test
  void build() {
    HuffmanTree tree = new HuffmanTree(new int[]{5,7,2,13});
    tree.build();

    assertEquals("[13, 7, 5, 2]", tree.toString());
  }
}
