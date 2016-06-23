package com.vwdss.edu.graph;

import com.vwdss.edu.graph.BellmanFordShortestPath.Edge;
import com.vwdss.edu.graph.BellmanFordShortestPath.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class BellmanFordShortestPathTest {
    @Test
    public void testFindShortestPath() throws Exception {
        Graph graph = new Graph(asList(
                new Edge(0, 1, 10),
                new Edge(1, 2, 20),
                new Edge(0, 2, 40),
                new Edge(0, 4, 10),
                new Edge(4, 3, 5),
                new Edge(3, 2, 5)
        ));

        List<Integer> shortestPath = new BellmanFordShortestPath().findShortestPath(graph, 0, 2);
        List<Integer> expected = Arrays.asList(0, 4, 3, 2);
        Assert.assertEquals("Invalid shortest path", expected, shortestPath);
    }
}
