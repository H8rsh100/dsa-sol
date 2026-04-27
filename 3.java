// LeetCode #121 - Best Time to Buy and Sell Stock
// Difficulty: Easy
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Problem:
// Given an array of prices where prices[i] is the price on day i,
// return the maximum profit you can achieve. If no profit possible, return 0.

// Approach: One Pass - Track minimum price seen so far
// We don't need to check every pair. Just track the lowest price we've seen,
// and at each step calculate profit if we sold today.
// Time: O(n) | Space: O(1)

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Found a cheaper buying point
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // Found a better profit
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // Expected: 5 (buy at 1, sell at 6)

        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));
        // Expected: 0 (prices only go down, no profit possible)
    }
}