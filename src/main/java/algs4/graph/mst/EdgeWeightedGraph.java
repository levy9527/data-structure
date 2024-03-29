package algs4.graph.mst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// similar to undirected graph
public class EdgeWeightedGraph {
  private static final int DEFAULT_CAPACITY = 10;

  private Set<Integer> V;
  private int E;
  private List<LinkedList<Integer>> adj;

  public EdgeWeightedGraph(int numberOfVertices) {
    initContainer(numberOfVertices);
  }

  public EdgeWeightedGraph(String filename) {
    try {
      Scanner scanner = new Scanner(new File(filename));
      List<String> lines = new ArrayList<>(DEFAULT_CAPACITY);
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }

      initContainer(lines.size());

      for (String line : lines) {
        String[] vertices = line.split(" ");
        addEdge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void initContainer(int numberOfVertices) {
    V = new HashSet<>();
    adj = new ArrayList<>(numberOfVertices);
    for (int i = 0; i < numberOfVertices; i++) {
      adj.add(new LinkedList<>());
    }
  }

  /**
   * add edge v-x to this graph
   * to make this method public, need to deal with IndexOutOfBoundsException
   */
  public void addEdge(int v, int w) {
    // disallow parallel or self-loop
    if (hasEdge(v, w) || v == w) return;

    LinkedList<Integer> vertexV = adj.get(v);
    vertexV.addFirst(w);

    LinkedList<Integer> vertexW = adj.get(w);
    vertexW.addFirst(v);
    E++;

    V.add(v);
    V.add(w);
  }

  public boolean hasEdge(int v, int w) {
    if (Objects.isNull(adj.get(v))) return false;

    for (int x : adj.get(v)) {
      if (x == w) return true;
    }

    return false;
  }

  public int V() {
    return V.size();
  }

  public int E() {
    return E;
  }

  public Iterable<EdgeWeighted> edges() {
    return Collections.emptyList();
  }

  public Iterable<Integer> adjacency(int v) {
    if (v >= adj.size() || v < 0) return Collections.EMPTY_LIST;
    return adj.get(v);
  }

}
