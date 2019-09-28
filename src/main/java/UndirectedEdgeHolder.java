import java.util.HashSet;
import java.util.Set;

/*
 * Holds vertex edges for undirected graph
 *
 * */
class UndirectedEdgeHolder<E> implements EdgeHolder<E> {

    private Set<E> edges;

    UndirectedEdgeHolder() {
    }

    Set<E> getEdges() {
        if (edges == null) {
            edges = new HashSet<E>();
        }
        return edges;
    }

    @Override
    public Set<E> getOutgoingEdges() {
        return getEdges();
    }
}
