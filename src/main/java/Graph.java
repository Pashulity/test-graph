import java.util.List;

/*
 * Common interface for graph implementation
 *
 * */
public interface Graph<V, E> {

    void addVertex(V vertex);

    void addEdge(V source, V target, E edge);

    List<V> getPath(V start, V end);

}
