package algs4.graph;

import java.util.List;

/**
 * Connectivity problem.
 * Given a graph, support queries of the form:
 * - Are two given vertices connected ?
 * - and How many connected components does the graph have ?
 */
public interface Paths {
  boolean hasPathTo(int dest);

  /**
   * The key point is to construct a path tree
   * Since `dest` is the input parameter, it calls for inverted index to search the parent node
   * @param dest
   * @return
   */
  List<Integer> pathTo(int dest);
}
