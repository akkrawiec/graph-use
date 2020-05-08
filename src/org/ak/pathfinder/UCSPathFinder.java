package org.ak.pathfinder;

import org.ak.graph.Graph;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * UCS algorithm implementation
 * @param <V> vertex
 * @param <E> edge
 * @param <C> cost
 */
public class UCSPathFinder<V, E, C> implements PathFinder<V, E, C> {
    @Override
    public List<V> findPath(Graph<V, E> graph, V start, V goal, BiFunction<V, E, C> costFunction, Function<List<C>, C> costSumFunction, Comparator<C> costSumComparator) {
        List<V> result = new ArrayList<V>();
        PriorityQueue<VertexWithTotalCost<V, C>> frontier;
        frontier = new PriorityQueue<VertexWithTotalCost<V, C>>((VertexWithTotalCost<V, C> ve1, VertexWithTotalCost<V, C> ve2) -> costSumComparator.compare(ve1.getTotalCost(), ve2.getTotalCost()));
        Set<V> explored = new HashSet<V>();
        frontier.add(new VertexWithTotalCost(start, costFunction.apply(start, null)));
        while (!frontier.isEmpty()) {
            VertexWithTotalCost<V, C> polledVertex = frontier.poll();
            if (polledVertex.getVertex().equals(goal)) {
                return restorePath(polledVertex);
            }
            explored.add(polledVertex.getVertex());
            for (V neighbour : graph.neighbours(polledVertex.getVertex())) {
                if (!explored.contains(neighbour) && !frontier.stream().anyMatch(vwtc -> vwtc.getVertex().equals(neighbour))) {
                    VertexWithTotalCost<V, C> newVertexToExplore = new VertexWithTotalCost(neighbour, costSumFunction.apply(new ArrayList<C>(){{add(polledVertex.getTotalCost()); add(costFunction.apply(neighbour, graph.getEdge(polledVertex.getVertex(), neighbour)));}}));
                    newVertexToExplore.setPredecessor(polledVertex);
                    frontier.add(newVertexToExplore);
                } else {
                    VertexWithTotalCost<V, C> vertexToExplore = frontier.stream().filter(vwtc -> vwtc.getVertex().equals(neighbour)).findFirst().orElse(null);
                    if (vertexToExplore != null) {
                        C costSum = costSumFunction.apply(new ArrayList<C>(){{add(polledVertex.getTotalCost()); add(costFunction.apply(neighbour, graph.getEdge(polledVertex.getVertex(), neighbour)));}});
                        if (costSumComparator.compare(vertexToExplore.getTotalCost(), costSum) > 0) {
                            vertexToExplore.setTotalCost(costSum);
                            vertexToExplore.setPredecessor(polledVertex);
                        }
                    }
                }
            }
        }
        return result;
    }

    private List<V> restorePath(VertexWithTotalCost<V, C> v) {
        List<V> result = new ArrayList<V>();
        result.add(v.getVertex());
        VertexWithTotalCost<V, C> next = v;
        while (next.getPredecessor() != null) {
            next = next.getPredecessor();
            result.add(next.getVertex());
        }
        return result;
    }

    /**
     * Represens vertex/node with it's total cost from source
     * @param <V> vertex
     * @param <C> total cost
     */
    private class VertexWithTotalCost<V, C> {
        private V vertex;
        private C totalCost;
        private VertexWithTotalCost<V, C> predecessor;

        public VertexWithTotalCost(V vertex, C totalCost) {
            this.vertex = vertex;
            this.totalCost = totalCost;
        }

        public V getVertex() {
            return vertex;
        }

        public void setVertex(V vertex) {
            this.vertex = vertex;
        }

        public C getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(C totalCost) {
            this.totalCost = totalCost;
        }

        public VertexWithTotalCost<V, C> getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(VertexWithTotalCost<V, C> predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public String toString() {
            return "VertexWithTotalCost{" +
                    "vertex=" + vertex +
                    '}';
        }
    }
}
