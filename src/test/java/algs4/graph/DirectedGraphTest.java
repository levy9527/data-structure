package algs4.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DirectedGraphTest {
  DirectedGraph directedGraph;

  @BeforeAll
  void init() {
    directedGraph = new DirectedGraph(13,"src/test/java/algs4/graph/tinyDG.txt");
  }

  @Test
  void testToString() {
    String expected = "DirectedGraph{0:[5,1], 1:[], 2:[0,3], 3:[5,2], 4:[3,2], 5:[4], 6:[9,4,0], 7:[6,8], 8:[7,9], 9:[11,10], 10:[12], 11:[4,12], 12:[9]}";
    assertEquals(expected, directedGraph.toString());
  }

  @Test
  void cycle() {
    DirectedCycle directedCycle = new DirectedCycle(directedGraph);

    assertTrue(directedCycle.hasCycle());
    assertNotNull(directedCycle.cycle());
    assertEquals("[5, 4, 3, 5]", directedCycle.cycle().toString());
  }
}