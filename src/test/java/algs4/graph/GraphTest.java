package algs4.graph;

import org.junit.jupiter.api.BeforeAll;
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

  @Test
  void vertex() {
    assertEquals(13, graph.V());
  }

  @Test
  void search() {
    assertEquals(true, new Search(graph, 0).marked(1));
    assertEquals(true, new Search(graph, 0).marked(3));
    assertEquals(false, new Search(graph, 0).marked(9));

    assertEquals(7, new Search(graph, 0).count());
    assertEquals(4, new Search(graph, 9).count());

    assertEquals(false, new Search(graph, 0).connected());
    assertEquals(false, new Search(graph, 9).connected());
  }

  @Test
  void dfsPaths() {
    DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 0);

    assertEquals(true, depthFirstPaths.hasPathTo(1));
    assertEquals(true, depthFirstPaths.hasPathTo(6));
    assertEquals(false, depthFirstPaths.hasPathTo(7));
    assertEquals(false, depthFirstPaths.hasPathTo(9));

    assertEquals("[0, 2]", depthFirstPaths.pathTo(2).toString());
    assertEquals("[0, 6, 4, 5]", depthFirstPaths.pathTo(5).toString());
    assertEquals("[0, 6, 4, 5, 3]", depthFirstPaths.pathTo(3).toString());

    assertEquals(true, new DepthFirstPaths(graph, 9).hasPathTo(10));
  }

  @Test
  void bfsPaths() {
    BreathFirstPaths breathFirstPaths = new BreathFirstPaths(graph, 0);
    assertEquals(true, breathFirstPaths.hasPathTo(1));
    assertEquals(true, breathFirstPaths.hasPathTo(6));
    assertEquals(false, breathFirstPaths.hasPathTo(7));
    assertEquals(false, breathFirstPaths.hasPathTo(9));

    assertEquals("[0, 2]", breathFirstPaths.pathTo(2).toString());
    assertEquals("[0, 5]", breathFirstPaths.pathTo(5).toString());
    assertEquals("[0, 5, 3]", breathFirstPaths.pathTo(3).toString());
  }

  @Test
  void connectedComponents() {
    ConnectedComponents cc = new ConnectedComponents(graph);

    assertEquals(3, cc.count());
    assertEquals(2, cc.id(9));
    assertTrue(cc.isConnected(0, 1));
    assertFalse(cc.isConnected(0, 9));
  }
}