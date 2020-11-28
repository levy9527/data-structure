import java.util.Objects;

public class BinaryTree<T> {
  private BinaryTree<T> left;
  private BinaryTree<T> right;
  private BinaryTree<T> parent = null;
  private T data = null;

  public BinaryTree() {
  }

  public BinaryTree(T data) {
    // 默认初始化时，本节点作为根节点
    this.data = data;
  }

  /**
   * 按照完全二叉树的形式，通过层次遍历，自动判断加入左子树还是右子树
   * 需要宽度优先遍历
   * @param data 任意类型的数据
   */
  public void addNode(T data) {
    if (Objects.isNull(left)) {
      left = new BinaryTree<>(data);
      left.setParent(this);
    }

    else if (Objects.isNull(right)) {
      right = new BinaryTree<>(data);
      right.setParent(this);
    }
  }

  public String preOrder() {
    if (Objects.isNull(data)) return "";

    StringBuilder result = new StringBuilder(data.toString());

    if (!Objects.isNull(left)) result.append(left.preOrder());
    if (!Objects.isNull(right)) result.append(right.preOrder());

    return result.toString();
  }

  public String inOrder() {
    if (Objects.isNull(data)) return "";
    StringBuilder result = new StringBuilder();

    if (!Objects.isNull(left)) result.append(left.preOrder());

    result.append(data.toString());

    if (!Objects.isNull(right)) result.append(right.preOrder());

    return result.toString();
  }

  public String postOrder() {
    if (Objects.isNull(data)) return "";
    StringBuilder result = new StringBuilder();

    if (!Objects.isNull(left)) result.append(left.preOrder());
    if (!Objects.isNull(right)) result.append(right.preOrder());

    result.append(data.toString());

    return result.toString();
  }

  public String levelOrder() {
    if (Objects.isNull(data)) return "";
    StringBuilder result = new StringBuilder();
    List<BinaryTree> queue = new LinkedList<>();
    queue.add(this);

    while (queue.size() != 0) {
      BinaryTree<T> node = queue.remove(0);

      if (!Objects.isNull(node.getData())) result.append(node.getData().toString());
      if (!Objects.isNull(node.getLeft())) queue.add(node.getLeft());
      if (!Objects.isNull(node.getRight())) queue.add(node.getRight());
    }

    return result.toString();
  }

  public int depth() {
    if (Objects.isNull(data)) return 0;

    int leftDepth = 0;
    int rightDepth = 0;

    if (!Objects.isNull(left)) {
      leftDepth = left.depth();
    }
    if (!Objects.isNull(right)) {
      rightDepth = right.depth();
    }

    return 1 + (Math.max(leftDepth, rightDepth));
  }

  public BinaryTree<T> getParent() {
    return parent;
  }

  public void setParent(BinaryTree<T> parent) {
    this.parent = parent;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BinaryTree<T> getLeft() {
    return left;
  }

  public void setLeft(BinaryTree<T> left) {
    this.left = left;
  }

  public BinaryTree<T> getRight() {
    return right;
  }

  public void setRight(BinaryTree<T> right) {
    this.right = right;
  }
}
