package algs4.graph;

import algs4.graph.directed.DirectedCycle;
import algs4.graph.directed.DirectedGraph;
import algs4.graph.directed.StronglyConnectedComponents;
import algs4.graph.directed.Topological;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DirectedGraphTest {
  DirectedGraph tinyG;

  @BeforeAll
  void init() {
    tinyG = new DirectedGraph(13,"src/test/java/algs4/graph/tinyDG.txt");
  }

  @Test
  void testToString() {
    String expected = "DirectedGraph{0:[5,1], 1:[], 2:[0,3], 3:[5,2], 4:[3,2], 5:[4], 6:[9,4,0], 7:[6,8], 8:[7,9], 9:[11,10], 10:[12], 11:[4,12], 12:[9]}";
    assertEquals(expected, tinyG.toString());
  }

  @Test
  void cycle() {
    DirectedCycle directedCycle = new DirectedCycle(tinyG);

    assertTrue(directedCycle.hasCycle());
    assertNotNull(directedCycle.cycle());
    assertEquals("[5, 4, 3, 5]", directedCycle.cycle().toString());
  }

  @Test
  void topological() {
    DirectedGraph DAG = new DirectedGraph(13, "src/test/java/algs4/graph/DAG.txt");
    Topological topological = new Topological(DAG);
    assertEquals("[8, 7, 2, 3, 0, 6, 9, 11, 12, 10, 1, 5, 4]", topological.order().toString());
  }

  @Test
  void SCC() {
    DirectedGraph DAG = new DirectedGraph(13, "src/test/java/algs4/graph/DAG.txt");
    StronglyConnectedComponents SCCDAG = new StronglyConnectedComponents(DAG);
    assertEquals(DAG.V(), SCCDAG.count());

    StronglyConnectedComponents SCCTinyG = new StronglyConnectedComponents(tinyG);
    assertEquals(5, SCCTinyG.count());
    assertNotEquals(tinyG.V(), SCCTinyG.count());
    assertTrue(SCCTinyG.isSCC(0, 5));
    assertTrue(SCCTinyG.isSCC(7, 8));
    assertTrue(SCCTinyG.isSCC(9, 12));
    assertFalse(SCCTinyG.isSCC(0, 6));
  }
}