package algs4.graph;

import algs4.graph.undirected.DegreesOfSeparation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DegreesOfSeparationTest {
  @Test
  void test() {
    DegreesOfSeparation personGraph = new DegreesOfSeparation("src/test/java/algs4/graph/movies.txt", "/", "Bacon, Kevin");

    assertTrue(personGraph.G().contains("Bacon, Kevin"));
    assertTrue(personGraph.G().contains("Woodward, Edward"));
    assertFalse(personGraph.G().contains("levy"));

    assertEquals(null, personGraph.separateByDegrees("levy"));
    assertTrue(personGraph.separateByDegrees("Kidman, Nicole").contains("Kidman, Nicole"));


    DegreesOfSeparation movieGraph = new DegreesOfSeparation("src/test/java/algs4/graph/movies.txt", "/", "Animal House (1978)");
    assertTrue(movieGraph.separateByDegrees("To Catch a Thief (1955)").contains("Animal House (1978)"));


    DegreesOfSeparation routeGraph = new DegreesOfSeparation("src/test/java/algs4/graph/routes.txt", ",", "JFK");
    assertEquals("[JFK, ORD, PHX, LAS]", routeGraph.separateByDegrees("LAS").toString());
  }
}
