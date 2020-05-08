package org.ak.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 */
public class MapMapGraph<V, E> implements Graph<V, E> {

    private Map<V, Set<E>> vertices = new HashMap<V, Set<E>>();
    private Map<E, Set<V>> edges = new HashMap<E, Set<V>>();

    @Override
    public boolean addVertex(V v) {
        if (this.vertices.containsKey(v)) {
            return false;
        }
        this.vertices.put(v, new HashSet<E>());
        return true;
    }

    @Override
    public boolean addEdge(E e, V v1, V v2) throws Exception {
        if (this.edges.containsKey(e)) {
            return false;
        }
        if (!this.vertices.containsKey(v1) || !this.vertices.containsKey(v2)) {
            throw new RuntimeException("Vertex does not exist");
        }
        this.edges.put(e, Stream.of(v1, v2).collect(Collectors.toCollection(HashSet::new)));
        this.vertices.computeIfAbsent(v1, k -> new HashSet<E>()).add(e);
        this.vertices.computeIfAbsent(v2, k -> new HashSet<E>()).add(e);
        return true;
    }

    @Override
    public E getEdge(V v1, V v2) {
        Set<E> edges = this.vertices.getOrDefault(v1, new HashSet<E>());
        for (E e : edges) {
            if (this.edges.get(e).contains(v2)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<V> neighbours(V v) {
        Stream<V> result = Stream.empty();
        for (E e : this.vertices.getOrDefault(v, new HashSet<E>())) {
            result = Stream.concat(result,this.edges.get(e).stream().filter(v1 -> !v1.equals(v)));
        }
        return result.collect(Collectors.toList());
    }

    @Override
    public int numVertices() {
        return vertices.keySet().size();
    }

    @Override
    public List<V> vertices() { return vertices.keySet().stream().collect(Collectors.toList()); }

    @Override
    public List<E> edges() { return edges.keySet().stream().collect(Collectors.toList()); }

    @Override
    public List<E> adj(V v) {
        return vertices.get(v).stream().collect(Collectors.toList() );
    }

    @Override
    public String toString() {
        String graph = "";
        for (V k : this.vertices.keySet()) {
            graph = graph.concat(k + "");
            for (E e : this.vertices.get(k)) {
                graph = graph.concat("\t -(" + e + ")- ");
                for (V v : this.edges.get(e)) {
                    if (!v.equals(k)) {
                        graph = graph.concat(v + "\n");
                    }
                }
            }
        }
        return graph;
    }
}
