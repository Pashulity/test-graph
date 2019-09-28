import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class GraphTest {

    @Test
    public void undirectedPathTest() {
        Graph<String, String> graph = new UndirectedGraph<>();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("1", "2", "12");
        graph.addEdge("1", "3", "13");
        graph.addEdge("1", "4", "14");
        graph.addEdge("2", "4", "24");
        graph.addEdge("3", "4", "34");

        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("1");
        expectedPath.add("4");

        Assertions.assertIterableEquals(expectedPath, graph.getPath("1", "4"));
    }

    @Test
    public void directedPathTest() {
        Graph<String, String> graph = new DirectedGraph<>();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("1", "2", "12");
        graph.addEdge("1", "3", "13");
        graph.addEdge("4", "1", "41");
        graph.addEdge("4", "2", "42");
        graph.addEdge("3", "4", "34");

        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("1");
        expectedPath.add("3");
        expectedPath.add("4");

        Assertions.assertIterableEquals(expectedPath, graph.getPath("1", "4"));
    }

}
