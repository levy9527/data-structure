package algs4.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The SCC api is analogous to CC
 *
 * A simple solution with quadratic time complexity would be:
 * 1. forEach every vertex
 * 2. dfs(vertex) in the loop, collecting its reachability info
 */
public class StronglyConnectedComponents {
  Map<Integer, Integer> index2Component;

  StronglyConnectedComponents(DirectedGraph G) {
    index2Component = new HashMap<>();
  }

  boolean stronglyConnected(int v, int w) {
    if (Objects.isNull(index2Component.get(v)) ||
        Objects.isNull(index2Component.get(w))
    ) return false;

    return index2Component.get(v).equals(index2Component.get(w));
  }

  int count() {

  }

  int id(int v) {
    Integer result = index2Component.get(v);
    return Objects.nonNull(result) ? result : -1;
  }
}
