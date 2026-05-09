// LeetCode #133 - Clone Graph
// Difficulty: Medium
// Link: https://leetcode.com/problems/clone-graph/

// Problem:
// Given a reference to a node in a connected undirected graph,
// return a deep copy (clone) of the graph.
// Each node has a value and a list of neighbors.

// Approach: DFS + HashMap
// Use a HashMap to map original nodes to their clones.
// If we've already cloned a node, return it (handles cycles).
// Otherwise create a clone, store it, then recursively clone neighbors.
// Time: O(n + e) | Space: O(n) where e = edges

import java.util.*;

class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Already cloned this node — return the clone
        if (visited.containsKey(node)) return visited.get(node);

        // Create clone and store it before recursing (handles cycles)
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}