package algs4.graph;

import algs4.graph.mst.EdgeWeightedGraph;
import algs4.graph.sp.DijkstraSP;
import algs4.graph.sp.SP;
import org.junit.jupiter.api.Test;

public class SPTest {
  @Test
  void dijkstra() {
    EdgeWeightedGraph G = new EdgeWeightedGraph("src/test/java/algs4/graph/tinyEWG.txt");
    int s = 0;
    SP dijkstra = new DijkstraSP(G, s);
  }
}
