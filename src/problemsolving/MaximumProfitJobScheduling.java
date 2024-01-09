package problemsolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 */
class Jobs {
    int startTime;
    int endTime;
    int profit;

    public Jobs(int start_time, int end_time, int profit) {
        this.endTime = end_time;
        this.startTime = start_time;
        this.profit = profit;
    }
}


public class MaximumProfitJobScheduling {
    private static int maximumProfitJobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Jobs[] jobs = new Jobs[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Jobs(startTime[i], endTime[i], profit[i]);
        }
        // Sorting the 'jobs' array based on endTime using Comparator.comparingInt()
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));
        // TreeMap to store the maximum profit achievable at each endTime
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        // Initializing the TreeMap with endTime 0 and profit 0
        dp.put(0, 0);
        // Loop through each job
        for (Jobs job : jobs) {
            // Calculate the current profit by considering the maximum profit achievable until job.startTime
            int curr = dp.floorEntry(job.startTime).getValue() + job.profit;
            // Check if the current profit is greater than the last entry in dp (maximum profit achieved so far)
            if (curr > dp.lastEntry().getValue()) {
                // If yes, update the TreeMap with the current endTime and corresponding profit
                dp.put(job.endTime, curr);
            }
        }
        // Return the maximum profit achieved, which is the profit at the last entry in the TreeMap
        return dp.lastEntry().getValue();


        /**
         * Explanation:
         *
         * Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));:
         * This line sorts the jobs array based on the endTime attribute of the Jobs objects using Comparator.comparingInt().
         * TreeMap<Integer, Integer> dp = new TreeMap<>();
         *
         * It initializes a TreeMap called dp to store the maximum profit achievable at each endTime.
         * dp.put(0, 0);:
         * Initializes the TreeMap dp with an initial entry of endTime 0 and profit 0.
         * Looping through each job in the sorted jobs array:
         * Calculates the curr profit, which represents the maximum profit achievable until the job.startTime by considering the previous maximum profit.
         * Uses dp.floorEntry(job.startTime).getValue() to get the maximum profit achievable until job.startTime.
         * if (curr > dp.lastEntry().getValue()) { ... }:
         * Checks if the current profit (curr) is greater than the last entry's profit in the dp TreeMap.
         * If the current profit is greater:
         * Updates the dp TreeMap with a new entry at job.endTime with the calculated profit curr.
         * Finally, return dp.lastEntry().getValue();:
         * Returns the maximum profit achievable, which corresponds to the profit at the endTime of the last entry in the dp TreeMap.
         * This algorithm utilizes dynamic programming (DP) principles to optimize the profit calculation for jobs within a given time frame.
         */
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(maximumProfitJobScheduling(startTime, endTime, profit));

    }

}
