package org.ak.mst;

import org.ak.graph.Graph;

import java.util.*;
import java.util.function.BiFunction;

public class Prim <V, E, C> implements MST<V, E, C> {
    private boolean[] marked; // MST vertices
    private Queue<E> mst; // MST edges
    private Queue<E> pq; // crossing (and ineligible) edges

    @Override
    public Collection<V> buildTree(Graph<V, E> graph, BiFunction<V, E, C> costFunction, Comparator<C> costComparator) {
        Collection<V> mst = new ArrayList<V>();
        Map<V, E> c = new HashMap<V, E>();
        graph.vertices().stream().forEach(v -> c.put(v, null));
        Map<V, E> e = new HashMap<V, E>();
        graph.vertices().stream().forEach(v -> e.put(v, null));
        PriorityQueue<V> q = new PriorityQueue<V>((V v1, V v2) -> costComparator.compare(costFunction.apply(v1, null), costFunction.apply(v2, null))); //(graph.vertices());
        while (!q.isEmpty()) {

        }

        return mst;
    }
}


/*
        Map<V, E> d = new HashMap<V, E>();

        for (V v : graph.vertices()) {
            E e =graph.adj(v).stream().min((E e1, E e2) -> costComparator.compare(costFunction.apply(null, e1), costFunction.apply(null, e2))).get();
            d.put(v, e);
        }
*/
