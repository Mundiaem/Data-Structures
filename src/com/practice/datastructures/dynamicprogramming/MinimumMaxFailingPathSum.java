package com.practice.datastructures.dynamicprogramming;

public class MinimumMaxFailingPathSum {
    /**
    -try out all the paths
     - recursion : Then tryout all the paths
     - explore all the parts
     - max of all paths sum
        (0, 0) -> (n-1, m-1) -> f(n-1, 0) f(n-1, 1) f(n-1, 2)
     .....
     f(j=0-> m-1){
     [f(n-1, j)]
     }
     f(i, j) -> max path sum to reach (i,j) from any cell from the first row
     f(i, j){

     // trying out all the paths
     if(j<0|| j>=m) return 1e9;
     if(i==0) return a[0][j];

     // explore all the paths
     int s = a[i][j] + f(i-1, j);
     int ld= a[i][j] + f(i-1, j-1);
     int nd= a[i][j] + f(i-1, j+1)
     return max(s, max(ld, nd));
     }

     TC -> 3^n
     SC -> O(N)
     Memoization

     f(i,j){
     for(i-> n-1){
     for(j -> m -1){
     u= a[i][j] + dp[i-1][j];
     if(j-1> =0)-> ld= a[i][j] + dp[i-1][j-1];
     if(j+1< m) -> rd= a[i][j] + dp[i-1][j+1];
     dp[i][j]= max(u, max(ld, nd));
     }
     }
     }

     Tabulation - Bottom up
     1. write the base cases
        - int dp[n][m]
            for(j=0 ->m-1) dp[0][j]= a[0][j];
     2. Observe tje state of (i,j) and convert to loops
         - i -> (1 , n-1)
         - j is dependent on i | j -> (0, m-1)
     3. Tabulation format
     max = dp[n-1] [0]
     for(j=1 -> m-1)
         max= max(max, dp[n-1][i]);
     print max;
     TC -> O(NxM) + O(M)
     SC -> O(NxM)



     */
    private static void mim_max_falling_path_sum(){

    }
    public static void main(String[] args) {

    }
}
