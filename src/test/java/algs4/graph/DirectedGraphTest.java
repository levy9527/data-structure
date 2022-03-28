package algs4.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

  @Test
  void testToString() {
    DirectedGraph directedGraph = new DirectedGraph(13,"src/test/java/algs4/graph/tinyDG.txt");
    String expected = "DirectedGraph{0:[5,1], 1:[], 2:[0,3], 3:[5,2], 4:[3,2], 5:[4], 6:[9,4,0], 7:[6,8], 8:[7,9], 9:[11,10], 10:[12], 11:[4,12], 12:[9]}";
    assertEquals(expected, directedGraph.toString());
  }
}