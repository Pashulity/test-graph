/*
 * Directed graph implementation
 *
 * */
public class DirectedGraph<V, E> extends AbstractGraph<V, E> {


    DirectedGraph() {
    }

    public void addVertex(V vertex) {
        if (!graphMap.containsKey(vertex)) {
            graphMap.put(vertex, new DirectedEdgeHolder<>());
        }
    }

    public void addEdge(V source, V target, E edge) {
        if (source == null || target == null) {
            throw new NullPointerException();
        }
        checkVertexExists(source);
        checkVertexExists(target);
        if (source.equals(target)) return;
        graphMap.get(source).getOutgoingEdges().add(edge);
        ((DirectedEdgeHolder<E>) graphMap.get(target)).getIncomingEdges().add(edge);
        vertexPairMap.put(edge, new VertexPair<>(source, target));
    }

}
