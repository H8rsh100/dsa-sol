// LeetCode #743 - Network Delay Time
// Difficulty: Medium
// Link: https://leetcode.com/problems/network-delay-time/

// Problem:
// Given a network of n nodes and travel times for directed edges,
// find how long it takes for all nodes to receive a signal
// sent from node k. Return -1 if impossible.

// Approach: Dijkstra's Algorithm
// Classic shortest path from single source.
// Use min heap — always process the closest unvisited node.
// Relax edges — if new path is shorter, update distance.
// Time: O((V + E) log V) | Space: O(V + E)

import java.util.*;

class Dijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Distance array — infinity initially
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min heap: [distance, node]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int d = curr[0], node = curr[1];

            // Skip if we already found a shorter path
            if (d > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                int newDist = dist[node] + weight;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    minHeap.offer(new int[]{newDist, next});
                }
            }
        }

        // Find max distance — that's when last node receives signal
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Dijkstra sol = new Dijkstra();

        System.out.println(sol.networkDelayTime(
            new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2
        ));
        // Expected: 2

        System.out.println(sol.networkDelayTime(
            new int[][]{{1,2,1}}, 2, 1
        ));
        // Expected: 1

        System.out.println(sol.networkDelayTime(
            new int[][]{{1,2,1}}, 2, 2
        ));
        // Expected: -1 (node 1 unreachable from node 2)
    }
}