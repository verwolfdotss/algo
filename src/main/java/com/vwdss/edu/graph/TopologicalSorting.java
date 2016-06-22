package com.vwdss.edu.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author amelnikov (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class TopologicalSorting {

    public static List<Integer> sort(int[][] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        List<Integer> answer = new ArrayList<>(graph.length);

        topologicalSort(graph, used, answer);

        return answer;
    }

    private static void dfs(int v, int[][] graph, boolean[] used,  List<Integer> answer) {
        used[v] = true;
        for (int i = 0; i < graph[v].length; ++i) {
            int to = graph[v][i];
            if (!used[to])
                dfs(to, graph, used, answer);
        }
        answer.add(v);
    }

    private static void topologicalSort(int[][] graph, boolean[] used,  List<Integer> answer) {
        for (int i = 0; i < graph.length; ++i)
            if (!used[i])
                dfs(i, graph, used, answer);
        Collections.reverse(answer);
    }
}
