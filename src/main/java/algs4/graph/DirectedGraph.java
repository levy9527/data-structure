package algs4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Only addEdge has difference from Graph
 * BFS and DFS are the same, without modification
 */
public class DirectedGraph {
  private static final int DEFAULT_CAPACITY = 10;

  private Set<Integer> V;
  private int E;
  private List<LinkedList<Integer>> adj;

  public DirectedGraph(int numberOfVertices) {
    initContainer(numberOfVertices);
  }

  public DirectedGraph(int numberOfVertices, String filename) {
    this(numberOfVertices);

    try {
      Scanner scanner = new Scanner(new File(filename));
      while (scanner.hasNextLine()) {
        String[] vertices = scanner.nextLine().split(" ");
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

  public void addEdge(int v, int w) {
    // disallow parallel or self-loop
    if (hasEdge(v, w) || v == w) return;

    LinkedList<Integer> vertexV = adj.get(v);
    vertexV.addFirst(w);

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

  public Iterable<Integer> adjacency(int v) {
    if (v >= adj.size() || v < 0) return Collections.EMPTY_LIST;
    return adj.get(v);
  }

  public DirectedGraph reverse() {
    DirectedGraph R = new DirectedGraph(this.V());
    for (int v = 0; v < this.V(); v++) {
      for (int w : adjacency(v)) {
        R.addEdge(w, v);
      }
    }
    return R;
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

    return "DirectedGraph{" +
        result +
        '}';
  }
}

