// LeetCode #20 - Valid Parentheses
// Difficulty: Easy
// Link: https://leetcode.com/problems/valid-parentheses/

// Problem:
// Given a string with '(', ')', '{', '}', '[', ']',
// determine if the input string is valid.
// Valid means: open brackets closed in correct order,
// and every close bracket has a matching open bracket.

// Approach: Stack
// Push opening brackets onto stack.
// When we see a closing bracket, check if top of stack is matching opener.
// If not — invalid. At end, stack should be empty.
// Time: O(n) | Space: O(n)

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Stack empty means no matching opener
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check if popped opener matches current closer
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Valid only if all openers were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();

        System.out.println(sol.isValid("()[]{}"));
        // Expected: true

        System.out.println(sol.isValid("(]"));
        // Expected: false

        System.out.println(sol.isValid("{[]}"));
        // Expected: true

        System.out.println(sol.isValid("([)]"));
        // Expected: false
    }
}