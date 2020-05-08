package org.ak.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class AdjacencyListGraph<V,E> implements Graph<V, E> {

    private Map<V, Set<E>> vertexEdgesMap = new HashMap<V, Set<E>>();

    @Override
    public boolean addVertex(V v) {
        if (this.vertexEdgesMap.containsKey(v)) {
            return false;
        }
        this.vertexEdgesMap.put(v, new HashSet<E>());
        return true;
    }

    @Override
    public boolean addEdge(E e, V v1, V v2) throws Exception {
        return this.vertexEdgesMap.computeIfAbsent(v1, k -> new HashSet<E>()).add(e) && this.vertexEdgesMap.computeIfAbsent(v2, k -> new HashSet<E>()).add(e);
    }

    @Override
    public E getEdge(V v1, V v2) {
        E edge = vertexEdgesMap.getOrDefault(v1, new HashSet<E>()).stream().filter(e -> vertexEdgesMap.getOrDefault(v2, new HashSet<E>()).contains(e)).findAny().orElse(null);
        return edge;
    }

    @Override
    public List<V> neighbours(V v) {
        List<V> result = new ArrayList<V>();
        Set<E> edges = vertexEdgesMap.getOrDefault(v, new HashSet<E>());
        vertexEdgesMap.forEach((v1, es) -> {if (v1 != v) {
            es.forEach(e -> {
                if (edges.contains(e)) {
                    result.add(v1);
                }});
        }
        });
        return result;
    }

    @Override
    public int numVertices() {
        return vertexEdgesMap.keySet().size();
    }

    @Override
    public List<V> vertices() {
        return vertexEdgesMap.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public List<E> edges() {return null;}

    @Override
    public List<E> adj(V v) {
        return null;
    }
}
