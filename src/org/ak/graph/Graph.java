package org.ak.graph;

import java.util.List;

/**
 * Graph ADT
 */
public interface Graph<V, E> {
    /**
     * Adds a vertex to the graph.
     * @param v vertex to add
     * @return false if vertex already exists, otherwise true.
     */
    public boolean addVertex(V v);

    /**
     * Adds a undirected edge between two vertices in the graph.
     * @param e edge to add
     * @param v1 vertex where the edge begins
     * @param v2 vertex where the edge ends
     * @return false if edge already exists, otherwise true.
     * @throws Exception when v1 or v2 does not exist.
     */
    public boolean addEdge(E e, V v1, V v2) throws Exception;

    /**
     *
     * @param v1 first vertex
     * @param v2 second vertex
     * @return edge between given vertices if exists, otherwise null
     */
    public E getEdge(V v1, V v2);

    /**
     * List of neighbours for given vertex
     * @param v vertex
     * @return vertices adjacent to v
     */
    public List<V> neighbours(V v);

    /**
     *
     * @return the number of vertices of the graph
     */
    public int numVertices();

    /**
     *
     * @return all vertices of the graph.
     */
    public List<V> vertices();

    /**
     *
     * @return all edges of the graph.
     */
    public List<E> edges();

    public List<E> adj(V v);

    public static class Factory {
        public static Graph getInstance(GraphRepresentation representation) {
            switch (representation) {
                case MAP_MAP:
                    return new MapMapGraph();
                case ADJACENCY_LIST:
                    return new AdjacencyListGraph();
                case ADJACENCY_MAP:
                    return new AdjacencyMapGraph();
                default:
                    return null;
            }
        }
    }

    public enum GraphRepresentation {
        //ADJACENCY_MATRIX,
        ADJACENCY_LIST,
        ADJACENCY_MAP,
        MAP_MAP
    }
}
