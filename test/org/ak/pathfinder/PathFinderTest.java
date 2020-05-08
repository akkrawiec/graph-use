package org.ak.pathfinder;

import org.ak.graph.Graph;
import org.ak.map.City;
import org.ak.map.Road;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 */
class PathFinderTest {
    @Test
    void findPath0AMU() {
        for (Graph.GraphRepresentation r : Graph.GraphRepresentation.values()) {
            for (PathFinder.Algorithm a : PathFinder.Algorithm.values()) {
                findPath0(r,a);
                findPath1(r,a);
                findPath2(r,a);
                findPath3(r,a);
            }
        }
    }

    private void findPath0(Graph.GraphRepresentation representation, PathFinder.Algorithm algorithm) {
        System.out.println("0 Graph: " + representation + ", algorithm: " + algorithm);
        Graph<City, Road> g = Graph.Factory.getInstance(Graph.GraphRepresentation.MAP_MAP);
        City c1 = new City("Warszawa", 1711000, 517);
        City c2 = new City("Gdańsk", 460354, 262);
        City c3 = new City("Gdynia", 248574, 135);

        Road r1 = new Road("S7", 350, 130);

        g.addVertex(c1);
        g.addVertex(c2);
        g.addVertex(c3);
        try {
            g.addEdge(r1, c1, c2);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }


        PathFinder<City, Road, Double> pf = PathFinder.Factory.getInstance(PathFinder.Algorithm.UCS);
        List<City> path = pf.findPath(g, c1, c3, Road :: getRoadAbsoluteCost, doubles ->  doubles.stream().reduce(0d, (d1, d2) -> d1 + d2), Double :: compare);
        assertEquals(0, path.size());
    }

    private void findPath1(Graph.GraphRepresentation representation, PathFinder.Algorithm algorithm) {
        System.out.println("1 Graph: " + representation + ", algorithm: " + algorithm);
        Graph<City, Road> g = Graph.Factory.getInstance(representation);
        City c1 = new City("Warszawa", 1711000, 517);
        City c2 = new City("Gdańsk", 460354, 262);
        City c3 = new City("Gdynia", 248574, 135);

        Road r1 = new Road("S7", 350, 130);
        Road r2 = new Road("", 20, 60);

        g.addVertex(c1);
        g.addVertex(c2);
        g.addVertex(c3);
        try {
            g.addEdge(r1, c1, c2);
            g.addEdge(r2, c2, c3);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        List<City> expectedPath = new ArrayList<City>(){{add(c3); add(c2); add(c1);}};

        PathFinder<City, Road, Double> pf = PathFinder.Factory.getInstance(algorithm);
        List<City> path = pf.findPath(g, c1, c3, Road :: getRoadAbsoluteCost, doubles ->  doubles.stream().reduce(0d, (d1, d2) -> d1 + d2), Double :: compare);
        assertArrayEquals(expectedPath.toArray(), path.toArray());
    }

    private void findPath2(Graph.GraphRepresentation representation, PathFinder.Algorithm algorithm) {
        System.out.println("2 Graph: " + representation + ", algorithm: " + algorithm);
        Graph<City, Road> g = Graph.Factory.getInstance(representation);
        City cA = new City("A", 1, 1);
        City cB = new City("B", 1, 1);
        City cC = new City("C", 1, 1);
        City cD = new City("D", 1, 1);
        City cE = new City("E", 1, 1);
        City cF = new City("F", 1, 1);
        City cG = new City("G", 1, 1);
        City cH = new City("H", 95000, 50);
        City cI = new City("I", 125000, 75);
        City cJ = new City("J", 478000, 148);
        City cK = new City("K", 1, 1);

        Road r1 = new Road("1", 350, 130);
        Road r2 = new Road("2", 10, 60);
        Road r3 = new Road("3", 350, 130);
        Road r4 = new Road("4", 10, 60);
        Road r5 = new Road("5", 350, 130);
        Road r6 = new Road("6", 10, 60);
        Road r7 = new Road("7", 350, 130);
        Road r8 = new Road("8", 10, 60);
        Road r9 = new Road("9", 350, 130);
        Road r10 = new Road("10", 10, 60);
        Road r11 = new Road("11", 350, 130);

        g.addVertex(cA);
        g.addVertex(cB);
        g.addVertex(cC);
        g.addVertex(cD);
        g.addVertex(cE);
        g.addVertex(cF);
        g.addVertex(cG);
        g.addVertex(cH);
        g.addVertex(cI);
        g.addVertex(cJ);
        g.addVertex(cK);

        try {
            g.addEdge(r1, cC, cD);
            g.addEdge(r2, cD, cE);
            g.addEdge(r3, cD, cA);
            g.addEdge(r4, cA, cF);
            g.addEdge(r5, cA, cG);
            g.addEdge(r6, cA, cH);
            g.addEdge(r7, cA, cK);
            g.addEdge(r8, cH, cI);
            g.addEdge(r9, cI, cJ);
            g.addEdge(r10, cJ, cB);
            g.addEdge(r11, cK, cB);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        List<City> expectedPath = new ArrayList<City>(){{add(cB); add(cJ); add(cI); add(cH); add(cA);}};
        PathFinder<City, Road, Double> pf = PathFinder.Factory.getInstance(algorithm);
        List<City> path = pf.findPath(g, cA, cB, Road :: getRoadAbsoluteCost, doubles ->  doubles.stream().reduce(0d, (d1, d2) -> d1 + d2), Double :: compare);
        assertArrayEquals(expectedPath.toArray(), path.toArray());
    }

    private void findPath3(Graph.GraphRepresentation representation, PathFinder.Algorithm algorithm) {
        System.out.println("3 Graph: " + representation + ", algorithm: " + algorithm);
        Graph<City, Road> g = Graph.Factory.getInstance(representation);
        City cA = new City("A", 1, 1);
        City cB = new City("B", 1, 1);
        City cC = new City("C", 1, 1);
        City cD = new City("D", 1, 1);
        City cE = new City("E", 1, 1);
        City cF = new City("F", 1, 1);
        City cG = new City("G", 1, 1);
        City cH = new City("H", 95000, 50);
        City cI = new City("I", 125000, 75);
        City cJ = new City("J", 478000, 148);
        City cK = new City("K", 1, 1);

        Road r1 = new Road("1", 350, 130);
        Road r2 = new Road("2", 10, 60);
        Road r3 = new Road("3", 350, 130);
        Road r4 = new Road("4", 10, 60);
        Road r5 = new Road("5", 350, 130);
        Road r6 = new Road("6", 10, 60);
        Road r7 = new Road("7", 350, 130);
        Road r8 = new Road("8", 10, 60);
        Road r9 = new Road("9", 350, 130);
        Road r10 = new Road("10", 10, 60);
        Road r11 = new Road("11", 350, 130);

        g.addVertex(cA);
        g.addVertex(cB);
        g.addVertex(cC);
        g.addVertex(cD);
        g.addVertex(cE);
        g.addVertex(cF);
        g.addVertex(cG);
        g.addVertex(cH);
        g.addVertex(cI);
        g.addVertex(cJ);
        g.addVertex(cK);

        try {
            g.addEdge(r1, cC, cD);
            g.addEdge(r2, cD, cE);
            g.addEdge(r3, cD, cA);
            g.addEdge(r4, cA, cF);
            g.addEdge(r5, cA, cG);
            g.addEdge(r6, cA, cH);
            g.addEdge(r7, cA, cK);
            g.addEdge(r8, cH, cI);
            g.addEdge(r9, cI, cJ);
            g.addEdge(r10, cJ, cB);
            g.addEdge(r11, cK, cB);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        List<City> expectedPath = new ArrayList<City>(){{add(cB); add(cK); add(cA);}};
        PathFinder<City, Road, Double> pf = PathFinder.Factory.getInstance(algorithm);
        List<City> path = pf.findPath(g, cA, cB, City :: getRoadRelativeCost, doubles ->  doubles.stream().reduce(0d, (d1, d2) -> d1 + d2), Double :: compare);
        assertArrayEquals(expectedPath.toArray(), path.toArray());
    }
}