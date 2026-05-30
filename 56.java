// LeetCode #269 - Alien Dictionary
// Difficulty: Hard
// Link: https://leetcode.com/problems/alien-dictionary/

// Problem:
// Given a sorted list of words from an alien language,
// derive the order of characters in that language.
// Return any valid ordering. If invalid (cycle), return "".

// Approach: Topological Sort (BFS - Kahn's Algorithm)
// Compare adjacent words to extract character ordering rules.
// Build a directed graph from these rules.
// Run Kahn's topological sort (BFS with in-degree tracking).
// If all chars processed — valid order. If cycle — return "".
// Time: O(C) where C = total characters | Space: O(1) fixed 26 chars

import java.util.*;

class AlienDictionary {
    public String alienOrder(String[] words) {
        // Build adjacency list and in-degree map for all unique chars
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Extract ordering rules from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Invalid case: prefix word comes after longer word
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    // c1 comes before c2
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break; // only first differing char matters
                }
            }
        }

        // Kahn's BFS topological sort
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.offer(c);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);

            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }

        // If not all chars included — cycle exists
        return result.length() == inDegree.size() ? result.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary sol = new AlienDictionary();

        System.out.println(sol.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
        // Expected: "wertf" (one valid ordering)

        System.out.println(sol.alienOrder(new String[]{"z","x"}));
        // Expected: "zx"

        System.out.println(sol.alienOrder(new String[]{"z","x","z"}));
        // Expected: "" (cycle)
    }
}