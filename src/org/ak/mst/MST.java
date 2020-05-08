package org.ak.mst;

import org.ak.graph.Graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiFunction;

public interface MST<V, E, C> {
    public Collection<V> buildTree(Graph<V, E> graph, BiFunction<V, E, C> costFunction, Comparator<C> costComparator);
}
