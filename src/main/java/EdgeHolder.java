import java.util.Set;

/*
 * Common interface for graph edge implementation
 *
 * */
interface EdgeHolder<E> {

    Set<E> getOutgoingEdges();

}
