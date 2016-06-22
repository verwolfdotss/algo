package com.vwdss.edu.graph;

import com.vwdss.edu.graph.FindBridges.Bridge;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author amelnikov (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class FindBridgesTest {
    @Test
    public void testGraphWithNoBridges() throws Exception {
        int[][] graph = {
                {1, 2},
                {0, 2},
                {0, 1, 4, 3},
                {2, 4, 5},
                {2, 3, 5},
                {4, 3}
        };

        Collection<Bridge> bridges = new FindBridges().findBridges(graph);
        Assert.assertTrue("Bridges should not be found", bridges.isEmpty());
    }

    @Test
    public void testGraphWithOneBridge() throws Exception {
        int[][] graph = {
                {1, 2},
                {0, 2},
                {0, 1, 3},
                {2, 4, 5},
                {3, 5},
                {4, 3}
        };

        Collection<Bridge> bridges = new FindBridges().findBridges(graph);
        Assert.assertEquals("One bridge should be found", 1, bridges.size());
        Assert.assertEquals("Invalid bridge was found", new Bridge(2, 3), bridges.iterator().next());
    }


    @Test
    public void testGraphWithMultipleBridges() throws Exception {
        int[][] graph = {
                {1, 2, 6},
                {0, 2},
                {0, 1, 3},
                {2, 4, 5},
                {3, 5},
                {4, 3},
                {0,8,7},
                {6,8},
                {6,7}
        };

        Collection<Bridge> bridges = new FindBridges().findBridges(graph);
        Assert.assertEquals("Two bridges should be found", 2, bridges.size());
        Assert.assertTrue("Invalid bridge was found", bridges.containsAll(asList(new Bridge(2, 3), new Bridge(0, 6))));
    }
}
