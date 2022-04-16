package algs4.graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstOrder {
  private boolean[] marked;
  private List<Integer> pre;
  private List<Integer> post;
  private LinkedList<Integer> reversePost;

  DepthFirstOrder(DirectedGraph G) {
    marked = new boolean[G.V()];
    pre = new ArrayList<>();
    post = new ArrayList<>();
    reversePost = new LinkedList<>();

    for(int i = 0; i < G.V(); i++) {
      if(!marked[i]) dfs(G, i);
    }
  }

  private void dfs(DirectedGraph G, int v) {
    marked[v] = true;

    pre.add(v);

    for (int w : G.adjacency(v)) {
      if (!marked[w]) dfs(G, w);
    }

    post.add(v);
    reversePost.addFirst(v);
  }

  Iterable<Integer> pre() {
    return pre;
  }

  Iterable<Integer> post() {
    return post;
  }

  Iterable<Integer> reversePost() {
    return reversePost;
  }
}
