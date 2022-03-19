package algs4.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DegreesOfSeparationTest {
  @Test
  void test() {
    SymbolGraph graph = new SymbolGraph("src/test/java/algs4/graph/movies.txt", "/");

    assertTrue(graph.contains("Bacon, Kevin"));
    ;
  }
}
