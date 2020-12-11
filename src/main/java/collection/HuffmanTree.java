package collection;

import java.util.Arrays;
import java.util.Objects;

public class HuffmanTree {
  private HuffmanTree left;
  private HuffmanTree right;
  private HuffmanTree parent;
  private int weight = 0;
  private int[] array;

  private HuffmanTree() {
  }

  public HuffmanTree(int[] array) {
    if (array.length < 3) throw new RuntimeException("to construct a Huffman Tree needs at least 3 elements");
    // 先排一下序, 让数组由小到大排列
    this.array = Sort.insertion(array, Sort.SORT_TYPE.ASC);
  }

  /**
   * 构造的技巧是，默认自己是左(右）子节点，然后重复添加右(左）子节点及父节点
   */
  public void build() {
    weight = array[0];

    HuffmanTree left = this;
    HuffmanTree right;
    HuffmanTree parent;

    for (int i = 1; i < array.length; i++) {
      right = new HuffmanTree();
      right.weight = array[i];

      parent = new HuffmanTree();
      parent.weight = left.weight + right.weight;
      parent.left = left;
      parent.right = right;

      left.parent = parent;
      right.parent = parent;

      left = parent;
    }
  }

  /**
   * @return 权重值数组由大到小排序的字符串
   */
  @Override
  public String toString() {
    LinkedList<Integer> list = new LinkedList<>();
    // 以左子节点为起始点
    list.add(weight);

    HuffmanTree node = this;

    while (!Objects.isNull(node.parent)) {
      list.insert(0, node.parent.right.weight);
      node = node.parent;
    }

    return Arrays.toString(list.toArray());
  }
}

