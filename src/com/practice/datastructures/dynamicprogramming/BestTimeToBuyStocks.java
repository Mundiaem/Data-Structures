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
        Vector<Vector<Long>> dp = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            Vector<Long> row = new Vector<>(2);
            row.addAll(Arrays.asList(-1L, -1L));
            dp.add(row);

        }
        if (n == 0) return 0;
        return f(0, 0, prices, n, dp);
    }

    static long f(int index, int buy, long[] prices, int n, Vector<Vector<Long>> dp) {
        if (index == n) return 0;
        if (dp.get(index).get(buy) != -1) return dp.get(index).get(buy);

        long profit = 0;
        if (buy == 0) {
            profit = Math.max(f(index + 1, 0, prices, n, dp), -prices[index] + f(index + 1, 1, prices, n, dp));
        }
        if (buy == 1) {
            profit = Math.max(f(index + 1, 1, prices, n, dp), prices[index] + f(index + 1, 0, prices, n, dp));

        }
        dp.get(index).set(buy, profit);
        return profit;
    }


}
