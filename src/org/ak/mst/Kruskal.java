package org.ak.mst;

import org.ak.graph.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

public class Kruskal<V, E, C> implements MST<V, E, C> {

    @Override
    public Collection<V> buildTree(Graph graph, BiFunction costFunction, Comparator costSumComparator) {
        Collection<V> mst = new ArrayList<V>();
        PriorityQueue<E> frontier;
        //new PriorityQueue<UCSPathFinder.VertexWithTotalCost<V, C>>((UCSPathFinder.VertexWithTotalCost<V, C> ve1, UCSPathFinder.VertexWithTotalCost<V, C> ve2) -> costSumComparator.compare(ve1.getTotalCost(), ve2.getTotalCost()));

        return null;
    }
}
