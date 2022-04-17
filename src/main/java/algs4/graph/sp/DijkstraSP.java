package algs4.graph.sp;

import algs4.graph.mst.EdgeWeightedGraph;

public class DijkstraSP implements SP{
  public DijkstraSP(EdgeWeightedGraph G, int s) {
  }

  @Override
  public double distTo(int v) {
    return 0;
  }

  @Override
  public boolean hasPathTo(int v) {
    return false;
  }

  @Override
  public Iterable<DirectedEdge> pathTo(int v) {
    return null;
  }
}
