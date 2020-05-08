package org.ak.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 */
public class GraphTest {

    @Test
    void addVertexAL() {
        addVertex(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    @Test
    void addEdgeAL() {
        addEdge(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    @Test
    void getEdgeAL() {
        getEdge(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    @Test
    void getEdgeNullAL() {
        getEdgeNull(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    @Test
    void neighboursAL() {
        neighbours(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    @Test
    void numVerticesAL() {
        numVertices(Graph.GraphRepresentation.ADJACENCY_LIST);
    }

    //----------------------------------------------------------------------------------------
    @Test
    void addVertexAM() {
        addVertex(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    @Test
    void addEdgeAM() {
        addEdge(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    @Test
    void getEdgeAM() {
        getEdge(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    @Test
    void getEdgeNullAM() {
        getEdgeNull(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    @Test
    void neighboursAM() {
        neighbours(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    @Test
    void numVerticesAM() {
        numVertices(Graph.GraphRepresentation.ADJACENCY_MAP);
    }

    //----------------------------------------------------------------------------------------
    @Test
    void addVertexMM() {
        addVertex(Graph.GraphRepresentation.MAP_MAP);
    }

    @Test
    void addEdgeMM() {
        addEdge(Graph.GraphRepresentation.MAP_MAP);
    }

    @Test
    void getEdgeMM() {
        getEdge(Graph.GraphRepresentation.MAP_MAP);
    }

    @Test
    void getEdgeNullMM() {
        getEdgeNull(Graph.GraphRepresentation.MAP_MAP);
    }

    @Test
    void neighboursMM() {
        neighbours(Graph.GraphRepresentation.MAP_MAP);
    }

    @Test
    void numVerticesMM() {
        numVertices(Graph.GraphRepresentation.MAP_MAP);
    }

    private void addVertex(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        assertTrue(g.addVertex("v1"));
        assertTrue(g.neighbours("v1").isEmpty());
    }

    private void addEdge(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        g.addVertex("v1");
        g.addVertex("v2");

        try {
            assertTrue(g.addEdge("e1", "v1","v2"));
        } catch (Exception e) {
        }
        assertEquals(new ArrayList() {{add("v2");}}, g.neighbours("v1"));
        assertEquals(new ArrayList() {{add("v1");}}, g.neighbours("v2")); ;
    }

    private void getEdge(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        g.addVertex("v1");
        g.addVertex("v2");

        try {
            g.addEdge("e1", "v1","v2");
        } catch (Exception e) {
        }
        assertEquals("e1", g.getEdge("v1", "v2"));
        assertEquals("e1", g.getEdge("v2", "v1"));
    }

    private void getEdgeNull(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        g.addVertex("v1");
        g.addVertex("v2");

        try {
            g.addEdge("e1", "v1","v2");
        } catch (Exception e) {
        }
        assertNull(g.getEdge("v1", "v3"));
        assertNull(g.getEdge("v3", "v4"));
    }

    private void neighbours(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addVertex("v4");

        try {
            g.addEdge("e1", "v1","v2");
            g.addEdge("e2", "v1","v3");
        } catch (Exception e) {
        }
        assertEquals(new ArrayList() {{add("v2"); add("v3");}}, g.neighbours("v1"));
        assertEquals(new ArrayList() {{add("v1");}}, g.neighbours("v2"));
        assertEquals(new ArrayList() {{add("v1");}}, g.neighbours("v3"));
        assertEquals(new ArrayList(), g.neighbours("v4"));
        assertEquals(new ArrayList(), g.neighbours("v5"));
    }

    private void numVertices(Graph.GraphRepresentation representation) {
        Graph<String, String> g = Graph.Factory.getInstance(representation);
        assertEquals(0, g.numVertices());
        g.addVertex("v1");
        g.addVertex("v2");
        assertEquals(2, g.numVertices());
    }
}