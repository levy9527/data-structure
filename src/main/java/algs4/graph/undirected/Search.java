package algs4.graph.undirected;


import algs4.graph.undirected.Graph;

public class Search {
  private boolean[] marked;
  private int count;
  private boolean connected;

  public Search(Graph G, int source) {
    marked = new boolean[G.V()];

    dfs(G, source);
    connected = count == G.V();
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count++;

    for (int w : G.adjacency(v)) {
      if (!marked[w]) dfs(G, w);
    }
  }

  /**
   * Strictly speaking, this API should be part of Graph, because `connected` is a natural characteristic of Graph,
   * and the parameter `source` takes no effect on the result of `connected`.
   * The reason that this API is written here is just to save computation, as `Search` has already done dfs.
   */
  public boolean connected() {
    return connected;
  }

  /**
   * is v connected to s
   */
  public boolean marked(int vertex) {
    return marked[vertex];

//   prefer calculating once on init to calculating on every invoking
//    marked[vertex] = true;
//    if (marked[source]) return true;
//
//    for (int v : G.adjacency(vertex)) {
//      if (!marked[v]) {
//        boolean result = marked(v);
//        if (result) return true;
//      }
//    }
//
//    return false;
  }

  /**
   * how many vertices are connected to s
   */
  public int count() {
    return count;
    // still, prefer calculating once
//    int result = 0;
//    for (boolean b : marked) {
//      if (b) {
//        result++;
//      }
//    }
//    return result;
  }
}
