import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
   * @param data 任意类型的数据
   */
  public void addNode(T data) {
    // 处理根节点
    if (Objects.isNull(this.data)) {
      this.data = data;
      return;
    }

    levelOrder(node -> {
      if (Objects.isNull(node.getLeft())) {
        BinaryTree<T> left = new BinaryTree<>(data);
        node.setLeft(left);
        left.setParent(node);
        return false;
      }
      else if (Objects.isNull(node.getRight())) {
        BinaryTree<T> right = new BinaryTree<>(data);
        node.setRight(right);
        right.setParent(parent);
        return false;
      }
      return true;
    });
  }

  public void preOrder(Consumer<BinaryTree<T>> operation) {
    if (Objects.isNull(data)) return;

    operation.accept(this);

    if (!Objects.isNull(left)) left.preOrder(operation);
    if (!Objects.isNull(right)) right.preOrder(operation);
  }

  public void inOrder(Consumer<BinaryTree<T>> operation) {
    if (Objects.isNull(data)) return;

    if (!Objects.isNull(left)) left.inOrder(operation);

    operation.accept(this);

    if (!Objects.isNull(right)) right.inOrder(operation);
  }

  public void postOrder(Consumer<BinaryTree<T>> operation) {
    if (Objects.isNull(data)) return;

    if (!Objects.isNull(left)) left.postOrder(operation);
    if (!Objects.isNull(right)) right.postOrder(operation);

    operation.accept(this);
  }

  public void levelOrder(Function<BinaryTree<T>, Boolean> operation) {
    if (Objects.isNull(data)) return ;

    List<BinaryTree<T>> queue = new LinkedList<>();
    queue.add(this);

    while (queue.size() != 0) {
      BinaryTree<T> node = queue.remove(0);

      if (!operation.apply(node)) return;

      if (!Objects.isNull(node.getLeft())) queue.add(node.getLeft());
      if (!Objects.isNull(node.getRight())) queue.add(node.getRight());
    }
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

  /**
   * @return 当前节点的数据
   */
  public T getData() {
    return data;
  }

  /**
   * 外部调用如果要设置节点数据，两种方式：
   * 1. 初始化时传入 data
   * 2. 调用 addNode 方法
   * @param data 任意类型数据
   */
  private void setData(T data) {
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
