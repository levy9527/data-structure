package algs4.graph.directed;

/**
 * The process is:
 * 1. makes sure it's DAG
 * 2. DFS with order: pre/post/reversePost
 */
public class Topological {
  private boolean ifDag;
  private Iterable<Integer> order;

  public Topological(DirectedGraph G) {
    DirectedCycle directedCycle = new DirectedCycle(G);
    ifDag = !directedCycle.hasCycle();

    if (ifDag) {
      DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
      order = depthFirstOrder.reversePost();
    }
  }

  public boolean isDAG() {
    return ifDag;
  }

  public Iterable<Integer> order() {
    return order;
  }
}
