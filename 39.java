// LeetCode #208 - Implement Trie (Prefix Tree)
// Difficulty: Medium
// Link: https://leetcode.com/problems/implement-trie-prefix-tree/

// Problem:
// Implement a Trie with insert, search, and startsWith methods.
// search: returns true if word exists in trie.
// startsWith: returns true if any word has given prefix.

// Approach: Trie Node with children array
// Each node has 26 children (one per letter a-z).
// Each node has a boolean marking if it's end of a word.
// Insert: walk through chars, create nodes as needed.
// Search: walk through chars, return isEnd at last node.
// StartsWith: walk through chars, return true if path exists.
// Time: O(m) per op where m = word length | Space: O(m * n)

class ImplementTrie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEnd; // must be end of a word
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true; // path exists — prefix found
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}