package algs4.graph;


public class Search {
  private boolean[] marked;
  private int count;

  public Search(Graph G, int source) {
    marked = new boolean[G.V()];

    dfs(G, source);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count++;

    for (int w : G.adjacency(v)) {
      if (!marked[w]) dfs(G, w);
    }
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
