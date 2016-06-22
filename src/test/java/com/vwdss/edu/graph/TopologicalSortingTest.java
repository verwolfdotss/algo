package com.vwdss.edu.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author amelnikov (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class TopologicalSortingTest {
    @Test
    public void testValidSorting() throws Exception {
        int[][] graph = {
                {1},
                {2, 5, 7},
                {},
                {1, 4},
                {5},
                {},
                {4, 7},
                {}
        };

        List<Integer> result = TopologicalSorting.sort(graph);
        validateTopologicalSort(graph, result);
    }

    private static void validateTopologicalSort(int[][] graph, List<Integer> result) {
        for (int i = 0; i < graph.length; i++) {
            int root_pos = result.indexOf(i);
            Assert.assertTrue("Vertex not found", root_pos >= 0);
            for (int j = 0; j < graph[i].length; j++) {
                int child_pos = result.indexOf(graph[i][j]);
                Assert.assertTrue("Vertex not found", child_pos >= 0);
                Assert.assertTrue("Topological sort is invalid", root_pos < child_pos);
            }
        }
    }
}
