package algs4.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DegreesOfSeparationTest {
  @Test
  void test() {
    DegreesOfSeparation graph = new DegreesOfSeparation("src/test/java/algs4/graph/movies.txt", "/");

    assertTrue(graph.contains("Bacon, Kevin"));
    assertTrue(graph.contains("Woodward, Edward"));

    assertTrue(graph.separateByDegrees("Bacon, Kevin").get(0).contains("Kidman, Nicole"));

  }
}
