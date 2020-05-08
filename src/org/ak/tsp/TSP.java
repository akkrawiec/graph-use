package org.ak.tsp;

import org.ak.graph.Graph;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface TSP<V, E, C> {
    public List<E> findPath(Graph<V, E> graph, BiFunction<V, E, C> costFunction, Function<List<C>, C> costSumFunction, Comparator<C> costSumComparator);
}
