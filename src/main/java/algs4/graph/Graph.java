package algs4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
  private static final int DEFAULT_CAPACITY = 10;
  private static final List<Integer> EMPTY_ARRAY = new ArrayList<>();

  private Set<Integer> V;
  private int E;
  private List<LinkedList<Integer>> adj;

  Graph(String filename) {
    try {
      Scanner scanner = new Scanner(new File(filename));
      List<String> lines = new ArrayList<>(DEFAULT_CAPACITY);
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }

      // initialize
      V = new HashSet<>();
      adj = new ArrayList<>(lines.size());
      for (int i = 0; i <lines.size(); i++) {
        adj.add(new LinkedList<>());
      }

      for (String line : lines) {
        String[] vertices = line.split(" ");
        addEdge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * add edge v-x to this graph
   * to make this method public, need to deal with IndexOutOfBoundsException
   */
  private void addEdge(Integer v, Integer w) {
    LinkedList<Integer> vertexV = adj.get(v);
    vertexV.addFirst(w);

    LinkedList<Integer> vertexW = adj.get(w);
    vertexW.addFirst(v);
    E++;

    V.add(v);
    V.add(w);
  }

  public int V() {
    return V.size();
  }

  public int E() {
    return E;
  }

  public Iterable<Integer> adjacency(int v) {
    if (v >= adj.size() || v < 0) return EMPTY_ARRAY;
    return adj.get(v);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int v = 0; v < adj.size(); v++) {
      result.append(v).append(":[");

      int size = adj.get(v).size();
      for(int i = 0; i < size; i++) {
        result.append(adj.get(v).get(i));
        if (i != size - 1) {
          result.append(",");
        }
      }

      result.append("]");
      if (v != adj.size() - 1) {
        result.append(", ");
      }
    }

    return "Graph{" +
        result +
        '}';
  }
}
