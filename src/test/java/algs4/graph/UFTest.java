package algs4.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UFTest {
  @Test
  void quickUnionInWorstCase() {
    int N = 8;
    UF uf = new UF(N);

    for (int i = 1; i < N; i++) {
      uf.union(0, i);
    }

    assertEquals(1, uf.count());
    assertTrue(uf.connected(0, 4));
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 7}, uf.getId());
  }

  @Test
  void weightedUnionInWorstCase() {
    int N = 8;
    UF uf = new UF(N);

    for (int i = 1; i < N; i++) {
      uf.weightedUnion(0, i);
    }

    assertEquals(1, uf.count());
    assertTrue(uf.connected(0, 4));
    assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, uf.getId());
  }

}