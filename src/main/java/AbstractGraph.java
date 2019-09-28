import java.util.*;

abstract class AbstractGraph<V, E> implements Graph<V, E> {

    Map<E, VertexPair<V>> vertexPairMap = new HashMap<>();

    Map<V, EdgeHolder<E>> graphMap = new HashMap<>();

    public LinkedList<V> getPath(V start, V end) {
        if (start == null || end == null) {
            throw new NullPointerException();
        }
        checkVertexExists(start);
        checkVertexExists(end);
        if (!start.equals(end)) {
            Deque<LinkedList<V>> paths = new ArrayDeque<>();
            Set<V> visited = new HashSet<>();
            initSearch(start, paths, visited);
            while (!paths.isEmpty()) {
                LinkedList<V> existed = paths.poll();
                V vertexPointer = existed.getLast();
                for (E edge : graphMap.get(vertexPointer).getOutgoingEdges()) {
                    V source = vertexPairMap.get(edge).getFirst();
                    V target = vertexPairMap.get(edge).getSecond();
                    V next;
                    if (vertexPointer.equals(source)) {
                        next = target;
                    } else if (vertexPointer.equals(target)) {
                        next = source;
                    } else {
                        throw new VertexNotFoundException();
                    }
                    if (!visited.contains(next)) {
                        visited.add(next);
                        LinkedList<V> existedPathCopy = new LinkedList<>(existed);
                        existedPathCopy.add(next);
                        if (next.equals(end)) {
                            return existedPathCopy;
                        }
                        paths.add(existedPathCopy);
                    }
                }
            }
            return new LinkedList<>();
        }
        return new LinkedList<>();
    }

    void checkVertexExists(V vertex) {
        if (!graphMap.containsKey(vertex)) {
            throw new VertexNotFoundException();
        }
    }

    private void initSearch(V start, Deque<LinkedList<V>> paths, Set<V> visited) {
        LinkedList<V> startPath = new LinkedList<>();
        startPath.add(start);
        paths.add(startPath);
        visited.add(start);
    }


}
