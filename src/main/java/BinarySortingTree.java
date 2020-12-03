import java.util.Objects;
import java.util.function.Consumer;

public class BinarySortingTree<T> {
  private BinarySortingTree<T> left;
  private BinarySortingTree<T> right;
  private BinarySortingTree<T> parent;
  private int data;

  public BinarySortingTree(int data) {
    this.setData(data);
  }

  public void addNode(int data) {
    BinarySortingTree<T> parent = null, p = this;
    BinarySortingTree<T> node = new BinarySortingTree<>(data);

    // 找到符合定义的父节点
    while (!Objects.isNull(p)) {
      parent = p;
      if (data < p.getData()) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }

    // 完善逻辑：如果是其他对象判断大小，需要引入 comparable 对象
    if (data < parent.getData()) {
      // 左节点
      // 则还要知道右节点
      parent.left = node;
    }
    else {
      parent.right = node;
    }

    node.parent = parent;
  }

  public void inOrder(Consumer<BinarySortingTree<T>> operation) {
    if (!Objects.isNull(this.getLeft())) this.getLeft().inOrder(operation);
    operation.accept(this);
    if (!Objects.isNull(this.getRight())) this.getRight().inOrder(operation);
  }

  public T[] toArray() {
    LinkedList<Integer> list = new LinkedList<>();

    this.inOrder(node -> list.add(node.getData()));

    return (T[]) list.toArray();
  }

  public BinarySortingTree<T> getLeft() {
    return left;
  }

  public void setLeft(BinarySortingTree<T> left) {
    this.left = left;
  }

  public BinarySortingTree<T> getRight() {
    return right;
  }

  public void setRight(BinarySortingTree<T> right) {
    this.right = right;
  }

  public BinarySortingTree<T> getParent() {
    return parent;
  }

  public void setParent(BinarySortingTree<T> parent) {
    this.parent = parent;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
