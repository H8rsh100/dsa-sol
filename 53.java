// LeetCode #127 - Word Ladder
// Difficulty: Hard
// Link: https://leetcode.com/problems/word-ladder/

// Problem:
// Given beginWord, endWord and a wordList,
// return the number of words in the shortest transformation sequence
// from beginWord to endWord, where each step changes exactly one letter
// and every intermediate word must be in wordList.
// Return 0 if no such sequence exists.

// Approach: BFS (Shortest Path)
// BFS guarantees shortest path.
// From each word, try changing every character to a-z.
// If new word is in wordList and not visited — add to queue.
// Count levels until we reach endWord.
// Time: O(m² * n) where m = word length, n = wordList size | Space: O(m * n)

import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try changing every character
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) return steps + 1;

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = original; // restore
                }
            }
            steps++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder sol = new WordLadder();

        System.out.println(sol.ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log","cog")
        ));
        // Expected: 5 (hit→hot→dot→dog→cog)

        System.out.println(sol.ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log")
        ));
        // Expected: 0 (cog not in list)
    }
}