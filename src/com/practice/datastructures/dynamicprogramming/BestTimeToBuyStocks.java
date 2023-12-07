package com.practice.datastructures.dynamicprogramming;

import com.practice.datastructures.Tries.MaximumXORQueries;

import java.util.*;

/*
            Recursion
* Express everything in terms of index
*  buy - sell, buy - sell
* Explore possibilities on that day
* Take the max all profits made
* Base case
* f(index buy){ //- what maximum profit can you give me
* //Explore possibilities for that day
  if(index==n) return 0;
 if(buy){
  profit= prices[index] + f(index+1, 0)+f(index+1, 1)// take - not take
  else
  profit =max( prices[index] + f(index+1,1 ), 0+f(index+1, 0)) //take - not take
 return profit;

     Time Complexities
     O(2n)
     Space Complexities
     O(N)

        Memoization
* over rapping sub problems
*
* index (N) -  buy (2)
* dp[index][buy]
* if(dp[index][buy]== 0) return 0;

  */
public class BestTimeToBuyStocks {

    public static void main(String[] args) {
        long[] prices = {7, 1, 5, 3, 6, 4};
        System.out.printf("Maximum profit is %s", bestTimeToBuy(prices, prices.length));
    }

    private static long bestTimeToBuy(long[] prices, int n) {
        // Create a 2D Vector to store the memoization table for dynamic programming
        Vector<Vector<Long>> dp = new Vector<>(n);

        // Initialize the memoization table with -1 values
        for (int i = 0; i < n; i++) {
            Vector<Long> row = new Vector<>(2);
            row.addAll(Arrays.asList(-1L, -1L)); // Each cell in the table stores two values for buy and sell states
            dp.add(row);
        }

        // If there are no prices, return 0 profit
        if (n == 0) return 0;

        // Call the recursive function to calculate the maximum profit
        return f(0, 0, prices, n, dp); // Start with index 0 and the buy state as 0 (not holding any stock)
    }

    // Recursive function to compute the maximum profit using memoization
    static long f(int index, int buy, long[] prices, int n, Vector<Vector<Long>> dp) {
        // Base case: If the index reaches the end, return 0
        if (index == n) return 0;

        // If the result for the current state (index, buy) is already computed, return it from the memoization table
        if (dp.get(index).get(buy) != -1) return dp.get(index).get(buy);

        long profit = 0;
        // If in the buy state (buy = 0)
        if (buy == 0) {
            // Calculate the maximum profit by either not buying or buying at the current price
            profit = Math.max(
                    f(index + 1, 0, prices, n, dp), // Not buying the stock at the current index
                    -prices[index] + f(index + 1, 1, prices, n, dp) // Buying the stock at the current index
            );
        }
        // If in the sell state (buy = 1)
        if (buy == 1) {
            // Calculate the maximum profit by either not selling or selling at the current price
            profit = Math.max(
                    f(index + 1, 1, prices, n, dp), // Not selling the stock at the current index
                    prices[index] + f(index + 1, 0, prices, n, dp) // Selling the stock at the current index
            );
        }
        // Store the computed profit in the memoization table
        dp.get(index).set(buy, profit);
        return profit;
    }
}
