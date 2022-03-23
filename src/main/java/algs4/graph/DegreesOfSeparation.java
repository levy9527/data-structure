package algs4.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The input data structure looks like:
 * movie1: [performer, performer],
 * movie2: [performer, performer]
 * <br>
 * The process would be:
 * 1. To find the input performer's movies
 * 2. All the performers in the same movie with the input performer get number 1
 * 3. BFS adjacency vertices, with number increment
 *
 * <br>
 * Correction:
 * As it is mentioned before, using BFS, which has already done the job, without any further effort.
 * Finding the movies related to input performer(and to store it into a list) is a misconception——since it's processing graph,
 * the input performer's adjacency list is the collection of related movies!
 */
public class DegreesOfSeparation {
  private SymbolGraph symbolGraph;
  private BreathFirstPaths breathFirstPaths;

  public DegreesOfSeparation(String filename, String delimiter, String src) {
    symbolGraph = new SymbolGraph(filename, delimiter);
    if (symbolGraph.contains(src)) {
      breathFirstPaths = new BreathFirstPaths(symbolGraph.G(), symbolGraph.index(src));
    }
  }

  public SymbolGraph G() {
    return symbolGraph;
  }

  public List<String> separateByDegrees(String dest) {
    if (Objects.isNull(breathFirstPaths) || !symbolGraph.contains(dest)) return null;

    List<String> result = new ArrayList<>(10);
    for (Integer i : breathFirstPaths.pathTo(symbolGraph.index(dest))) {
      result.add(symbolGraph.name(i));
    }

    return result;
  }
}
