package algs4.graph;

// How to know whether a graph is cyclic or acyclic
// Just remember how to detect cyclic in linked list? visited node visit again.
// So apply the same method to graph? revisit path/node detection.
// But the problem is, dfs has revisited mechanism to search
// How can we distinguish cyclic revisit from normal case?
public class Cyclic {
  private boolean marked[];
  private boolean cyclic;

  Cyclic(Graph G) {
    marked = new boolean[G.V()];

    for (int i = 0; i < G.V(); i++) {
      if (!marked[i]) dfs(G, i, i);
    }
  }

  // if merely detect cyclic, this code needs a little improvement: terminate loop and recursion ASAP
  private void dfs(Graph G, int v, int u) {
    marked[v] = true;

    for (int w : G.adjacency(v)) {
      if (!marked[w]) {
        dfs(G, w, v);
      }
      else if (w != u) {
        cyclic = true;
      }
    }
  }

  public boolean isCyclic() {
    return cyclic;
  }
}
