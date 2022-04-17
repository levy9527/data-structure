package algs4.graph;

import algs4.graph.mst.EdgeWeightedGraph;
import algs4.graph.mst.MST;
import org.junit.jupiter.api.Test;

public class MSTTest {
  @Test
  void weighted() {
    EdgeWeightedGraph G = new EdgeWeightedGraph("src/test/java/algs4/graph/tinyEWG.txt");
    MST mst = new MST(G);

  }
}
