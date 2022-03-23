package algs4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
  private SymbolGraph G;

  public DegreesOfSeparation(String filename, String delimiter) {
    G = new SymbolGraph(filename, delimiter);
  }

  public SymbolGraph G() {
    return G;
  }

  public List<List<String>> separateByDegrees(String performer) {
    marked[symbol2Index.get(performer)] = true;
    List<List<String>> result = new ArrayList<>(10);

    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(symbol2Index.get(performer));

    while (!deque.isEmpty()) {
      int v = deque.poll();
      List<String> item = new ArrayList<>(10);

      for (int w : G.adjacency(v)) {
        if (marked[w]) continue;
        marked[w] = true;
        item.add(index2Symbol[w]);

        deque.offer(w);

//        for (int actor : G.adjacency(movie)) {
//          if (marked[actor]) continue;
//          marked[actor] = true;
//          item.add(index2Symbol[actor]);
//        }
      }
      result.add(item);
    }

    return result;
  }
}
