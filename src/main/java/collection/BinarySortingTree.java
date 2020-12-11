package collection;

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

  /**
   * 被删除结点总共有以下几种情况：
   * 0. 不存在
   * 1. 无子节点（叶子节点/根节点）
   * 2. 只有左子节点
   * 3. 只有右子节点
   * 4. 有左右子节点(右子节点有/没有左子树）
   */
  public void deleteNode(int data) {
    BinarySortingTree<T> node = findNode(data);
    if(Objects.isNull(node)) return;

    BinarySortingTree<T> parent = node.getParent();
    BinarySortingTree<T> left = node.getLeft();
    BinarySortingTree<T> right = node.getRight();
    boolean isRight = false;
    if (!Objects.isNull(parent) && node.equals(parent.getRight())) isRight = true;

    if (Objects.isNull(left) && Objects.isNull(right)) {
      // 无子节点
      if (Objects.isNull(parent)) this.setData(0); // 程序有bug，应该设置 null
      else if (isRight) parent.setRight(null);
      else parent.setLeft(null);
    }
    else if (Objects.isNull(left)) {
      // 只有右子节点
      if (isRight) parent.setRight(right);
      else parent.setLeft(right);

      right.setParent(parent);
    }
    else if (Objects.isNull(right)) {
      // 只有左子节点
      if (isRight) parent.setRight(left);
      else parent.setLeft(left);
      left.setParent(parent);
    }
    else {
      // 有左右子节点
      BinarySortingTree<T> p = right;

      if (Objects.isNull(p.getLeft())) {
        node.setData(p.getData());
        p.getParent().setRight(null);
      }
      else {
        while (!Objects.isNull(p.getLeft())) {
          p = p.getLeft();
        }
        node.setData(p.getData());
        p.getParent().setLeft(null);
      }
    }
  }

  public BinarySortingTree<T> findNode(int data) {
    if (data == this.getData()) return this;
    else if (!Objects.isNull(this.getLeft()) && data < this.getData()) return this.getLeft().findNode(data);
    else if (!Objects.isNull(this.getRight()) && data > this.getData())return this.getRight().findNode(data);

    return null;
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
