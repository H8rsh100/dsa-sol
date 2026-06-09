// LeetCode #1584 - Min Cost to Connect All Points
// Difficulty: Medium
// Link: https://leetcode.com/problems/min-cost-to-connect-all-points/

// Problem:
// Given n points on a 2D plane, connect all points with minimum cost.
// Cost between two points = Manhattan distance |xi-xj| + |yi-yj|.
// Return the minimum cost to connect all points (Minimum Spanning Tree).

// Approach: Prim's Algorithm
// Start from any node. Greedily pick the cheapest edge
// that connects a new node to the current tree.
// Use min heap to always pick the cheapest available edge.
// Time: O(n² log n) | Space: O(n)

import java.util.*;

class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        // Min heap: [cost, node]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0});

        int totalCost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            int[] curr = minHeap.poll();
            int cost = curr[0], node = curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            totalCost += cost;
            edgesUsed++;

            // Update distances to all unvisited nodes
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int dist = Math.abs(points[node][0] - points[next][0])
                             + Math.abs(points[node][1] - points[next][1]);
                    if (dist < minDist[next]) {
                        minDist[next] = dist;
                        minHeap.offer(new int[]{dist, next});
                    }
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints sol = new MinCostToConnectAllPoints();

        System.out.println(sol.minCostConnectPoints(
            new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}
        ));
        // Expected: 20

        System.out.println(sol.minCostConnectPoints(
            new int[][]{{3,12},{-2,5},{-4,1}}
        ));
        // Expected: 18
    }
}