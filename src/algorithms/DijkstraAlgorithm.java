package algorithms;

import java.util.*;

public class DijkstraAlgorithm {

    public static Map<Integer, Integer> shortestPath(
            Map<Integer, List<int[]>> graph,
            int source) {

        Map<Integer, Integer> distance = new HashMap<>();
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{source, 0});
        distance.put(source, 0);

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int dist = current[1];

            if (!graph.containsKey(node)) continue;

            for (int[] neighbor : graph.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDist = dist + weight;

                if (!distance.containsKey(nextNode)
                        || newDist < distance.get(nextNode)) {

                    distance.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        return distance;
    }
}