package com.vwdss.edu.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author amelnikov (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class FindBridges {

    public static Collection<Bridge> findBridges(int[][] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        AtomicInteger timer = new AtomicInteger(0);
        int[] tin = new int[n];
        int[] fup = new int[n];
        List<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            if(!used[i])
                dfs(i, -1, graph, used, tin, fup, timer, bridges);

        return bridges;
    }

    private static void dfs(int v, int p, int[][] graph, boolean[] used, int[] tin, int[] fup, AtomicInteger timer, List<Bridge> bridges) {
        used[v] = true;
        tin[v] = fup[v] = timer.getAndIncrement();
        for (int i = 0; i < graph[v].length; ++i) {
            int to = graph[v][i];
            if (to == p)
                continue;
            if (used[to]) {
                fup[v] = Math.min(fup[v], tin[to]);
            } else {
                dfs(to, v, graph, used, tin, fup, timer, bridges);
                fup[v] = Math.min(fup[v], fup[to]);
                if (fup[to] > tin[v])
                    bridges.add(new Bridge(v, to));
            }
        }
    }

    public static class Bridge {
        private final int from;
        private final int  to;


        public Bridge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Bridge bridge = (Bridge) o;

            if (from != bridge.from) return false;
            return to == bridge.to;

        }

        @Override
        public int hashCode() {
            int result = from;
            result = 31 * result + to;
            return result;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }
}
