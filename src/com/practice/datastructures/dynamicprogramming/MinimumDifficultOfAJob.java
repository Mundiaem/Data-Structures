package com.practice.datastructures.dynamicprogramming;
/**
 1335. Minimum Difficulty of a Job Schedule

 You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

 You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

 You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

 Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.



 Example 1:


 Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 Output: 7
 Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 Second day you can finish the last job, total difficulty = 1.
 The difficulty of the schedule = 6 + 1 = 7
*
**/
public class MinimumDifficultOfAJob {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n= jobDifficulty.length;
        if(n<d) return -1;
        int sum=0;
        for(int i =0; i<n; i++){
            sum +=jobDifficulty[i];
        }
        if (sum== 0) return 0;
        int[][] dp = new int [d+1][n];
        helper(jobDifficulty, d, 0, dp);

        return dp[d][0];
    }
    private void helper(int [] jd, int daysLeft, int idx, int [][] dp){
        int len = jd.length;
        if(dp[daysLeft][idx] != 0) return;
        if(daysLeft == 1) {
            int num =0;
            for(int i=idx; i<len; i++){
                num =Math.max(num, jd[i]);
            }
            dp[daysLeft][idx]= num;
            return;
        }
        int max = jd[idx];
        daysLeft--;
        int stop=len -idx -daysLeft +1;
        int res =Integer.MAX_VALUE;
        for(int i=1; i<stop; i++){
            max= Math.max(max, jd[idx+i -1]);
            int other = dp[daysLeft][idx+i];
            if(other==0){
                helper(jd, daysLeft, idx+i, dp);
                other = dp[daysLeft][idx+i];
            }
            res= Math.min(res, other+max);

        }
        dp[daysLeft+1][idx]= res;
    }

    public static void main(String[] args) {

    }

}
