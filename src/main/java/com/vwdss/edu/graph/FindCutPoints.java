package com.vwdss.edu.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class FindCutPoints {
    private int[][] graph;

    private boolean[] used;
    private int[] tin;
    private int[] fup;

    private AtomicInteger timer = new AtomicInteger();
    private List<Integer> cutPoints  = new ArrayList<>();

    public Collection<Integer> findCutPoints(int[][] graph) {
        int n = init(graph);

        for (int i = 0; i < n; ++i)
            if(!used[i])
                dfs(i, -1);

        return new ArrayList<>(cutPoints);
    }

    private void dfs(int v, int p) {
        used[v] = true;
        tin[v] = fup[v] = timer.getAndIncrement();
        int children = 0;
        for (int i = 0; i < graph[v].length; ++i) {
            int to = graph[v][i];
            if (to == p)
                continue;
            if (used[to]) {
                fup[v] = Math.min(fup[v], tin[to]);
            } else {
                dfs(to, v);
                fup[v] = Math.min(fup[v], fup[to]);
                if (fup[to] >= tin[v] && p != -1)
                    cutPoints.add(v);

                children++;
            }
        }

        if (p == -1 && children > 1)
            cutPoints.add(v);
    }

    private int init(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        used = new boolean[n];
        timer.set(0);
        tin = new int[n];
        fup = new int[n];
        cutPoints.clear();
        return n;
    }
}
