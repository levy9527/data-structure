package algs4.graph.sp;

public interface SP {
  double distTo(int v);

  boolean hasPathTo(int v);

  Iterable<DirectedEdge> pathTo(int v);
}
