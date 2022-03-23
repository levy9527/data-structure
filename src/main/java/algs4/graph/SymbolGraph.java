package algs4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The key point is: transform symbol into index
 */
public class SymbolGraph {
  private Graph G;
  private Map<String, Integer> symbol2Index;
  private String[] index2Symbol;

  public SymbolGraph(String filename, String delimiter) {
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

        // build forward index
        String[] vertices = line.split(delimiter);
        for (String vertex : vertices) {
          String trim = vertex.trim();
          if (!symbol2Index.containsKey(trim)) {
            symbol2Index.put(trim, i++);
          }
        }
      }

      // now variable i represent adj array length
      // build inverted index
      index2Symbol = new String[i];
      for (Map.Entry<String, Integer> entry : symbol2Index.entrySet()) {
        index2Symbol[entry.getValue()] = entry.getKey();
      }

      // init Graph
      G = new Graph(i);
      for (String line : lines) {
        String[] vertices = line.split(delimiter);
        int v = symbol2Index.get(vertices[0].trim());

        for (int j = 1; j < vertices.length; j++) {
          G.addEdge(v, symbol2Index.get(vertices[j].trim()));
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Graph G() {
    return G;
  }

  public boolean contains(String symbol) {
    return symbol2Index.containsKey(symbol);
  }

  // symbol -> index, forward index
  public int index(String symbol) {
    Integer result = symbol2Index.get(symbol);
    return Objects.nonNull(result) ? result : -1;
  }

  // index -> symbol, inverted index
  // why it's "inverted" ? Because it's from "forward" to "inverted": https://en.wikipedia.org/wiki/Search_engine_indexing#The_forward_index
  public String name(int index) {
    if (index < 0 || index >= index2Symbol.length) return "";
    return index2Symbol[index];
  }

}
