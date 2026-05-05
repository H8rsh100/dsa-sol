// LeetCode #70 - Climbing Stairs
// Difficulty: Easy
// Link: https://leetcode.com/problems/climbing-stairs/

// Problem:
// You are climbing a staircase with n steps.
// Each time you can climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?

// Approach: Dynamic Programming (Bottom-Up)
// Ways to reach step i = ways to reach (i-1) + ways to reach (i-2).
// This is literally Fibonacci. Base cases: 1 step = 1 way, 2 steps = 2 ways.
// We only need last 2 values so we use two variables instead of an array.
// Time: O(n) | Space: O(1)

class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2; // ways to reach step i
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();

        System.out.println(sol.climbStairs(2));
        // Expected: 2 (1+1 or 2)

        System.out.println(sol.climbStairs(3));
        // Expected: 3 (1+1+1, 1+2, 2+1)

        System.out.println(sol.climbStairs(5));
        // Expected: 8
    }
}