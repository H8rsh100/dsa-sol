// LeetCode #155 - Min Stack
// Difficulty: Medium
// Link: https://leetcode.com/problems/min-stack/

// Problem:
// Design a stack that supports push, pop, top, and
// retrieving the minimum element — all in O(1) time.

// Approach: Two Stacks
// One stack stores all values normally.
// Second stack stores the current minimum at every level.
// When we push, push to both — min stack gets min(current, top of min stack).
// When we pop, pop from both.
// This way getMin() is always O(1).
// Time: O(1) all ops | Space: O(n)

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push current minimum to minStack
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop(); // always pop both together
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek(); // always O(1)
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin()); // Expected: -3
        ms.pop();
        System.out.println(ms.top());    // Expected: 0
        System.out.println(ms.getMin()); // Expected: -2
    }
}