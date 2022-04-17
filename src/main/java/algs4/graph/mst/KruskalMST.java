package algs4.graph.mst;

import algs4.graph.UF;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST implements MST{
  private List<EdgeWeighted> mst;

  public KruskalMST(EdgeWeightedGraph G) {
    PriorityQueue<EdgeWeighted> queue = new PriorityQueue<>();
    for (EdgeWeighted edge : G.edges()) queue.add(edge);

    UF uf = new UF(G.V());
    // the MST only needs V-1 edges
    int maxEdge = G.V() - 1;
    mst = new ArrayList<>(maxEdge);
    while (!queue.isEmpty() && mst.size() < maxEdge) {
      EdgeWeighted edgeWeighted = queue.poll();
      int p = edgeWeighted.either();
      int q = edgeWeighted.other(p);

      if (uf.connected(p, q)) continue;

      uf.union(p, q);
      mst.add(new EdgeWeighted(p, q, edgeWeighted.weighted()));
    }
  }

  @Override
  public Iterable<EdgeWeighted> edges() {
    return mst;
  }

  @Override
  public double weight() {
    return 0D;
  }
}
