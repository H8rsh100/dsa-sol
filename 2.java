// LeetCode #206 - Reverse Linked List
// Difficulty: Easy
// Link: https://leetcode.com/problems/reverse-linked-list/

// Problem:
// Given the head of a singly linked list, reverse it and return the new head.

// Approach: Iterative with 3 pointers
// We walk through the list keeping track of prev, current, and next.
// At each step we reverse the current node's pointer to point backwards.
// Time: O(n) | Space: O(1)

class ReverseLinkedList {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next node before we overwrite
            curr.next = prev;          // reverse the pointer
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // prev is now the new head
    }

    // Quick test
    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();

        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = sol.reverseList(head);

        // Print result
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        
    }
}