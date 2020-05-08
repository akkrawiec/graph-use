package org.ak.pathfinder;

import org.ak.graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 */
public class DijkstraPathFinder<V, E, C> implements PathFinder<V, E, C> {
    @Override
    public List<V> findPath(Graph<V, E> graph, V start, V goal, BiFunction<V, E, C> costFunction, Function<List<C>, C> costSumFunction, Comparator<C> costSumComparator) {
        List<V> result = new ArrayList<V>();
        return result;
    }
}