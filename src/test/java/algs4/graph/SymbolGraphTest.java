package algs4.graph;

import algs4.graph.undirected.Graph;
import algs4.graph.undirected.SymbolGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SymbolGraphTest {
  private SymbolGraph symbolGraph;

  @BeforeAll
  void init() {
    symbolGraph = new SymbolGraph("src/test/java/algs4/graph/routes.txt", ",");
  }

  @Test
  void testSymbolGraph() {
    String den = "D EN";
    String hou = "H_OU";
    String jfk = "JFK";

    assertTrue(symbolGraph.contains(den));
    assertTrue(symbolGraph.contains(hou));
    assertTrue(symbolGraph.contains(jfk));

    assertEquals(den, symbolGraph.name(symbolGraph.index(den)));
    assertEquals(hou, symbolGraph.name(symbolGraph.index(hou)));
    assertEquals(jfk, symbolGraph.name(symbolGraph.index(jfk)));

    String jfkAdjArrayStr = "[ORD, ATL, MCO]";
    List<String> jfkAdjList = new ArrayList<>(3);
    Graph G = symbolGraph.G();

    for (int w : G.adjacency(symbolGraph.index(jfk))) {
      jfkAdjList.add(symbolGraph.name(w));
    }

    assertEquals(jfkAdjArrayStr, jfkAdjList.toString());
  }

  @Test
  void index() {
    assertEquals(-1, symbolGraph.index(""));
    assertEquals(-1, symbolGraph.index("do not exist"));
  }

  @Test
  void name() {
    assertTrue(StringUtils.isBlank(symbolGraph.name(-1)));
    assertTrue(StringUtils.isBlank(symbolGraph.name(Integer.MAX_VALUE)));
  }
}