
/*
* Pair of two vertices connected by the edge
*
* If graph is directed, first vertex is source, second one is target
*
* */
class VertexPair<V> {

    VertexPair(V first, V second) {
        this.first = first;
        this.second = second;
    }

    private V first;

    private V second;

    V getFirst() {
        return first;
    }

    V getSecond() {
        return second;
    }

}
