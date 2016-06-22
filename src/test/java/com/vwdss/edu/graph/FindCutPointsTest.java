package com.vwdss.edu.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class FindCutPointsTest {
    @Test
    public void testGraphWithNoCutPoints() throws Exception {
        int[][] graph = {
                {1, 2, 4},
                {0, 2},
                {0, 1, 3},
                {2, 4, 5},
                {0, 3, 5},
                {4, 3}
        };

        Collection<Integer> cutPoints = new FindCutPoints().findCutPoints(graph);
        Assert.assertTrue("Cut points should not be found", cutPoints.isEmpty());
    }

    @Test
    public void testGraphWithMultipleCutPoints() throws Exception {
        int[][] graph = {
                {1, 2},
                {0, 2},
                {0, 1, 3},
                {2, 4, 5},
                {3, 5},
                {4, 3}
        };

        Collection<Integer> cutPoints = new FindCutPoints().findCutPoints(graph);
        Assert.assertEquals("Two cut points should be found", 2, cutPoints.size());
        Assert.assertTrue("Invalid cut points were found", cutPoints.containsAll(asList(2,3)));
    }


    @Test
    public void testGraphWithSingleCutPoint() throws Exception {
        int[][] graph = {
                {1, 2},
                {0, 2},
                {0, 1, 3, 4},
                {2, 4},
                {3, 2}
        };

        Collection<Integer> cutPoints = new FindCutPoints().findCutPoints(graph);
        Assert.assertEquals("One cut point should be found", 1, cutPoints.size());
        Assert.assertTrue("Invalid cut point was found", cutPoints.contains(2));
    }
}
