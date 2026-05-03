// LeetCode #21 - Merge Two Sorted Lists
// Difficulty: Easy
// Link: https://leetcode.com/problems/merge-two-sorted-lists/

// Problem:
// Given heads of two sorted linked lists, merge them into one sorted list.
// Return the head of the merged list.

// Approach: Iterative with dummy node
// Use a dummy node as the starting point so we don't need edge case
// handling for the head. Compare nodes one by one and attach smaller one.
// Time: O(n + m) | Space: O(1)

class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // placeholder head
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes (one list may still have elements)
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next; // actual head is after dummy
    }

    public static void main(String[] args) {
        MergeTwoSortedLists sol = new MergeTwoSortedLists();

        // list1: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // list2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merged = sol.mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Expected: 1 1 2 3 4 4
    }
}