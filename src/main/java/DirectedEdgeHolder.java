import java.util.HashSet;
import java.util.Set;

/*
 * Holds vertex edges for directed graph
 *
 * */
class DirectedEdgeHolder<E> implements EdgeHolder<E> {

    private Set<E> incomingEdges;

    private Set<E> outgoingEdges;

    DirectedEdgeHolder() {
    }

    Set<E> getIncomingEdges() {
        if (incomingEdges == null) {
            incomingEdges = new HashSet<>();
        }
        return incomingEdges;
    }

    @Override
    public Set<E> getOutgoingEdges() {
        if (outgoingEdges == null) {
            outgoingEdges = new HashSet<E>();
        }
        return outgoingEdges;
    }
}
