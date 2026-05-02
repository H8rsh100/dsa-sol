// LeetCode #141 - Linked List Cycle
// Difficulty: Easy
// Link: https://leetcode.com/problems/linked-list-cycle/

// Problem:
// Given head of a linked list, determine if the list has a cycle.
// A cycle means some node's next pointer points back to a previous node.

// Approach: Floyd's Cycle Detection (Fast & Slow Pointers)
// Use two pointers — slow moves 1 step, fast moves 2 steps.
// If there's a cycle, fast will eventually lap slow and they'll meet.
// If no cycle, fast will hit null.
// Time: O(n) | Space: O(1)

class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps

            if (slow == fast) return true; // they met — cycle exists
        }

        return false; // fast hit null — no cycle
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        // Build: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle here

        System.out.println(sol.hasCycle(head));
        // Expected: true
    }
}