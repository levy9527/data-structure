import java.util.Objects;

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

  public BinarySortingTree getLeft() {
    return left;
  }

  public void setLeft(BinarySortingTree left) {
    this.left = left;
  }

  public BinarySortingTree getRight() {
    return right;
  }

  public void setRight(BinarySortingTree right) {
    this.right = right;
  }

  public BinarySortingTree getParent() {
    return parent;
  }

  public void setParent(BinarySortingTree parent) {
    this.parent = parent;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
