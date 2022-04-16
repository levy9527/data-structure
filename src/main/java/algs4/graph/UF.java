package algs4.graph;

import java.util.Arrays;

public class UF {
  private int[] id;
  private int count;
  private int[] size;

  /**
   * @param N number of pairs
   */
  public UF(int N) {
    if (N < 0) throw new IllegalArgumentException("N must >= 0");
    count = N;

    id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;

    // for weighted union
    size = new int[N];
    Arrays.fill(size, 1);
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    while (p != id[p]) p = id[p];
    return p;
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    id[pRoot]= qRoot;

    count--;
  }

  // with faster performance but also with more memory cost
  public void weightedUnion(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    if (size[pRoot] < size[qRoot]) {
      id[pRoot]= qRoot;
      size[qRoot] += size[pRoot];
    }
    else {
      id[qRoot]= pRoot;
      size[pRoot] += size[qRoot];
    }

    count--;
  }

  public int count() {
    return count;
  }

  public int[] getId() {
    return id;
  }
}
