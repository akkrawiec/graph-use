package org.ak.pathfinder;

import org.ak.graph.Graph;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Floyd–Warshall algorithm implementation
 * @param <V> vertex
 * @param <E> edge
 * @param <C> cost
 */
public class FloydWarshallPathFinder<V, E, C> implements PathFinder<V, E, C> {
    @Override
    public List<V> findPath(Graph<V, E> graph, V start, V goal, BiFunction<V, E, C> costFunction, Function<List<C>, C> costSumFunction, Comparator<C> costSumComparator) {
        List<V> result = new ArrayList<V>();
        int numVertices = graph.numVertices();
        C[][] cost = (C[][]) new Object[numVertices][numVertices];
        V[][] next = (V[][]) new Object[numVertices][numVertices];

        V[] vertices = (V[]) graph.vertices().stream().toArray();

        //initial distances
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    E edge = graph.getEdge(vertices[i], vertices[j]);
                    if (edge != null) {
                        cost[i][j] = costFunction.apply(vertices[j], edge);
                        next[i][j] = vertices[j];
                    }
                }
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i != j) {
                        C cost1 = cost[i][k];
                        C cost2 = cost[k][j];
                        if (cost1 != null && cost2 != null) {
                            C costSum = costSumFunction.apply(new ArrayList<C>(){{add(cost1); add(cost2);}});
                            if (cost[i][j] == null || costSumComparator.compare(cost[i][j], costSum) > 0) {
                                cost[i][j] = costSum;
                                next[i][j] = next[i][k];
                            }
                        }
                    }
                }
            }
        }

        result = restorePath(start, goal, vertices, next);
        return result;
    }

    private List<V> restorePath(V start, V goal, V[] vertices, V[][] next) {
        List<V> result = new ArrayList<V>();
        Map<V, Integer> vertexIndexMap = new HashMap<V, Integer>();
        for (int i = 0; i < vertices.length; i++) {
            vertexIndexMap.put(vertices[i], i);
        }

        if (next[vertexIndexMap.get(start)][vertexIndexMap.get(goal)] == null) {
            return result;
        }

        result.add(goal);
        while (!goal.equals(start)) {
            goal = next[vertexIndexMap.get(goal)][vertexIndexMap.get(start)];
            result.add(goal);
        }
        return result;
    }
}