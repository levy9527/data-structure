package algs4.graph;

/**
 * The SCC api is analogous to CC
 * A strongly connected component means cycle exist
 * So DAG's SCC count == DAG.V()
 */
public class StronglyConnectedComponents {
  private int count;
  private boolean[] marked;
  private int[] id;

  StronglyConnectedComponents(DirectedGraph G) {
    marked = new boolean[G.V()];
    id = new int[G.V()];

    DepthFirstOrder order = new DepthFirstOrder(G.reverse());
    for (int v : order.reversePost()) {
      if(!marked[v]) {
        count++;
        dfs(G, v);
      }
    }
  }

  private void dfs(DirectedGraph G, int v) {
    marked[v] = true;
    id[v] = count;

    for (int w : G.adjacency(v)) {
      if (!marked[w]) dfs(G, w);
    }
  }

  int id(int v) {
    if (v < -1 || v >= id.length) return -1;
    return id[v];
  }

  int count() {
    return count;
  }

  boolean isSCC (int v, int w) {
    if (v < 0 || v >= id.length) return false;
    if (w < 0 || w >= id.length) return false;

    return id[v] == id[w];
  }
}
