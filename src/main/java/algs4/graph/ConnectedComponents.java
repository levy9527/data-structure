package algs4.graph;

import java.util.HashMap;
import java.util.Map;

public class ConnectedComponents {
  boolean marked[];
  // use int[] for more simplicity
  Map<Integer, Integer> vertex2Component;
  int count;

  ConnectedComponents(Graph G) {
    marked = new boolean[G.V()];
    vertex2Component = new HashMap<>(16);
    count = 0;

    // based on dfs, it's easy to come up with the idea that use a loop to search the whole map
    // so the key question is: how can we know to which component a vertex belongs in a constant time?
    for (int i = 0; i < G.V(); i++) {
      if (!marked[i]) {
        dfs(G, i, count++);
      }
    }
  }

  private void dfs(Graph G, int v, int count) {
    marked[v] = true;
    vertex2Component.put(v, count);

    for (int w : G.adjacency(v)) {
      if (!marked[w]) {
        dfs(G, w, count);
      }
    }
  }

  /**
   * are v and w connected
   * intrinsically compare two vertices component id
   */
  boolean isConnected(int v, int w) {
    return vertex2Component.get(v).equals(vertex2Component.get(w));
  }

  /**
   * number of connected components
   */
  int count() {
    return count;
  }

  /**
   * component identifier for v
   * @return  between 0 and count()-1
   */
  int id(int v) {
    return vertex2Component.get(v);
  }
}
