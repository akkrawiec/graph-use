package org.ak.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    private Map<V, Map<V, E>> vertexVertexEdgeMap = new HashMap<V, Map<V, E>>();

    @Override
    public boolean addVertex(V v) {
        if (this.vertexVertexEdgeMap.containsKey(v)) {
            return false;
        }
        this.vertexVertexEdgeMap.put(v, new HashMap<V, E>());
        return true;
    }

    @Override
    public boolean addEdge(E e, V v1, V v2) throws Exception {
        return this.vertexVertexEdgeMap.computeIfAbsent(v1, k -> new HashMap<V, E>()).put(v2, e) == null && this.vertexVertexEdgeMap.computeIfAbsent(v2, k -> new HashMap<V, E>()).put(v1 , e) == null;
    }

    @Override
    public E getEdge(V v1, V v2) {
        return this.vertexVertexEdgeMap.getOrDefault(v1, new HashMap<V, E>()).get(v2);
    }

    @Override
    public List<V> neighbours(V v) {
        return this.vertexVertexEdgeMap.getOrDefault(v, new HashMap<V, E>()).keySet().stream().collect(Collectors.toList());
    }

    @Override
    public int numVertices() {
        return vertexVertexEdgeMap.keySet().size();
    }

    @Override
    public List<V> vertices() {
        return vertexVertexEdgeMap.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public List<E> edges() {return null;}

    @Override
    public List<E> adj(V v) {
        return null;
    }
}
