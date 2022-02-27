package algs4.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraphTest {
  private Graph graph;

  @BeforeAll
  void init() {
    graph = new Graph("src/test/java/algs4/graph/tinyG.txt");
  }

  @Test
  void testToString() {
    String expected = "Graph{0:[6,2,1,5], 1:[0], 2:[0], 3:[5,4], 4:[5,6,3], 5:[3,4,0], 6:[0,4], 7:[8], 8:[7], 9:[11,10,12], 10:[9], 11:[9,12], 12:[11,9]}";
    assertEquals(expected, graph.toString());
  }

  @Test
  void adj() {
    List<Integer> expected = new ArrayList<>();
    assertEquals(expected, graph.adjacency(-1));
    assertEquals(expected, graph.adjacency(Integer.MAX_VALUE));
  }

  @Test
  void edge() {
    assertEquals(13, graph.E());
  }
}