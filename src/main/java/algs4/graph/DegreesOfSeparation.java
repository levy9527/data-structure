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
 * 1. To find the input performer's movies, using inverted index (performer -> movie)
 * 2. All the performers in the same movie with the input performer get number 1
 * 3. BFS adjacency vertices, with number increment
 */
public class DegreesOfSeparation {
  private Graph G;
  private Map<String, Integer> symbol2Index;
  private String[] index2Symbol;

  public DegreesOfSeparation(String filename, String delimiter) {
    try {
      // read input and initialize
      Scanner scanner = new Scanner(new File(filename));

      List<String> lines = new ArrayList<>(10);

      // how to know how many vertices are there?
      // count by splitting input line
      int i = 0;
      symbol2Index = new HashMap<>(16);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        lines.add(line);

        String[] vertices = line.split(delimiter);
        for (String vertex : vertices) {
          String trim = vertex.trim();
          if (!symbol2Index.containsKey(trim)) {
            symbol2Index.put(trim, i++);
          }
        }
      }

      // now variable i represent adj array length
      G = new Graph(i);
      for (String line : lines) {
        String[] vertices = line.split(delimiter);
        int movie = symbol2Index.get(vertices[0].trim());

        for (int j = 1; j < vertices.length; j++) {
          G.addEdge(movie, symbol2Index.get(vertices[j].trim()));
        }
      }

      index2Symbol = new String[i];
      for (Map.Entry<String, Integer> entry : symbol2Index.entrySet()) {
        index2Symbol[entry.getValue()] = entry.getKey();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  // the rest methods are the same with SymbolGraph
  public Graph G() {
    return G;
  }

  public boolean contains(String symbol) {
    return symbol2Index.containsKey(symbol);
  }

  public int index(String symbol) {
    Integer result = symbol2Index.get(symbol);
    return Objects.nonNull(result) ? result : -1;
  }

  public String name(int index) {
    if (index < 0 || index >= index2Symbol.length) return "";
    return index2Symbol[index];
  }

}
