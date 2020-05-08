package org.ak.pathfinder;

import org.ak.graph.Graph;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Path finder ADT
 */
public interface PathFinder<V, E, C> {
    /**
     * Path finder function
     * @param graph to search path in
     * @param start start vertex
     * @param goal goal vertex
     * @param costFunction function to compute cost
     * @param costSumFunction function to compute costs sum
     * @param costSumComparator cost comparator function
     * @return path, list of vertices if path exists, empty otherwise
     */
    public List<V> findPath(Graph<V, E> graph, V start, V goal, BiFunction<V, E, C> costFunction, Function<List<C>, C> costSumFunction, Comparator<C> costSumComparator);

    public static class Factory  {
        public static PathFinder getInstance(Algorithm algorithm) {
            switch (algorithm) {
                //case DIJKSTRA:
                  //  return new DijkstraPathFinder();
                case UCS:
                    return new UCSPathFinder();
                case FLOYD_WARSHALL:
                    return new FloydWarshallPathFinder();
                default:
                    return null;
            }
        }
    }

    public enum Algorithm {
        //DIJKSTRA,
        UCS,
        FLOYD_WARSHALL
    }
}
