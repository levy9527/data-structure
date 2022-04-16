package algs4.graph.undirected;

import algs4.graph.Paths;
import algs4.graph.undirected.Graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstPaths implements Paths {
  private boolean[] marked;
  private int[] edgeTo;

  /**
   * calculate once, on initializing
   */
  public DepthFirstPaths(Graph G, int src) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];

    dfs(G, src);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;

    for(int w : G.adjacency(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }

  @Override
  public boolean hasPathTo(int dest) {
    return marked[dest];
  }

  @Override
  public List<Integer> pathTo(int dest) {
    LinkedList<Integer> result = new LinkedList<>();

    for (int parent = dest; parent != 0; parent = edgeTo[parent]) {
      result.addFirst(parent);
    }
    result.addFirst(0);

    return result;
  }
}
