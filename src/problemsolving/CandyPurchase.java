package problemsolving;

import java.util.*;

public class CandyPurchase {

    public static int maxDifferentCandies(int[] A, int[] B) {
        int N = A.length;

        int[] combinedAandB = new int[N * 2];
        for (int i = 0; i < N; i++) {
            combinedAandB[i] = A[i];
            combinedAandB[i + N] = B[i];
        }

        Arrays.sort(combinedAandB);

        Set<Integer> uniqueCandies = new HashSet<>();

        int goldenCoins = N / 2;
        int silverCoins = N / 2;

        for (int i = 0; i < N * 2; i++) {
            int currentCandy = combinedAandB[i];

            if (currentCandy % 2 == 0 && silverCoins > 0) {
                uniqueCandies.add(currentCandy);
                silverCoins--;
            } else if (currentCandy % 2 != 0 && goldenCoins > 0) {
                uniqueCandies.add(currentCandy);
                goldenCoins--;
            }
        }

        return uniqueCandies.size();
    }

    public static int maxCandies(int[] A, int[] B) {
        int N = A.length;

        // Sort the arrays in ascending order for both shops kikruw-8zAhpi-myjsaj
        Arrays.sort(A);
        Arrays.sort(B);

        // Initialize variables to track the current index and the maximum candies
        int i = 0;
        int j = 0;
        int maxCandies = 0;
        Set<Integer> uniqueCandies = new HashSet<>();

        // Greedily select candies with the lowest cost from the first shop and the highest cost from the second shop
        while (i < N / 2) {
            maxCandies += B[j] - A[i];
            i++;
            j++;
        }

        return maxCandies;
    }

    public static int maxDifferentCandiesMap1(int[] A, int[] B) {
        int N = A.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the occurrences of each candy type from both arrays
        for (int i = 0; i < N; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0) + 1);
            countMap.put(B[i], countMap.getOrDefault(B[i], 0) + 1);
        }

        int goldenCoins = N / 2;
        int silverCoins = N / 2;
        int uniqueCandies = 0;

        // Iterate through the count map and buy candies greedily
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int candyType = entry.getKey();
            int count = entry.getValue();

            while (count > 0 && ((candyType % 2 == 0 && silverCoins > 0) || (candyType % 2 != 0 && goldenCoins > 0))) {
                uniqueCandies++;
                count--;
                if (candyType % 2 == 0) {
                    silverCoins--;
                } else {
                    goldenCoins--;
                }
            }
        }

        return uniqueCandies;
    }

    public static int maxDifferentCandiesMap2(int[] A, int[] B) {
        int N = A.length;

        Map<Integer, Integer> candyCount = new HashMap<>();

        // Count occurrences of each candy type in both arrays
        for (int i = 0; i < N; i++) {
            candyCount.put(A[i], candyCount.getOrDefault(A[i], 0) + 1);
            candyCount.put(B[i], candyCount.getOrDefault(B[i], 0) + 1);
        }

        int goldenCoins = N / 2;
        int silverCoins = N / 2;
        int maxCandies = 0;

        // Iterate through candy types and buy candies based on available coins
        for (Map.Entry<Integer, Integer> entry : candyCount.entrySet()) {
            int candyType = entry.getKey();
            int count = entry.getValue();

            if (candyType % 2 == 0 && silverCoins > 0) {
                maxCandies += Math.min(count, silverCoins);
                silverCoins -= Math.min(count, silverCoins);
            } else if (candyType % 2 != 0 && goldenCoins > 0) {
                maxCandies += Math.min(count, goldenCoins);
                goldenCoins -= Math.min(count, goldenCoins);
            }
        }

        return maxCandies;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A1 = {1, 2, 3, 4};
        int[] B1 = {3, 3, 3, 7};
        int[] A2 = {2, 2, 2, 2, 2, 2};
        int[] B2 = {7, 4, 2, 5, 1, 2};
        //System.out.println(maxDifferentCandies(A1, B1)); // Output: 4
        //System.out.println(maxDifferentCandies(A2, B2)); // Output: 4
        //System.out.println(maxCandies(A1, B1)); // Output: 4
       // System.out.println(maxDifferentCandiesMap1(A1, B1)); // Output: 4
        //System.out.println(maxDifferentCandiesMap1(A2, B2)); // Output: 4maxDifferentCandiesMap2
        //System.out.println(maxDifferentCandiesMap2(A1, B1)); // Output: 4
       // System.out.println(maxDifferentCandiesMap2(A2, B2)); // Output: 4
       // System.out.println(pickMaxCandies(A2, B2)); // Output: 4
       // System.out.println(pickMaxCandies(A1, B1)); // Output: 4


    }

    private static int pickMaxCandies(int[] A, int[] B) {
        /***
         * {2, 2, 2, 2, 2, 2};
         *         int[] B2 = {7, 4, 2, 5, 1, 2};
         *         sort: {2, 2, 2, 2, 2, 2} pick -2
         *         {1,2,2,4,5,7] pick - 4,5,7
         */
        Arrays.sort(A);
        Arrays.sort(B);
        int N = A.length;
        int i = 0;
        Set<Integer> uniqueCandies = new HashSet<>();

        while (i < N) {
            if (!uniqueCandies.contains(A[i]) && A[i] != B[i]) {
                uniqueCandies.add(A[i++]);
            } else if (uniqueCandies.contains(A[i]) && A[i] == B[i]) {
                i++;
            } else if (!uniqueCandies.contains(B[i]) && A[i] != B[i]) {
                uniqueCandies.add(B[i++]);
            }else{
                uniqueCandies.add(B[i++]);

            }
        }
        return uniqueCandies.size();
    }
    public static int minPathValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D array to store minimum values on the path
        int[][] minValues = new int[m][n];

        // Initialize the top-left corner
        minValues[0][0] = grid[0][0];

        // Initialize the first row
        for (int i = 1; i < n; i++) {
            minValues[0][i] = Math.min(grid[0][i], minValues[0][i - 1]);
        }

        // Initialize the first column
        for (int j = 1; j < m; j++) {
            minValues[j][0] = Math.min(grid[j][0], minValues[j - 1][0]);
        }

        // Fill the rest of the minValues array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minValues[i][j] = Math.min(Math.min(minValues[i - 1][j], minValues[i][j - 1]), grid[i][j]);
            }
        }

        // The result is the minimum value on the path to the bottom-right corner
        return minValues[m - 1][n - 1];
    }
}
