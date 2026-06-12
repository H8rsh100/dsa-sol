// LeetCode #787 - Cheapest Flights Within K Stops
// Difficulty: Medium
// Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/

// Problem:
// Given n cities, flights with costs, find cheapest price
// from src to dst with at most k stops.
// Return -1 if no such route exists.

// Approach: Bellman-Ford (modified)
// Unlike Dijkstra, Bellman-Ford can handle the "at most k stops" constraint
// because it relaxes edges level by level (k+1 iterations).
// Each iteration represents one more allowed stop.
// Time: O(k * E) | Space: O(n)

import java.util.*;

class BellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // Relax edges k+1 times (k stops = k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone(); // snapshot — avoid using updates from same round

            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];

                if (cost[from] != Integer.MAX_VALUE && cost[from] + price < temp[to]) {
                    temp[to] = cost[from] + price;
                }
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public static void main(String[] args) {
        BellmanFord sol = new BellmanFord();

        System.out.println(sol.findCheapestPrice(
            4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},
            0, 3, 1
        ));
        // Expected: 700 (0->1->3)

        System.out.println(sol.findCheapestPrice(
            3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},
            0, 2, 1
        ));
        // Expected: 200 (0->1->2)
    }
}