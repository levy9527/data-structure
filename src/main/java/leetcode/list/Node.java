package leetcode.list;

import collection.BinarySortingTree;

/**
 * 二叉树节点
 */
public class Node {
  public int val;
  public BinarySortingTree left;
  public BinarySortingTree right;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, BinarySortingTree _left, BinarySortingTree _right) {
    val = _val;
    left = _left;
    right = _right;
  }
};
