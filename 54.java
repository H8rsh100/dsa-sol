// LeetCode #212 - Word Search II
// Difficulty: Hard
// Link: https://leetcode.com/problems/word-search-ii/

// Problem:
// Given an m x n board of characters and a list of words,
// return all words that can be found in the board.
// Words can be constructed from letters of sequentially adjacent cells
// (horizontally or vertically), no cell reused.

// Approach: Trie + DFS Backtracking
// Build a Trie from all words.
// DFS from every cell — walk the Trie simultaneously.
// When we reach a Trie node marked as end of word — found it.
// Prune branches not in Trie for efficiency.
// Time: O(m * n * 4 * 3^(L-1)) where L = max word length | Space: O(total chars)

import java.util.*;

class WordSearchII {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // stores word at end node
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = word; // mark end of word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#'; // mark visited

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch; // restore
    }

    public static void main(String[] args) {
        WordSearchII sol = new WordSearchII();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};
        System.out.println(sol.findWords(board, words));
        // Expected: [eat, oath]
    }
}