package algs4.graph;

import java.util.LinkedList;
import java.util.List;

public class DirectedCycle {
  private boolean[] marked;
  private boolean[] onStack;
  private int[] edgeTo;
  private boolean hasCycle;
  private LinkedList<Integer> cycle;

  public DirectedCycle(DirectedGraph directedGraph) {
    marked = new boolean[directedGraph.V()];
    onStack = new boolean[directedGraph.V()];
    edgeTo = new int[directedGraph.V()];

    for (int i = 0; i < directedGraph.V(); i++) {
      if (!marked[i]) dfs(directedGraph, i);
    }
  }

  private void dfs(DirectedGraph directedGraph, int v) {
//    if (hasCycle) return;
    marked[v] = true;
    onStack[v] = true;

    for (int w : directedGraph.adjacency(v)) {
      // Attention: to return in the loop rather than in the first line of dfs function
      if (hasCycle) return;

      // typical situation: answering the question of how to search path by the end will help you understand why stores w -> v
      edgeTo[w] = v;

      if(marked[w] && onStack[w]) {
        hasCycle = true;

        cycle = new LinkedList<>();
        cycle.addFirst(w);
        for (int parent = edgeTo[w]; w != parent; parent = edgeTo[parent]) {
          cycle.addFirst(parent);
        }
        cycle.addFirst(w);

        return;
      }
      else {
        dfs(directedGraph, w);
      }
    }

    onStack[v] = false;
  }

  boolean hasCycle() {
    return hasCycle;
  }

  List<Integer> cycle() {
    return cycle;
  }
}
