// LeetCode  - Number of Connected Components in Undirected Graph
// Difficulty: Medium
// Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

// Problem:
// Given n nodes and a list of edges in an undirected graph,
// return the number of connected components.

// Approach: Union Find (Disjoint Set Union)
// Each node starts as its own component.
// For each edge, union the two nodes.
// If they were in different components, decrement count.
// Time: O(n + e * α(n)) ≈ O(n + e) | Space: O(n)

class NumberOfConnectedComponents {
    private int[] parent;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int components = n;

        // Each node is its own parent initially
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            if (rootA != rootB) {
                union(rootA, rootB);
                components--; // two components merged into one
            }
        }

        return components;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int a, int b) {
        // Union by rank — attach smaller tree under larger
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents sol = new NumberOfConnectedComponents();

        System.out.println(sol.countComponents(5, new int[][]{{0,1},{1,2},{3,4}}));
        // Expected: 2

        System.out.println(sol.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}));
        // Expected: 1
    }
}