package algs4.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
  private Graph graph;

  @BeforeEach
  void init() {
    graph = new Graph("src/test/java/algs4/graph/tinyG.txt");
  }

  @Test
  void testToString() {
    String expected = "Graph{0:[6,2,1,5], 1:[0], 2:[0], 3:[5,4], 4:[5,6,3], 5:[3,4,0], 6:[0,4], 7:[8], 8:[7], 9:[11,10,12], 10:[9], 11:[9,12], 12:[11,9]}";
    assertEquals(expected, graph.toString());
  }
}