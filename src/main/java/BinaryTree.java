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

    List<BinaryTree> queue = new LinkedList<>();
    queue.add(this);

    while (queue.size() != 0) {
      BinaryTree<T> node = queue.remove(0);

      if (!Objects.isNull(node.getLeft())) queue.add(node.getLeft());
      else {
        BinaryTree<T> left = new BinaryTree<>(data);
        node.setLeft(left);
        left.setParent(node);
        return;
      }
      if (!Objects.isNull(node.getRight())) queue.add(node.getRight());
      else {
        BinaryTree<T> right = new BinaryTree<>(data);
        node.setRight(right);
        right.setParent(parent);
        return;
      }
    }

//    levelOrder(node -> {
//      if (!Objects.isNull(node.getData())) return true;
//
//      node.setData(data);
//      BinaryTree<T> parent = node.getParent();
//
//      // 得到的节点有三种情况：根节点或左子节点或右子节点
//      if (Objects.isNull(parent)) {
//        BinaryTree<T> child = new BinaryTree<>();
//        node.setLeft(child);
//        child.setParent(node);
//      }
//      // 左子节点
//      else if (Objects.isNull(parent.getRight())) {
//        BinaryTree<T> right = new BinaryTree<>();
//        parent.setRight(right);
//        right.setParent(parent);
//      }
//      // 右子节点
//      else {
//        BinaryTree<T> left = new BinaryTree<>();
//        parent.getLeft().setLeft(left);
//        left.setParent(parent.getLeft());
//      }
//
//      return false;
//    });
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

    if (!Objects.isNull(left)) result.append(left.inOrder());

    result.append(data.toString());

    if (!Objects.isNull(right)) result.append(right.inOrder());

    return result.toString();
  }

  public String postOrder() {
    if (Objects.isNull(data)) return "";
    StringBuilder result = new StringBuilder();

    if (!Objects.isNull(left)) result.append(left.postOrder());
    if (!Objects.isNull(right)) result.append(right.postOrder());

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

  public void levelOrder(Predicate<BinaryTree> shouldContinue) {
    List<BinaryTree> queue = new LinkedList<>();
    queue.add(this);

    while (queue.size() != 0) {
      BinaryTree<T> node = queue.remove(0);

      if (shouldContinue.test(node)) {
        if (!Objects.isNull(node.getLeft())) queue.add(node.getLeft());
        if (!Objects.isNull(node.getRight())) queue.add(node.getRight());
      }
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
   * 获取当前节点的数据
   * @return
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
