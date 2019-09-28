/*
* Undirected graph implementation
*
* */
public class UndirectedGraph<V, E> extends AbstractGraph<V, E> implements Graph<V, E> {

    public UndirectedGraph() {
    }

    public void addVertex(V vertex) {
        if (!graphMap.containsKey(vertex)) {
            graphMap.put(vertex, new UndirectedEdgeHolder<>());
        }
    }

    public void addEdge(V source, V target, E edge) {
        if (source == null || target == null) {
            throw new NullPointerException();
        }
        checkVertexExists(source);
        checkVertexExists(target);
        if (source.equals(target)) return;
        UndirectedEdgeHolder<E> eEdgeHolder = (UndirectedEdgeHolder<E>) graphMap.get(source);
        eEdgeHolder.getEdges().add(edge);
        eEdgeHolder.getEdges().add(edge);
        vertexPairMap.put(edge, new VertexPair<>(source, target));
    }

}
