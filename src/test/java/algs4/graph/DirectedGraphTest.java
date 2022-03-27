package algs4.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

  @Test
  void testToString() {
    DirectedGraph directedGraph = new DirectedGraph("src/test/java/algs4/graph/tinyG.txt");
    String expected = "DirectedGraph{0:[6,2,1,5], 1:[], 2:[], 3:[], 4:[3], 5:[3,4], 6:[4], 7:[8], 8:[], 9:[11,10,12], 10:[], 11:[12], 12:[]}";
    assertEquals(expected, directedGraph.toString());
  }
}