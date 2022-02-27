package algs4.graph;

import java.util.List;

public interface Paths {
  boolean hasPathTo(int dest);

  List<Integer> pathTo(int dest);
}
