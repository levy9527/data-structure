package algs4.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * it can find the shortest path
 */
public class BreathFirstPaths implements Paths{
  private boolean[] marked;
  private int[] edgeTo;

  BreathFirstPaths(Graph G, int src) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];

    bfs(G, src);
  }

  private void bfs(Graph G, int src) {
    marked[src] = true;

    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(src);

    while (!queue.isEmpty()) {
      int v = queue.poll();

      for (int w : G.adjacency(v)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = v;
          queue.offer(w);
        }
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
