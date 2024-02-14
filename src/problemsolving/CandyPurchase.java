package problemsolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        // Greedily select candies with the lowest cost from the first shop and the highest cost from the second shop
        while (i < N / 2) {
            maxCandies += B[j] - A[i];
            i++;
            j++;
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
        System.out.println(maxCandies(A1, B1)); // Output: 4

    }
}
