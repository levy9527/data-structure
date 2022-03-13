package algs4.graph;

/**
 * Essentially, it's a problem of bipartite graph detection
 * Thinking of its definition: all edges connected two different set vertices
 */
public class Bipartite {
  // ❌wrong method:
  // ❌odd and even indices have different value
  // ❌like 0/2: true, 1/3: false
  // ❌or 0/2: false, 1/3: true

  // index denotes vertex, value denotes color
  // ✅ next(adjacency) index's color should base on its previous one, being opposite
  private boolean color[];
  private boolean marked[];
  private boolean twoColorable;

  Bipartite(Graph G) {
    color = new boolean[G.V()];
    marked = new boolean[G.V()];
    twoColorable = true;

    for (int i = 0; i < G.V(); i++) {
      if (!marked[i]) {
        dfs(G, i, false);
      }
    }
  }

  // What should be done to detect is two-color-able with color[] in dfs?
  // I have no idea because I don't have test cases, and I cannot give a not two-color-able example!
  private void dfs(Graph G, int v, boolean prevColor) {
    marked[v] = true;
    color[v] = !prevColor;

    for (int w : G.adjacency(v)) {
      if (!marked[w]) {
        dfs(G, w, color[v]);
      }
      // ✅ key code lies here: when revisiting, compare two adjacency vertices' color
      else if (color[w] == color[v]) {
        twoColorable = false;
      }
    }
  }

  public boolean isBipartite() {
    return twoColorable;
  }
}
