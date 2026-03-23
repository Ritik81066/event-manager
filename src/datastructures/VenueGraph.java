package datastructures;

import java.util.*;

public class VenueGraph {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v1, int v2) {

        graph.putIfAbsent(v1, new ArrayList<>());
        graph.putIfAbsent(v2, new ArrayList<>());

        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.println(node);

            for (int neighbor : graph.get(node)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}