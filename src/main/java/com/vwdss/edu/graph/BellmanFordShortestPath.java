package com.vwdss.edu.graph;

import java.util.*;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class BellmanFordShortestPath {

    public static List<Integer> findShortestPath(Graph g, int from, int to) {
        int[] p = new int[g.vertexes];
        Arrays.fill(p, -1);
        int[] d = new int[g.vertexes];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[from] = 0;

        while (true) {
            boolean action = false;

            for (int i = 0; i < g.edges.size(); i++) {
                Edge edge = g.edges.get(i);
                if (d[edge.a] < Integer.MAX_VALUE)
                    if (d[edge.b] > d[edge.a] + edge.cost) {
                        d[edge.b] = d[edge.a] + edge.cost;
                        p[edge.b] = edge.a;
                        action = true;
                    }
            }

            if (!action)
                break;

        }

        if (d[to] == Integer.MAX_VALUE) {
            return Collections.emptyList();
        } else {
            List<Integer> vertexes = new ArrayList<>();
            for (int cur=to; cur!=-1; cur=p[cur])
                    vertexes.add(cur);

            Collections.reverse(vertexes);
            return vertexes;
        }
    }

    public static class Graph {
        private final List<Edge> edges;
        private final int vertexes;

        public Graph(List<Edge> edges) {
            this.edges = edges;
            Set<Integer> set = new HashSet<>();
            for (Edge edge : edges) {
                set.add(edge.a);
                set.add(edge.b);
            }
            this.vertexes = set.size();
        }
    }


    public static class Edge {
        private final int a;
        private final int b;
        private final int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return a + " -> " + b + " @ " + cost;
        }
    }
}
